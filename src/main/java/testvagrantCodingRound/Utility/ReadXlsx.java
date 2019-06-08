package testvagrantCodingRound.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;



public class ReadXlsx {

	 Workbook workbook;
	 Sheet sheet;
	//Reads Excel file, and return a list of maps, maps are generated for each row
	//Test case is provided as input
	public List<Map<String, String>> getData(String TestCase)
	{
		List<Map<String, String>> data=new ArrayList<>();
		
		File file=new File(ReadPropertyFile.get("TestDataExcel"));
		try {
			FileInputStream fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(TestCase.toUpperCase());
			int rows=sheet.getLastRowNum();
			for(int i=1;i<=rows;i++)
			{
				Row row=sheet.getRow(i);
				int columns=row.getLastCellNum();
				Map<String, String> temp=new HashMap<String,String>();
				for(int j=0;j<columns;j++)
				{
					
					DataFormatter formatter = new DataFormatter();
					String val = formatter.formatCellValue(row.getCell(j));
					temp.put(formatter.formatCellValue(sheet.getRow(0).getCell(j)).toUpperCase(), val);
					
				}
				data.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}
	

}
