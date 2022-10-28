package Com;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;

public class Content {
    public Content() {
    };


    public List<String> readFile() {
        List<String> emailList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src//sheet.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.rowIterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    emailList.add(cellIterator.next().getStringCellValue());
                }
            }
        } catch (Exception e) {
            e.exception();
        }
        return emailList;
    }
}
