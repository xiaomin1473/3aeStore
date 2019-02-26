package store.ae.service.oa;

import java.util.List;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;
import store.ae.vo.oa.Expenses;

public interface ExpensesService {

	/**	
	 * 财务中心，支付状态信息，整条申报流程信息
	 * @param Identifier
	 * @return
	 */
	Expenses getExpensesByIdentifier(String identifier);

	/** 四大中心，文员根据identifirer查询申报信息
	 * @param identifier
	 * @return
	 */
	Apply getApplyByIdentifier(String identifier);

	/** 四大中心，审核根据identifirer查询审核信息
	 * @param identifier
	 * @return
	 */
	Verify getVerifyByIdentifier(String identifier);

	/** 财务，财务根据identifirer查询支付信息
	 * @param identifier
	 * @return
	 */
	Payment getPaymentByIdentifier(String identifier);

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Apply> getApplyList();

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Verify> getVerifyList();

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Payment> getPaymentList();

}