package store.ae.web.oa;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import store.ae.service.oa.DatabaseService;

@Controller
@RequestMapping("/database")
public class DatabaseController extends BaseController {
	
	@SuppressWarnings("unused")
	@Autowired
	private DatabaseService databasesService;
	
	
	@RequestMapping(value = "/upload/filexls",
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String categorieList(MultipartFile file, String name) throws IOException{
		
		if(file.isEmpty()) {
			return "文件不能为空！";
		}
		else {
			
			InputStream inputStream = file.getInputStream();
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			// 2.读取页脚sheet
			@SuppressWarnings("unused")
			HSSFSheet sheetAt = wb.getSheetAt(0);
			
			
			
			
			return "导入成功！";
		}
		
		
		
		
		
		

	}
}
