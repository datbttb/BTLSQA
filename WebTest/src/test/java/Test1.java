import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://tiki.vn/");
    }

    @Test
    public void test() throws Exception{
        WebElement taiKhoan = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[3]"));
        Assert.assertTrue(taiKhoan.isDisplayed());
        taiKhoan.click();

        Thread.sleep(2000);
        WebElement dangNhapEmail = driver.findElement(By.xpath("//p[contains(text(),'Đăng nhập bằng email')]"));
        Assert.assertTrue(dangNhapEmail.isDisplayed());
        dangNhapEmail.click();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='acb@email.com']"));
        Assert.assertTrue(email.isDisplayed());
        email.sendKeys("nguyendinhdat23082001@gmail.com");

        WebElement matKhau = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        Assert.assertTrue(matKhau.isDisplayed());
        matKhau.sendKeys("Datbttb23082001");
        WebElement buttonDn = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        Assert.assertTrue(buttonDn.isDisplayed());
        buttonDn.click();
        Thread.sleep(20000);
        driver.navigate().to("https://tiki.vn/sales/order/history?src=header_my_account");
        Thread.sleep(2000);
        WebElement timKiem = driver.findElement(By.xpath("//input[@placeholder='Tìm đơn hàng theo Mã đơn hàng, Nhà bán hoặc Tên sản phẩm']"));
        Assert.assertTrue(timKiem.isDisplayed());
        timKiem.sendKeys("Nạp tiền điện thoại");
        WebElement btntimkiem = driver.findElement(By.xpath("//div[contains(text(),'Tìm đơn hàng')]"));
        Assert.assertTrue(btntimkiem.isDisplayed());
        btntimkiem.click();

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
