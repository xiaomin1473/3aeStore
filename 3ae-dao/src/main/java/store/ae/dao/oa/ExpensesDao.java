package store.ae.dao.oa;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;


public interface ExpensesDao {
	
	/**
	 * @param identifier
	 * @return
	 */
	Apply queryApplyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 */
	Verify queryVerifyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 */
	Payment queryPaymentByIdentifier(String identifier);
	
	/**
	 * @return
	 */
	List<Apply> queryAllExpensesApply();
	
	/**
	 * @param apply
	 * @return
	 */
	int insertExpensesApply(@Param("apply") Apply apply);
	
	/**
	 * @return
	 */
	List<Payment> queryAllExpensesPayment();
	
	/**
	 * @param payment
	 * @return
	 */
	int insertExpensesPayment(@Param("payment") Payment payment);
	
	/**
	 * @return
	 */
	List<Verify> queryAllExpensesVerify();
	

	/**
	 * @param verify
	 * @return
	 */
	int insertExpensesVerify(@Param("verify") Verify verify);
	
}
