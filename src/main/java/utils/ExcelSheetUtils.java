package utils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelSheetUtils {



    public Map<String, String> getRowData(String filePath, String sheetName, String testCaseId) throws Exception {
        Map<String, String> dataMap = new HashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0); // The "Keys"
        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            Row currentRow = sheet.getRow(i);
            // Check if the first column (TestID) matches your requirement
            if (currentRow.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseId)) {
                for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = currentRow.getCell(j).toString(); // Converts all types to String
                    dataMap.put(key, value);
                }
                break;
            }
        }
        workbook.close();
        return dataMap;
    }
}
