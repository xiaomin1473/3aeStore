package store.ae.dao.oa;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;


public interface ExpensesDao {
	
	
	/**
	 * @return
	 * 
	 * 查询所有
	 */
	List<Apply> queryAllExpensesApply();
	
	/**
	 * @return
	 * 查询所有
	 */
	List<Payment> queryAllExpensesPayment();
	
	
	/**
	 * @return
	 * 
	 * 查询
	 */
	List<Verify> queryAllExpensesVerify();
	
	
	/**
	 * @param identifier
	 * @return
	 * 
	 * 查询
	 */
	Apply queryApplyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 * 删除
	 */
	boolean delApplyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 * 查询
	 */
	Verify queryVerifyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 * 删除
	 */
	boolean delVerifyByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 * 查询
	 */
	Payment queryPaymentByIdentifier(String identifier);
	
	/**
	 * @param identifier
	 * @return
	 * 
	 * 删除
	 */
	boolean delPaymentByIdentifier(String identifier);

	
	/**
	 * @param apply
	 * @return
	 * 
	 * 插入
	 */
	int insertExpensesApply(@Param("apply") Apply apply);
	
	/**
	 * @param apply
	 * @return
	 * 
	 * 更新
	 */
	int updateExpensesApply(String identifier, @Param("apply") Apply apply);

	
	/**
	 * @param payment
	 * @return
	 * 
	 * 插入
	 */
	int insertExpensesPayment(@Param("payment") Payment payment);
	
	
	/**
	 * @param identifier
	 * @param payment
	 * @return
	 * 
	 * 更新
	 */
	int updateExpensesPayment(String identifier, @Param("payment") Payment payment);
	

	

	/**
	 * @param verify
	 * @return
	 * 
	 * 插入
	 */
	int insertExpensesVerify(@Param("verify") Verify verify);
	
	/**
	 * @param identifier
	 * @param verify
	 * @return
	 * 
	 * 更新
	 */
	int updateExpensesVerify(String identifier, @Param("verify") Verify verify);
	
}
