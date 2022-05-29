package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Baseclass {
public	static WebDriver driver;

	public static  WebDriver getDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().browserVersion("101").setup();
			driver = new ChromeDriver();
		}
		return driver;		
		
	}
	public String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SystemProperty\\config.properties");
		properties.load(stream);
		Object object = properties.get(key);
		String value =(String)object;
		return value;
	}
	public static void enterUrl(String url) {
		driver.get(url);
	}

	public static void type(WebElement element, String data) {
		clear(element);
		element.sendKeys(data);
	}
	public static void clear(WebElement element) {
		element.clear();
		

	}
	
	

	public static void click(WebElement element) {
		element.click();
	}

	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;

	}

	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getTitle(WebElement element) {
		String title = element.getText();
		return title;
	}

	public String getUrl(WebElement element) {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	public static void  selectOptionText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		;
	}

	public void deSelectOptionText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void deSelectOptionValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByVisibleText(value);
	}

	public void deSelectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void deSelectAll(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void clickJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

	}

	public void typeJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute ('value','" + text + "')", element);

	}

	public String getJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].getAttribute ('value')", element);
		String s = (String) executeScript;
		return s;
	}

	public void jsScrollup() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)");
	}

	public void jsScrollDown() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)");
	}

	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertDissmiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void btnPrompt(WebElement element, String button) {
		Alert alert = driver.switchTo().alert();
		WebElement btn = driver.findElement(By.id(button));
		alert.accept();
	}

	public void closeAll() {
		driver.close();
	}

	public void closeCurrent() {
		driver.quit();
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public void switchFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameName(String name) {
		driver.switchTo().frame(name);
	}

	public void mouseOverClick(String attributevalue, String btnvalue) {
		Actions actions = new Actions(driver);
		WebElement mouseover = driver.findElement(By.id(attributevalue));
		actions.moveToElement(mouseover).perform();
		WebElement btn = driver.findElement(By.id(btnvalue));
		btn.click();

	}

	public void rightClick(String attributevalue, String btnvalue) {
		Actions actions = new Actions(driver);
		WebElement rClick = driver.findElement(By.id(attributevalue));
		WebElement btn = driver.findElement(By.id(btnvalue));
		actions.moveToElement(rClick).contextClick(btn);
	}

	public void pressTab(String attributevalue) {
		Actions actions = new Actions(driver);
		WebElement webElement = driver.findElement(By.id(attributevalue));
		webElement.sendKeys(Keys.TAB);
	}

	public void doubleClick(String attributevalue) {
		Actions actions = new Actions(driver);
		WebElement textBox = driver.findElement(By.id(attributevalue));
		actions.doubleClick(textBox).perform();
	}

	public void robot() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

	}

	public void robotUp() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	public void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getScreenshot(String s) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		System.out.println(source);
		s = "D:\\Chrome downloads\\screenshot6814747403650910544.png";
		File file = new File(s);
		FileUtils.copyFile(source, file);
	}

	public void switchWindowUrl(String url) {
		driver.switchTo().window(url);
	}

	public void switchWindowTitle(String title) {
		driver.switchTo().window(title);
	}

	public void switchWindowId(String id) {
		driver.switchTo().window(id);
	}

	public String getWindowHandle() {
		String winId = driver.getWindowHandle();
		return winId;
	}

	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void switchWndowTitle(String title) {
		driver.switchTo().window(title);
	}

	public void switchWndowId(String id) {
		driver.switchTo().window(id);
	}

	public String getWinowHandle() {
		String winId = driver.getWindowHandle();
		return winId;
	}

	public Set<String> getWinowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	public  String getData(String sheetName, int rowNo, int cellNo, String path) throws IOException {

		String data = null;
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(rowNo);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(cellNo);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					data = cell.getStringCellValue();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						data = dateFormat.format(dateCellValue);
						
					}

					else {
						double d = cell.getNumericCellValue();
						BigDecimal b = BigDecimal.valueOf(d);
						data = b.toString();
					}
					break;
				default:
					break;

				}
			}
		}
		return data;
	}

	public void writeData(String sheetName, int rowNo, int cellNo, String path, String data)
			throws IOException {
		
		
		
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);

	}

	public String upDateData(String sheetName, int rowNo, int cellNo, String newdata, String olddata, String data, String path)
			throws IOException {
		
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		newdata = cell.getStringCellValue();
		if (newdata.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		return newdata;
	}

}







