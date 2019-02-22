package store.ae.service.oa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.oa.ExpensesDao;
import store.ae.pojo.oa.Apply;
import store.ae.vo.oa.Expenses;


@Service
public class DatabaseServiceImpl implements DatabaseService {
	
	@Autowired
	private ExpensesDao expensesDao;
	
	
	/**	时间序列化
	 * @param l
	 * @return
	 */
	public static String stampToDate(long l){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(l);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

	@Override
	public void createOutWorkbook(String fileName) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建HSSFSheet对象
		HSSFSheet sheet = wb.createSheet("费用申报记录");
		//创建HSSFRow对象
		// HSSFRow row = sheet.createRow(i);
		//创建HSSFCell对象
		// HSSFCell cell = row.createCell(0);
		
		List<Apply> lists = expensesDao.queryAllExpensesApply();
		int i = 1;
		
		HSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("序号ID");
		row0.createCell(1).setCellValue("费用申请编号");
		row0.createCell(2).setCellValue("费用申请时间");
		row0.createCell(3).setCellValue("报支事项");
		row0.createCell(4).setCellValue("金额");
		row0.createCell(5).setCellValue("经办人");
		row0.createCell(6).setCellValue("归属人");
		row0.createCell(7).setCellValue("费用分类");
		row0.createCell(8).setCellValue("部门类别");
		row0.createCell(9).setCellValue("收款单位");
		row0.createCell(10).setCellValue("归属类别");
		row0.createCell(11).setCellValue("项目编号");
		row0.createCell(12).setCellValue("项目名称");
		row0.createCell(13).setCellValue("分类标识");
		row0.createCell(14).setCellValue("申请状态");
		row0.createCell(15).setCellValue("备注");
		row0.createCell(16).setCellValue("创建日期");
		row0.createCell(17).setCellValue("修改日期");
		
		for(Apply apply : lists) {
			HSSFRow row = sheet.createRow(i);
			
			row.createCell(0).setCellValue(apply.getExpensesId());
			row.createCell(1).setCellValue(apply.getIdentifier());
			row.createCell(2).setCellValue(stampToDate(apply.getExpensesGmt().getTime()));
			row.createCell(3).setCellValue(apply.getMatter());
			row.createCell(4).setCellValue(apply.getAmount().toString());
			row.createCell(5).setCellValue(apply.getHandler());
			row.createCell(6).setCellValue(apply.getAscriptor());
			row.createCell(7).setCellValue(apply.getExpensesType());
			row.createCell(8).setCellValue(apply.getDepartmentType());
			row.createCell(9).setCellValue(apply.getReceiveCompany());
			row.createCell(10).setCellValue(apply.getAscription());
			row.createCell(11).setCellValue(apply.getProjectNum());
			row.createCell(12).setCellValue(apply.getProjectName());
			row.createCell(13).setCellValue(apply.getClassType());
			row.createCell(14).setCellValue(apply.getApplyStatus());
			row.createCell(15).setCellValue(apply.getRemark());
			row.createCell(16).setCellValue(stampToDate(apply.getGmtCreate().getTime()));
			row.createCell(17).setCellValue(stampToDate(apply.getGmtModified().getTime()));
			
			i++;
		}
		
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		// sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		
		//输出Excel文件
		FileOutputStream output=new FileOutputStream(fileName);
		wb.write(output);
		output.flush();
		output.close();
		wb.close();
	}

	@SuppressWarnings("unused")
	@Override
	public List<Expenses> loadxlsToDatabase(String xlsPath) throws IOException {
		
		
		List<Expenses> expensesList = null;

		
		FileInputStream fileIn = new FileInputStream(xlsPath);
			
		Workbook wb0 = new HSSFWorkbook(fileIn);
		
		// 第一个表格
		Sheet sht0 = wb0.getSheetAt(0);
		
		for (Row r : sht0) {
	        //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
			if(r.getRowNum()<1){
				continue;
			}
			//创建实体类
			
			Expenses expenses = new Expenses();
			
			//取出当前行第1个单元格数据，并封装在info实体stuName属性上
			expenses.setIdentifier(r.getCell(1).getStringCellValue());
			expenses.setExpensesGmt(r.getCell(2).getDateCellValue());
			expenses.setMatter(r.getCell(3).getStringCellValue());
			
			BigDecimal price = new BigDecimal(r.getCell(4).getNumericCellValue());
			
			expenses.setAmount(price);
			expenses.setHandler(r.getCell(5).getStringCellValue());
			expenses.setAscriptor(r.getCell(6).getStringCellValue());
			expenses.setDepartmentType(r.getCell(9).getStringCellValue());
			expenses.setReceiveCompany(r.getCell(10).getStringCellValue());
			expenses.setAscription(r.getCell(11).getStringCellValue());
			expenses.setExpensesType(r.getCell(12).getStringCellValue());
			expenses.setProjectNum(r.getCell(13).getStringCellValue());
			expenses.setProjectName(r.getCell(14).getStringCellValue());
			expenses.setClassType(r.getCell(15).getStringCellValue());
			
			
			expensesList.add(expenses);
        }
		
	        fileIn.close();
		return expensesList;
	}

}
