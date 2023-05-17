import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestChatBot {
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

        WebElement thanhTk = driver.findElement(By.xpath("//input[@placeholder='Rẻ mỗi ngày, không chỉ một ngày']"));
        Assert.assertTrue(thanhTk.isDisplayed());
        thanhTk.sendKeys("thẻ cào viettel");

        WebElement btnTimKiem = driver.findElement(By.xpath("//button[contains(text(),'Tìm kiếm')]"));
        Assert.assertTrue(btnTimKiem.isDisplayed());
        btnTimKiem.click();
        Thread.sleep(2000);

        WebElement chonThe = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]"));
        Assert.assertTrue(chonThe.isDisplayed());
        chonThe.click();

        WebElement chonGia = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]"));
        Assert.assertTrue(chonGia.isDisplayed());
        chonGia.click();

        WebElement chonMua = driver.findElement(By.xpath("//div[contains(text(),'Chọn mua')]"));
        Assert.assertTrue(chonMua.isDisplayed());
        chonMua.click();

        WebElement chonPhuongThuc = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/label[1]"));
        Assert.assertTrue(chonPhuongThuc.isDisplayed());
        chonPhuongThuc.click();

        WebElement thanhToan = driver.findElement(By.xpath("//button[contains(text(),'Thanh toán')]"));
        Assert.assertTrue(thanhToan.isDisplayed());
        thanhToan.click();



    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
