package store.ae.service.oa;

import java.io.IOException;
import java.util.List;

import store.ae.pojo.oa.Apply;

/**
 * 	数据备份
 * @author sidtadpole
 *
 */
public interface DatabaseService {
	
	/**
	 * @param is
	 * @param excelFileName
	 * @return
	 * @throws IOException
	 */
	public void createOutWorkbook(String fileName) throws IOException;
	
	public List<Apply> loadApplyInfo(String xlsPath) throws IOException;
	
}
