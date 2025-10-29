package APR_21;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Launch {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", 
            "D:\\Users\\Simran\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        driver.findElement(By.id("firstName")).sendKeys("simran");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("singh");
        driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("simran@gmail.com");

        WebElement genderMale = driver.findElement(By.xpath("//label[text()='Male']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderMale);

        driver.findElement(By.cssSelector("input[placeholder='Mobile Number']")).sendKeys("9999999999");

        // ✅ Date of Birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();

        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        new Select(monthDropdown).selectByVisibleText("December");

        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        new Select(yearDropdown).selectByVisibleText("1998");

        WebElement day = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--028') and not(contains(@class,'outside-month'))]"));
        day.click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("Science");
        subjects.sendKeys(Keys.ENTER);

        WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
        WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sports);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", music);

        // ✅ Optional upload (skipped if flag = true)
        boolean skipUpload = true; 
        if (!skipUpload) {
            WebElement upload = driver.findElement(By.id("uploadPicture"));
            upload.sendKeys("E:\\Projects\\Pictures\\Screenshots\\photo.png");
        }

        // ✅ Address
        driver.findElement(By.id("currentAddress")).sendKeys("123 Model Town, Ludhiana");

        // ✅ State & City
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        // ✅ Submit form
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        Thread.sleep(3000);
        driver.quit();
    }
}
