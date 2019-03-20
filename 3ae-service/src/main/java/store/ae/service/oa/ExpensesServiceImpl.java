package store.ae.service.oa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.oa.ExpensesDao;
import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;
import store.ae.vo.oa.Expenses;

/**
 * @author sidtadpole
 *
 */
@Service
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	private ExpensesDao expensesDao;
	
	@Override
	public Expenses getExpensesByIdentifier(String identifier) {

		return null;
	}

	@Override
	public Apply getApplyByIdentifier(String identifier) {
		
		Apply apply = expensesDao.queryApplyByIdentifier(identifier);
		
		return apply;
	}

	@Override
	public Verify getVerifyByIdentifier(String identifier) {
		
		Verify verify =expensesDao.queryVerifyByIdentifier(identifier);
		
		return verify;
	}

	@Override
	public Payment getPaymentByIdentifier(String identifier) {

		Payment payment = expensesDao.queryPaymentByIdentifier(identifier);
		
		return payment;
	}
	
	
	@Override
	public List<Apply> getApplyList() {
		List<Apply> list = expensesDao.queryAllExpensesApply();
		
		return list;
	}

	@Override
	public List<Verify> getVerifyList() {
		List<Verify> list = expensesDao.queryAllExpensesVerify();
		return list;
	}

	@Override
	public List<Payment> getPaymentList() {
		List<Payment> list = expensesDao.queryAllExpensesPayment();
		
		return list;
	}
	
	
}
