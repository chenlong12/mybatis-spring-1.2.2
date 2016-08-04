![aaa](https://camo.githubusercontent.com/196d30052623ff7b233765c5f641dbc8ae2f287d/687474703a2f2f6d7962617469732e6769746875622e696f2f696d616765732f6d7962617469732d6c6f676f2e706e67)

##info
>MyBatis-Spring is an easy-to-use Spring3 bridge for MyBatis sql mapping framework.
See the docs in: http://mybatis.github.com/spring
Download sources, jars and bundles from: http://repo1.maven.org/maven2/org/mybatis/mybatis-spring/

###更新说明：
* 加入可配置 mapperProxy
* 加入dao层注解配置缓存支持，方便分库分表，仅支持简单查询，不支持join

###使用缓存解决问题
>大数据环境下，分库分表，都是简单查询，缓存Key的生成机制是业务自己生成，
而不是依赖底层mybatis的缓存机制，很多项目的dao层都是两层，第一层是和mysql
交互的部分，第二层是业务自己加的缓存，需要硬编码写代码，另外，需要手动
清理缓存，如果忘记清理关键key，数据可能不一致，使用注解的方式加缓存，
在所有更新或者添加时，删除更新了的缓存数据，方便获取最新数据，另外，
还可以依赖其他系统，比如后台是php的，更新了db之后，把table中的数据
同步过来，缓存也会清除。

###使用全注解加缓存Example
* [订单Dao层定义](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/cache/dao/OrderInfoDao.java)
* [订单Dao层SQL mybatis xml](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/cache/mapping/OrderInfoDao.xml)
* [订单POJO定义](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/cache/pojo/OrderInfo.java)
* [缓存Redis与mybatis proxy配置](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/cache/xml/spring-mybatis.xml)
* [使用JAVAbean注解自动生成Dao和mybatis xml文件](https://github.com/lindzh/mybatis-generator)
* [缓存注解依赖mybatis版本--分支3.2.x](https://github.com/lindzh/mybatis-3/tree/3.2.x)

###Dao层添加使用原理与教程
```java
@RedisCache(operate=OperateType.SELECT,key="id",prefix="user_",refKey="id",refPrefix="user_")
public UserInfo getById(@Param("id")long id);
```

###@RedisCache字段说明
>operate:缓存类型，与查询SQL一致，multiselect除外
key:影响范围取值字段，加入更新字段，方便删除
prefix:cache object前缀
refkey:cache组
refPrefix ：cache组
cache组=refPrefix+refKey

```java
@RedisCache(operate=OperateType.INSERT,refKey="id",refPrefix="user_")
	public int addUserInfo(UserInfo obj);
	/**
	 * ref select sql
	 * @param id
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="id",prefix="user_",refKey="id",refPrefix="user_")
	public UserInfo getById(@Param("id")long id);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="user_")
	public int updateById(@Param("obj")UserInfo obj);
	
	@RedisCache(operate=OperateType.DELETE,refKey="id",refPrefix="user_")
	public int deleteById(@Param("id")long id);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="user_")
	public int updateScoreById(@Param("id")long id,@Param("score")double score);
	
	@RedisCache(operate=OperateType.SELECT,key="mobile",prefix="user_getByMobile_",refPrefix="user_",refKey="id")
	public UserInfo getByMobile(@Param("mobile")String mobile);
	
	@RedisCache(operate=OperateType.SELECT,key="token",prefix="user_getByToken_",refPrefix="user_",refKey="id")
	public UserInfo getByToken(@Param("token")String token);
	
	@RedisCache(operate=OperateType.SELECT,key="community_id",prefix="user_getListByCommunityAndPartAndBuildingAndUnit_",refPrefix="user_",refKey="id")
	public List<UserInfo> getListByCommunityAndPartAndBuildingAndUnit(@Param("community_id")long community_id,@Param("part")String part,@Param("building")int building,@Param("unit")int unit,@Param("room")int room,@Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="community_id",prefix="user_getCountByCommunityAndPartAndBuildingAndUnit_",refPrefix="user_",refKey="id")
	public long getCountByCommunityAndPartAndBuildingAndUnit(@Param("community_id")long community_id,@Param("part")String part,@Param("building")int building,@Param("unit")int unit,@Param("room")int room);
```

###缓存key与影响key生成策略
>对于select，proxy会生成缓存
缓存key生成策略如下：
objectcachekey = refprefix+version+args[0]+args[1]+...
对于传入参数id为10的getById会生成objectcachekey为user_v1.0_10,
如果之前已经缓存，此时通过redis key user_v1.0_10就可以拿到user这个对象
如果之前没有缓存，会在redis中set，同时把objectcachekey加入组单个查询影响范围
影响范围使用redis set实现，即objectcachekey加入set集合中，set的key生成如下：
refprefix+key+"affected_"+version+keyvalue
其他查询也一样，加入影响范围只为清空缓存
redis 操作如下：
set(user_v1.0_10,a,ttl)
sadd(user_id_afftected_v1.0_10,user_v1.0_10)，当有更新时清除该key，更新都是按照id更新

###cache组定义与删除缓存
>属于同一个组refprefix+refkey==user_id的查询有：
```java
select : getById
add : addUserInfo
update : updateById,updateScoreById
delete : deleteById
refSelects:getListByCommunityAndPartAndBuildingAndUnit,getCountByCommunityAndPartAndBuildingAndUnit,getByToken,getByMobile,getById
```
对于同属于一个组的所有update和delete，有且仅有一个和组名一样的select，即：key=refkey,prefix=refprefix，即getById
对于updateById，updateScoreById，deleteById其组为user_id，这个组对应的组查询为getById
当做这些操作时，cacheproxy会找到组的select，即getByid，同时拿到组的所有查询即 getListByCommunityAndPartAndBuildingAndUnit,getCountByCommunityAndPartAndBuildingAndUnit,getByToken,getByMobile,getById
拿到select作用是拿到老数据和更新db后的新数据，拿到相关查询是为了清除查询相关缓存
拿到老数据和新数据都是一个对象，和这个对象有关的查询缓存key都会被删除
对于关联查询getByMobile，会转换getById拿到的老数据和新数据userinfo，会从中抽取getBymobile的key值即mobile，生成影响范围key，将key和key里的set集合objectcachekey删除

###关于multiselect
```java
@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="team_getByPartnerIdAndBaokuan_",refKey="id",refPrefix="team_")
public TeamInfo getByPartnerIdAndBaokuan(@Param("partner_id")long partnerId, @Param("expire_time")int expireTime);
@RedisCache(operate=OperateType.MULTISELECT,key="partner_id",prefix="team_getByPartnerIdAndBaokuan_",refKey="id",refPrefix="team_")
public List<TeamInfo> getListByPartnerIdAndBaokuan(List<Map<String,Object>> partnerAndExpireTimes);
```
>对于上述查询，multiselect会使用prefix和key组成cache组，找到key和prefix一样的单个select，生成单个select的多个cachekey集合，先从缓存中获取，获取不到的从db获取

##多数据源支持
基于Dao层接口注解配置选择数据源，不用手动选择
* [Dao层配置Example](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/datasource/dao/StatKopInfoDao.java)
* [mybatis spring配置](https://github.com/lindzh/mybatis-spring-1.2.2/blob/master/src/test/java/org/mybatis/spring/datasource/conf/spring-mybatis.xml)
* [注解mybatis代码自动生成器](https://github.com/lindzh/mybatis-generator)

##项目使用情况
>在生产环境已经大量使用的公司
* 网易
* 快的打车
* 爱到家

##欢迎在你的项目中使用该缓存
>喜欢就给个赞，拥抱开源，贡献开源
联系方式 QQ：839861706  Email : linsony0@163.com

