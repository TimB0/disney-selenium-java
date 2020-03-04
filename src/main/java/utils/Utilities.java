package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class Utilities {

    private static WebDriver driver;
    private static String testDataFilePath = "./TestData.xlsx";

    public static String aboutDisneyUrl = "https://thewaltdisneycompany.com/";

    public static void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * 0 - First Name
     * 1 - Last Name
     * 2 - Email
     * 3 - Password
     * 4 - DOB
     *
     * @return
     * @throws IOException
     */
    public static String getLastAddedUsersData(int cellIndex) throws IOException {
        // Create Input Stream to read existing xl file
        FileInputStream myxlsx = new FileInputStream(testDataFilePath);
        //Create the workbook handle
        XSSFWorkbook testDataWkBk = new XSSFWorkbook(myxlsx);
        // Create worksheet handle
        XSSFSheet userDataSheet = testDataWkBk.getSheetAt(0);
        // Get the line number for the last row if a row wasn't supplied
        int lastRow = userDataSheet.getLastRowNum();
        // Print out the row number
        System.out.println(lastRow);

        Row row = userDataSheet.getRow(lastRow);
        return row.getCell(cellIndex).getStringCellValue();
    }

    public static String getTestDataFilePath() {
        return testDataFilePath;
    }

/*    public class ExcelFile {
        public ExcelFile(FileInputStream fileInputStream, XSSFWorkbook xssfWorkbook) throws IOException {
            // Create Input Stream to read existing xl file
            FileInputStream myxlsx = new FileInputStream(testDataFilePath);
            //Create the workbook handle
            XSSFWorkbook testDataWkBk = new XSSFWorkbook(myxlsx);
            // Create worksheet handle
            testDataWkBk.getSheetAt(0);
        }
    }

    public static ExcelFile getExcelFile() {
        return new ExcelFile()
    }*/
}
