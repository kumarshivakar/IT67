package in.nims.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	public String getPropertyData(String key) throws IOException{
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		
		return p.getProperty(key);
	}
	public String getExcelData(String sheetname,int row,int cell)throws IOException,EncryptedDocumentException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		String data=w.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
		return data;	
	}

	public void setExcelData(String sheetname,int row,int cell,String data)throws IOException,EncryptedDocumentException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		w.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
		w.write(fos);
		w.close();
	}
}
