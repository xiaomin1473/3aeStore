package store.ae.service.oa;

import java.io.IOException;
import java.util.List;

import store.ae.vo.oa.Expenses;

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

	/**
	 * @param xlsPath
	 * @return
	 * @throws IOException
	 */
	List<Expenses> loadxlsToDatabase(String xlsPath) throws IOException;
	
}
