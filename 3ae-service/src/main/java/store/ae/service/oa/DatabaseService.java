package store.ae.service.oa;

import java.io.IOException;

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
	void loadxlsToDatabase(String xlsPath) throws IOException;
	
}
