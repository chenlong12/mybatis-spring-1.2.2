package org.mybatis.spring.cache.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.cache.CacheVersion;
import org.mybatis.spring.cache.OperateType;
import org.mybatis.spring.cache.RedisCache;
import org.mybatis.spring.cache.pojo.OrderInfo;

import com.linda.common.mybatis.generator.annotation.Table;

/**
 * @author AutoGenerated by lindzh
 * 2015年11月19日 19:01
 */
@CacheVersion("v1.0")
@Table(name="order")
public interface OrderInfoDao {

	@RedisCache(operate=OperateType.INSERT,refKey="id",refPrefix="order_")
	public int addOrderInfo(OrderInfo obj);

	/**
	 * 同名指定ref get对象方法
	 * @param id
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="id",prefix="order_",refKey="id",refPrefix="order_")
	public OrderInfo getById(@Param("id")long id);
	
	@RedisCache(operate=OperateType.SELECT,key="id",prefix="order_getByIdAndUserId_",refKey="id",refPrefix="order_")
	public OrderInfo getByIdAndUserId(@Param("id")long id, @Param("user_id")long userId);
	
	@RedisCache(operate=OperateType.SELECT,key="id",prefix="order_getByIdNotCancel_",refKey="id",refPrefix="order_")
	public OrderInfo getByIdNotCancel(@Param("id")long id);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateById(@Param("obj")OrderInfo obj);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateByIdAndState(@Param("obj")OrderInfo obj, @Param("state") String state);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateByIdIsUnpayOrCancel(@Param("obj")OrderInfo obj);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public void updateClearIdById(@Param("id")long id, @Param("clear_id")long clear_id);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndArbitretingTimeById(@Param("id")long id, @Param("arbitrating_time")long arbitratingTime, @Param("state")String state);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateById(@Param("id")long id, @Param("state")String state);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndCancelTimeById(@Param("id")long id, @Param("cancel_time")long cancelTime, @Param("state")String state);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndDeliveringTimeById(@Param("id")long id, @Param("delivering_time")long deliveringTime, @Param("state")String state);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateDelivering2TimeById(@Param("id")long id, @Param("delivering2_time")long delivering2Time);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndDeliveredTimeById(@Param("id")long id, @Param("delivered_time")long deliveredTime, @Param("state")String state,@Param("oldStates")List<String> states);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndRefundreqTimeById(@Param("id")long id, @Param("refundreq_time")long refundreqTime, @Param("state")String state, @Param("ostate")String ostate);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateUserComplainTimeById(@Param("id")long id, @Param("user_complain_time")int userComplainTime);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndRefundingTimeAndReasonAndCouponById(@Param("id")long id, @Param("refunding_time")long refundingTime, @Param("state")String state,
			@Param("refund_reason")String refundReason, @Param("coupon")String coupon, @Param("refund_amount")double refundAmount, @Param("ostate")String ostate);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateServiceAndPrepayIdById(@Param("id")long id, @Param("service")String service, @Param("wx_prepay_id")String wxPrepayId);
	
	@RedisCache(operate=OperateType.DELETE,refKey="id",refPrefix="order_")
	public int deleteById(@Param("id")long id ,@Param("arbitrating_time") int arbitratingTime, @Param("state") String state);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndUdidNotCancel_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndUdidNotCancel(@Param("user_id")long userId, @Param("udid")String udid);
	
	@RedisCache(operate=OperateType.SELECT,key="order_md5",prefix="order_getByOrdermd5_",refKey="id",refPrefix="order_")
	public OrderInfo getByOrdermd5(@Param("order_md5")String order_md5);
	
	@RedisCache(operate=OperateType.SELECT,key="buyer_id",prefix="order_getCountByBuyerIdNotCancel_",refKey="id",refPrefix="order_")
	public long getCountByBuyerIdNotCancel(@Param("buyer_id")String buyerId);
	
	@RedisCache(operate=OperateType.SELECT,key="openid",prefix="order_getCountByOpenIdNotCancel_",refKey="id",refPrefix="order_")
	public long getCountByOpenIdNotCancel(@Param("openid")String openId);
	
	@RedisCache(operate=OperateType.SELECT,key="buyer_id",prefix="order_getByBuyerIdNotCancel_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getByBuyerIdNotCancel(@Param("buyer_id")String buyerId);
	
	@RedisCache(operate=OperateType.SELECT,key="openid",prefix="order_getByOpenIdNotCancel_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getByOpenIdNotCancel(@Param("openid")String openId);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndState_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndState(@Param("user_id")long userId, @Param("state")String state);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndPartnerIdNotCancel_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndPartnerIdNotCancel(@Param("user_id")long userId, @Param("partner_id")long partnerId);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getListByUserIdAndStateAndTohome_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByUserIdAndStateAndTohome(@Param("user_id")long user_id, @Param("state")String state, @Param("tohome")String tohome, @Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getListByUserIdAndState_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByUserIdAndState(@Param("user_id")long user_id, @Param("state")String state);
	
	@RedisCache(operate=OperateType.MULTISELECT,key="user_id",prefix="order_getListByUserIdAndState_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByUserIdAndStates(List<Map<String, Object>> params);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getListByUserId_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByUserId(@Param("user_id")long user_id,@Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserId_",refKey="id",refPrefix="order_")
	public long getCountByUserId(@Param("user_id")long user_id);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndNotUnpayOrCancel_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndNotUnpayOrCancel(@Param("user_id")long userId);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndToHomeAndStateNotFbi_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndToHomeAndStateNotFbi(@Param("user_id")long user_id, @Param("tohome")String tohome, @Param("state")String state);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getCountByUserIdAndToHomeNotFinished_",refKey="id",refPrefix="order_")
	public long getCountByUserIdAndToHomeNotFinished(@Param("user_id")long user_id, @Param("tohome")String tohome);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerIdAndCoupon_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerIdAndCoupon(@Param("partner_id")long partner_id,@Param("coupon")String coupon,@Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerIdAndCoupon_",refKey="id",refPrefix="order_")
	public long getCountByPartnerIdAndCoupon(@Param("partner_id")long partner_id,@Param("coupon")String coupon);

	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getByPartnerAndCoupon_",refKey="id",refPrefix="order_")
	public OrderInfo getByPartnerAndCoupon(@Param("partner_id")long partner_id,@Param("coupon")String coupon);
		
	@RedisCache(operate=OperateType.SELECT,key="buyer_id",prefix="order_getByBuyerIdAndCreteTimeNotCancel_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getByBuyerIdAndCreteTimeNotCancel(@Param("buyer_id")String buyerId, @Param("create_time")int createTime);
	
	@RedisCache(operate=OperateType.SELECT,key="id",prefix="order_getByIdAndExpectEndTime_",refKey="id",refPrefix="order_")
	public OrderInfo getByStateAndExpectEndTime(@Param("id")long id,@Param("state")String state,@Param("expect_end_time")int expect_end_time);

	/**
	 * 获取商户光顾数量使用，待优化
	 * @param partner_id
	 * @param state
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerAndState_",refKey="id",refPrefix="order_")
	public long getCountByPartnerAndState(@Param("partner_id")long partner_id,@Param("state")String state);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerAndState_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerAndState(@Param("partner_id")long partner_id,@Param("state")String state,@Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerAndStateAndClearId_",refKey="id",refPrefix="order_")
	public long getCountByPartnerAndStateAndClearId(@Param("partner_id")long partner_id,@Param("state")String state,@Param("clear_id")int clear_id);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerAndStateAndClearId_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerAndStateAndClearId(@Param("partner_id")long partner_id,@Param("state")String state,@Param("clear_id")int clear_id, @Param("limit")int limit,@Param("offset") int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerIdAndStates_",refKey="id",refPrefix="order_")
	public long getCountByPartnerIdAndStates(@Param("partner_id")long partner_id,@Param("states")List<String> states);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getDistinctUserCountByPartnerIdAndStates_",refKey="id",refPrefix="order_")
	public long getDistinctUserCountByPartnerIdAndStates(@Param("partner_id")long partner_id,@Param("states")List<String> states);
	
	/**
	 * 通过多个状态获取
	 * @param partnerId
	 * @param tohome
	 * @param fbi
	 * @param states
	 * @param limit
	 * @param offset
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerAndTohomeAndFbiAndStates_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerAndTohomeAndFbiAndStates(@Param("partner_id")long partnerId,@Param("tohome")String tohome,
			@Param("fbi")int fbi,@Param("states")List<String> states,@Param("orderBy") String orderBy, @Param("limit")int limit,@Param("offset") int offset);
	
	/**
	 * 商户未发货某些状态的
	 * @param partnerId
	 * @param tohome
	 * @param fbi
	 * @param states
	 * @param limit
	 * @param offset
	 * delivering2_time = 0
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getNoDeliverdListByPartnerAndTohomeAndFbiAndStates_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getNoDeliverdListByPartnerAndTohomeAndFbiAndStates(@Param("partner_id")long partnerId,@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("states")List<String> states, @Param("limit")int limit,@Param("offset") int offset);
	
	/**
	 * 商户配送的（包括用户签收和未签收的）
	 * @param partnerId
	 * @param tohome
	 * @param fbi
	 * @param states
	 * @param limit
	 * @param offset
	 * and (delivering2_time &gt; 0 or delivered_time &gt; 0)
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getDeliveredListByPartnerAndTohomeAndFbiAndStates_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getDeliveredListByPartnerAndTohomeAndFbiAndStates(@Param("partner_id")long partnerId,@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("states")List<String> states, @Param("limit")int limit,@Param("offset") int offset);
	
	public List<OrderInfo> getDeliveredListByTohomeAndFbiAndStates(@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("states")List<String> states);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getDeliveredCountByPartnerAndTohomeAndFbiAndStates_",refKey="id",refPrefix="order_")
	public long getDeliveredCountByPartnerAndTohomeAndFbiAndStates(@Param("partner_id")long partnerId,@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("states")List<String> states);
	/**
	 * 统计商家到家是否是fbi以及各个状态订单的数量
	 * @param partner_id
	 * @param tohome
	 * @param state
	 * @param fbi
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerAndTohomeAndStateAndFbi_",refKey="id",refPrefix="order_")
	public long getCountByPartnerAndTohomeAndStateAndFbi(@Param("partner_id")long partner_id,@Param("tohome")String tohome,@Param("state")String state,@Param("fbi")int fbi);

	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerAndTohomeAndStateAndFbi_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerAndTohomeAndStateAndFbi(@Param("partner_id")long partner_id,@Param("tohome")String tohome,@Param("state")String state,@Param("fbi")int fbi,@Param("limit")int limit,@Param("offset") int offset);
	
	/**
	 * 
	* @Title: getListByTime 
	* @Description: hly-2016年1月4日 下午4:36:26
	* @param @param partner_id
	* @param @param time_start
	* @param @param time_end
	* @param @return
	* @return List<OrderInfo>
	* @throws
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByTime_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByTime(@Param("partner_id")long partner_id, @Param("time_start")Integer time_start, @Param("time_end")Integer time_end);
	
	@RedisCache(operate=OperateType.SELECT,key="distribution_id",prefix="order_getListByDistributionAndExpecttimeGroupByCommunityId_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByDistributionAndExpecttimeGroupByCommunityId(@Param("distribution_id")int distribution_id,@Param("expect_time")int expect_time);
	
	@Deprecated
	@RedisCache(operate=OperateType.SELECT,key="distribution_id",prefix="order_getExpectTimeListByDistributionid_",refKey="id",refPrefix="order_")
	public List<Integer> getExpectTimeListByDistributionid(@Param("distribution_id")long distribution_id);
	
	@Deprecated
	@RedisCache(operate=OperateType.SELECT,key="distribution_id",prefix="order_getCountByDistributionidAndExpectTime_",refKey="id",refPrefix="order_")
	public long getCountByDistributionidAndExpectTime(@Param("distribution_id")long distribution_id,@Param("expect_time")int expect_time);

	@Deprecated
	@RedisCache(operate=OperateType.SELECT,key="distribution_id",prefix="order_getCommunityIdByDistributionidAndExpectTime_",refKey="id",refPrefix="order_")
	public List<Long> getCommunityIdByDistributionidAndExpectTime(@Param("distribution_id")long distribution_id,@Param("expect_time")int expect_time);
	
	@RedisCache(operate=OperateType.SELECT,key="distribution_id",prefix="order_getByDistributionIdAndExpectTimeAndStateAndCommunityId_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getByDistributionIdAndExpectTimeAndStateAndCommunityId(@Param("distribution_id")long distribution_id,@Param("expect_time")int expect_time,@Param("community_id")long community_id,@Param("state")String state);
	
	//fbi distribution 使用，不加缓存
	public List<OrderInfo> getFbiListByDistributionIdAndExpectEndTimeAndStateAndPayTime(@Param("distribution_id")long distribution_id, @Param("expect_end_time")int expect_end_time, @Param("state")String state,@Param("pay_time")long pay_time);

	@RedisCache(operate=OperateType.SELECT,key="community_id",prefix="order_getTomorrowOrder_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getTomorrowOrder(@Param("startTime")long startTime, @Param("endTime")long endTime,@Param("community_id")long community_id);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getSumIncomeByPartnerId_",refKey="id",refPrefix="order_")
	public double getSumIncomeByPartnerId(@Param("partner_id")long partner_id, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);

	@RedisCache(operate=OperateType.SELECT,key="groupbuy_id",prefix="order_getIdByGroupBuyIdAndUserId_",refKey="id",refPrefix="order_")
	public OrderInfo getByGroupBuyIdAndUserId(@Param("groupbuy_id")long groupbuy_id, @Param("user_id")long user_id);

	public List<OrderInfo> getOrderToCancel(@Param("create_time")long create_time);
	
	/**
	 * 
	* @Title: getListByPartnerIdAndPayTime FBI状态为PAY的订单
	* @Description: hly-2016年2月18日 下午4:57:55
	* @param @param partner_id
	* @param @param startTime
	* @param @param endTime
	* @param @return
	* @return List<OrderInfo>
	* @throws
	 */
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getListByPartnerIdAndPayTime_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByPartnerIdAndPayTime(@Param("partner_id")long partner_id, @Param("begin_time") Integer beginTime, @Param("end_time") Integer endTime);
	
	@RedisCache(operate=OperateType.SELECT,key="state",prefix="order_getListByCreateTimeAndState_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByCreateTimeAndState(@Param("create_time")int create_time,@Param("state")String state); 
	
	/**
	 * 通过支付时间获取不同状态的订单
	 * @param tohome
	 * @param fbi
	 * @param state
	 * @param pay_starttime
	 * @param pay_endtime
	 * @return
	 */
	@RedisCache(operate=OperateType.SELECT,key="state",prefix="order_getListByTohomeAndFbiAndStateAndPaytime_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByTohomeAndFbiAndStateAndPaytime(@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("state")String state,@Param("pay_starttime")int pay_starttime,@Param("pay_endtime")int pay_endtime);

	@RedisCache(operate=OperateType.SELECT,key="state",prefix="order_getListByTohomeAndFbiAndStateAndExpecttime_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByTohomeAndFbiAndStateAndExpecttime(@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("state")String state,@Param("expect_starttime")int expect_starttime,@Param("expect_endtime")int expect_endtime);

	@RedisCache(operate=OperateType.SELECT,key="state",prefix="order_getListByStateAndFbiAndDelivering2time_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByStateAndFbiAndDelivering2time(@Param("state")String state,@Param("fbi")int fbi,@Param("delivering2_starttime")int delivering2_starttime,@Param("delivering2_endtime")int delivering2_endtime,@Param("limit")int limit,@Param("offset")int offset);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerAndFbi_",refKey="id",refPrefix="order_")
	public long getCountByPartnerAndFbi(@Param("partner_id")long partner_id,@Param("fbi")int fbi);

	@RedisCache(operate=OperateType.SELECT,key="fbi",prefix="order_getDeliveredListByTohomeAndFbiAndStatesAndTime_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getDeliveredListByTohomeAndFbiAndStatesAndTime(@Param("tohome")String tohome,@Param("fbi")int fbi,@Param("states")List<String> states,@Param("time")long time);
	
	@RedisCache(operate=OperateType.UPDATE,refKey="id",refPrefix="order_")
	public int updateStateAndDistributeIdAndDeliveringByIdAndState(@Param("id")long id,@Param("oldState")String oldState,@Param("newState")String newState,@Param("delivering_time")int delivering_time,@Param("distribution_id")long distribution_id);
	
	@RedisCache(operate=OperateType.SELECT,key="user_id",prefix="order_getListByUserAndStateIsFbi_",refKey="id",refPrefix="order_")
	public List<OrderInfo> getListByUserAndStateIsFbi(@Param("user_id")long userId,@Param("state")String state);

	/**
	 *select * from dc.order
		where id &gt; #{id} and state = #{state} and fbi=1 and expect_time &gt; #{expect_time} and expect_end_time &lt; #{expect_end_time} and partner_id = 542
	 **/
	public List<OrderInfo> getListByOrderIdAndState(@Param("id")long id,@Param("state")String state,@Param("expect_time")int expect_time,@Param("expect_end_time")int expect_end_time,@Param("partner_id")long partnerId);

//	select * from dc.order where 
//	expect_end_time &gt;= #{expect_end_time} 
//	and expect_end_time &lt; #{expect_end_time} 
//	and fbi = 1 
//	and state = 'pay' 
//	and partner_id = #{partner_id} 
//	and id not in ( 
//		select distinct order_id from dc.split_order 
//			where expect_end_time &gt; #{expect_end_time}
//			and expect_end_time &lt; #{expect_end_time}
//			and partner_id = #{partner_id} )
	public List<OrderInfo> getSplitOrderId(@Param("start")int start, @Param("end")int end, @Param("partner_id")long partnerId);
	
	@RedisCache(operate=OperateType.SELECT,key="partner_id",prefix="order_getCountByPartnerIdAndCreateTimeHasPay_",refKey="id",refPrefix="order_")
	public long getCountByPartnerIdAndCreateTimeHasPay(@Param("partner_id")long partnerId, @Param("create_time")int createTime);

}