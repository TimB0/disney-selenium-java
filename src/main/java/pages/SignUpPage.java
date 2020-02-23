package pages;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SignUpPage {

    private WebDriver driver;
    private Faker faker = new Faker();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dobString;
    private String testDataFilePath = "./TestData.xlsx";


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccountBtn() {
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public String generateFirstName() {
        this.firstName = faker.name().firstName();
        return firstName;
    }

    public String generateLastName() {
        this.lastName = faker.name().lastName();
        return lastName;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.name("lastName")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public String generateEmail() {
        this.email = faker.internet().safeEmailAddress();
        return email;
    }

    public String generatePassword() {
        this.password = faker.internet().password(6,7,true, true, true);
        return password;
    }

    public String generateDOB() {
        Date dob = faker.date().birthday();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        this.dobString = df.format(dob);
        return dobString;
    }

    public void enterNewPassword(String password) {
        driver.findElement(By.name("newPassword")).sendKeys(password);
    }

    public void enterVerifyPassword(String password) {
        driver.findElement(By.name("verifyPassword")).sendKeys(password);
    }

    // mm/dd/yyyy
    public void enterDOB(String dob) {
        driver.findElement(By.name("dateOfBirth")).sendKeys(dob);
    }

    public String waitForAccountSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[text() = 'Account Created!']")))).getText();
    }

    public void dataSaver() throws FileNotFoundException {

        createTestDataFile(testDataFilePath);
        try {


            // Create Input Stream to read existing xl file
            FileInputStream myxlsx = new FileInputStream(testDataFilePath);
            //Create the workbook handle
            XSSFWorkbook testDataWkBk = new XSSFWorkbook(myxlsx);
            // Create worksheet handle
            XSSFSheet userDataSheet = testDataWkBk.getSheetAt(0);
            // Get the line number for the last row
            int lastRow = userDataSheet.getLastRowNum();
            // Print out the row number
            System.out.println(lastRow);
            // Create a new row in worksheet added after the last row
            Row row = userDataSheet.createRow(++lastRow);
            // Write to the first cell in that row
            row.createCell(0).setCellValue(firstName);
            row.createCell(1).setCellValue(lastName);
            row.createCell(2).setCellValue(email);
            row.createCell(3).setCellValue(password);
            row.createCell(4).setCellValue(dobString);
            // CLose the Input Stream
            myxlsx.close();

            // Start an Output Stream to write the changes
            FileOutputStream outputFile = new FileOutputStream(new File(testDataFilePath));

            // write the changes
            testDataWkBk.write(outputFile);
            outputFile.close();
            System.out.println(" is successfully written");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createTestDataFile(String testDataFilePath) throws FileNotFoundException {
        File testDataFile = new File(testDataFilePath);
        if (testDataFile.exists()) {
            return;
        }

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("userData");
        try (OutputStream fileOut = new FileOutputStream(testDataFilePath)) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
