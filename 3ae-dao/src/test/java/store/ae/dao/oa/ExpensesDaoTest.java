package store.ae.dao.oa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;




@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/oa/config/oa-dao.xml"})
public class ExpensesDaoTest {
	
	@Autowired
	private ExpensesDao expensesDao;

	@Test
	public void testQueryAllExpensesApply() {
		List<Apply> lists = expensesDao.queryAllExpensesApply();
		System.out.println(lists);
	}
	
	@Test
	public void testInsertExpensesApply() {
		int num = 0;
		List<Apply> list = expensesDao.queryAllExpensesApply();
		Apply apply = list.get(0);
		System.out.println(apply);
		
		num = expensesDao.insertExpensesApply(apply);
		
		System.out.println(num);
	}

	@Test
	public void testQueryAllExpensesPayment() {
		List<Payment> list = expensesDao.queryAllExpensesPayment();
		
		System.out.println(list);
	}
	
	@Test
	public void testInsertExpensesPayment() {
		int num = 0;
		List<Payment> list = expensesDao.queryAllExpensesPayment();
		Payment Payment = list.get(0);
		System.out.println(Payment);
		
		num = expensesDao.insertExpensesPayment(Payment);
		
		System.out.println(num);
	}

	@Test
	public void testQueryAllExpensesVerify() {
		List<Verify> list = expensesDao.queryAllExpensesVerify();
		
		System.out.println(list);
	}
	
	@Test
	public void testInsertExpensesVerify() {
		int num = 0;
		List<Verify> list = expensesDao.queryAllExpensesVerify();
		Verify Verify = list.get(0);
		System.out.println(Verify);
		
		num = expensesDao.insertExpensesVerify(Verify);
		
		System.out.println(num);
	}

}
