package store.ae.dao.oa;

import java.util.List;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;


public interface ExpensesDao {
	/**
	 * @return
	 */
	List<Apply> queryAllExpensesApply();
	
	/**
	 * @return
	 */
	List<Payment> queryAllExpensesPayment();
	
	/**
	 * @return
	 */
	List<Verify> queryAllExpensesVerify();
}
