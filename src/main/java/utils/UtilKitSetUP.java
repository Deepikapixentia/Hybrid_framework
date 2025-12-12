package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class UtilKitSetUP extends BaseTest {

	public static List<HashMap<String, String>> getTestDataFromExcel(String sheetname) {

		List<HashMap<String, String>> alltestdata = new ArrayList<>();
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "\\src\\test\\resources\\Excels\\NOVO_testcases_masterexcel.xlsx";

		try (FileInputStream fis1 = new FileInputStream(excelPath); 
				XSSFWorkbook wb = new XSSFWorkbook(fis1)) {

			XSSFSheet ws = wb.getSheet(sheetname);

			Row headerrow = null;
			headerrow = ws.getRow(0);

			for (int i = 1; i <= ws.getLastRowNum(); i++) {
				Row currentrow = ws.getRow(i);
				if (currentrow == null) {
					continue;
				}
				DataFormatter format = new DataFormatter();
				HashMap<String, String> data = new HashMap<String, String>();

				for (int j = 0; j <= headerrow.getLastCellNum(); j++) {
					// Add null check for cells to avoid NullPointerException
					if (headerrow.getCell(j) != null && currentrow.getCell(j) != null) {
						String key = format.formatCellValue(headerrow.getCell(j));
						String value = format.formatCellValue(currentrow.getCell(j));

						if (key != null && !key.isEmpty()) {
							data.put(key, value);
						}
					}
				}
				alltestdata.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return alltestdata;
				
	}
	
	public static String getScreenShot() {
		
		
		String pattern="yyyy-MM-dd HH-mm-ss"; // Changed colon : to hyphen - for better Windows compatibility
		SimpleDateFormat sfd=new SimpleDateFormat(pattern);
		String date=sfd.format(new Date());
		
		String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshots\\"+date+".png";
		
		File screenshitfile=new File(screenshotfilepath);
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, screenshitfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotfilepath;
		
	}
}