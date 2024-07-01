package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        String url = driver.getCurrentUrl();
        if (url.contains("makemytrip")) {
            System.out.println("URL CONTAINS makemytrip ");
        } else {
            System.out.println("URL doesnot contain makemytrip");
        }
        System.out.println("End Test case: testCase01");

    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(3000);
        WebElement fromtab = driver.findElement(By.xpath("//span[text()='From']"));
        fromtab.click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.click();
        from.sendKeys("blr");
        WebElement select1 = driver
                .findElement(By.xpath("//div[contains(@class,'makeFlex appendTop12  forHideundefined')]"));
        select1.click();
        Thread.sleep(2000);
        WebElement Totab = driver.findElement(By.xpath("//span[text()='To']"));
        Totab.click();
        WebElement To = driver.findElement(By.xpath("//input[@placeholder='To']"));
        To.click();
        To.sendKeys("del");
        WebElement select2 = driver
                .findElement(By.xpath("//div[contains(@class,'makeFlex appendTop12  forHideundefined')]"));
        select2.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//div[@aria-label='Mon Jul 29 2024']"));
        date.click();
        WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
        search.click();
        Thread.sleep(5000);
        WebElement pricexml=driver.findElement(By.xpath("//p[text()='per adult']//parent::div"));
        String price1= pricexml.getText();
        System.out.println(price1);
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class=' fontSize18 blackFont']"));
        List<String> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            // //priceText = priceText.replaceAll("[^0-9,]", "");
            prices.add(priceElement.getText());
        }
        System.out.println("Flight Price:" + prices);
        System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(3000);
        WebElement trainIcon = driver
                .findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chTrains']"));
        trainIcon.click();
        Thread.sleep(3000);
        WebElement fromtab = driver.findElement(By.xpath("//span[text()='From']"));
        fromtab.click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.click();
        from.sendKeys("ypr");
        WebElement select1 = driver
                .findElement(By.xpath("//span[text()='Bangalore']"));
        select1.click();
        Thread.sleep(2000);
        WebElement Totab = driver.findElement(By.xpath("//span[text()='To']"));
        Totab.click();
        WebElement To = driver.findElement(By.xpath("//input[@placeholder='To']"));
        To.click();
        To.sendKeys("ndls");
        WebElement select2 = driver
                .findElement(By.xpath("//span[text()='Delhi']"));
        select2.click();
        WebElement datecal = driver
                .findElement(By.xpath("//input[@id='travelDate']"));
        datecal.click();
        WebElement date = driver.findElement(By.xpath("//div[@aria-label='Mon Jul 29 2024']"));
        date.click();
        WebElement classOption = driver.findElement(By.xpath("//span[@class='appendBottom5 downArrow']"));
        classOption.click();
        WebElement classele = driver.findElement(By.xpath("//li[text()='Third AC']"));
        classele.click();
        WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
        search.click();
        Thread.sleep(5000);
        List<WebElement> priceElements = driver.findElements(
                By.xpath("//div[@id='train_options_29-07-2024_0']//div[@class='ticket-price justify-flex-end']"));
        List<String> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            // //priceText = priceText.replaceAll("[^0-9,]", "");
            prices.add(priceElement.getText());
        }
        System.out.println("Train Price:" + prices);
        System.out.println("End Test case: testCase03");
    }
    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(3000);
        WebElement busIcon = driver
                .findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chBuses']"));
        busIcon.click();
        Thread.sleep(3000);
        WebElement fromtab = driver.findElement(By.xpath("//span[text()='From']"));
        fromtab.click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.click();
        from.sendKeys("bangl");
        WebElement select1 = driver
                .findElement(By.xpath("//span[text()='Bangalore, Karnataka']"));
        select1.click();
        // Thread.sleep(5000);
        // WebElement Totab = driver.findElement(By.xpath("//span[text()='To']"));
        // Totab.click();
        WebElement To = driver.findElement(By.xpath("//input[@placeholder='To']"));
        To.click();
        To.sendKeys("kathma");
        WebElement select2 = driver
                .findElement(By.xpath("//span[text()='Kathmandu, Nepal']"));
        select2.click();
        // WebElement datecal = driver
        //         .findElement(By.xpath("//input[@id='travelDate']"));
        // datecal.click();
        WebElement date = driver.findElement(By.xpath("//div[@aria-label='Mon Jul 29 2024']"));
        date.click();
        WebElement search = driver.findElement(By.xpath("//button[@id='search_button']"));
        search.click();
        Thread.sleep(5000);
        WebElement errorMessage = driver.findElement(
                By.xpath("//span[@class='error-title']"));
        String error=errorMessage.getText();
        String message="No buses found for 29";
        if(error.contains(message)){
            System.out.println("Test Case Pass");
        }else{
            System.out.println("Failed Test Case"+error);
        }
        System.out.println("End Test case: testCase03");
    }


}
