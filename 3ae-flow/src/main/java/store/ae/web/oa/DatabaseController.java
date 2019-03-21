package store.ae.web.oa;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

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
	
	@Autowired
	private DatabaseService databaseService;
	
	
	@RequestMapping(value = "/upload/filexls",
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String loadxls(MultipartFile file, String name) throws IOException{
		
		if(file.isEmpty()) {
			return "文件不能为空！";
		}
		else {
			
			InputStream inputStream = file.getInputStream();
			POIFSFileSystem fileIn = new POIFSFileSystem(inputStream);
			
			databaseService.loadxlsToDatabase(fileIn);
			
			return "导入成功！";
		}

	}
	
	@RequestMapping(value = "/create/filexls",
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String createxls() throws IOException{
		
		Date date = new Date();
	
		databaseService.createOutWorkbook("D://" + DateFormat.getDateInstance().format(date) + ".xls");
		
		return "导出成功！";
	}
}
