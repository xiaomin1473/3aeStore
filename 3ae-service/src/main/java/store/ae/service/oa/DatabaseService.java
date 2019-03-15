package store.ae.service.oa;

import java.io.IOException;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import store.ae.common.exception.SystemException;

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
	public void createOutWorkbook(String fileName) throws SystemException;

	/**
	 * @param xlsPath
	 * @return
	 * @throws IOException
	 */
	void loadxlsToDatabase(POIFSFileSystem fileIn) throws SystemException;
	
}
