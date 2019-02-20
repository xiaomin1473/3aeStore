package store.ae.dao.oa;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.oa.Apply;




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
	public void testQueryAllExpensesPayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAllExpensesVerify() {
		fail("Not yet implemented");
	}

}
