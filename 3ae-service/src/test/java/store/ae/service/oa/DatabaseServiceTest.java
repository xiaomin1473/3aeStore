package store.ae.service.oa;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/oa/config/oa-dao.xml",
	"classpath:store/ae/service/oa/config/oa-service.xml"})
public class DatabaseServiceTest {
	
	@Autowired
	private DatabaseService databaseService;

	@Test
	public void testCreateOutWorkbook() throws IOException {
		
		
		databaseService.createOutWorkbook("D://log.xls");
	}

	@Test
	public void testLoadApplyInfo() throws IOException {
		
		//databaseService.loadxlsToDatabase("D://123.xls");
			
	}

}
