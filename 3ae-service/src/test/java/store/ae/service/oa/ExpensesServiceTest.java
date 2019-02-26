package store.ae.service.oa;

import static org.junit.Assert.fail;

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
@ContextConfiguration({
	"classpath:store/ae/dao/oa/config/oa-dao.xml",
	"classpath:store/ae/service/oa/config/oa-service.xml"})
public class ExpensesServiceTest {
	
	@Autowired
	private ExpensesService expensesService;
	
	@Test
	public void testGetExpensesByIdentifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetApplyByIdentifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVerifyByIdentifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaymentByIdentifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetApplyList() {
		List<Apply> list = expensesService.getApplyList();
	}

	@Test
	public void testGetVerifyList() {
		List<Verify> list = expensesService.getVerifyList();
	}

	@Test
	public void testGetPaymentList() {
		List<Payment> list = expensesService.getPaymentList();
	}

}
