package selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageHome {

    private WebDriver chromeDriver;

    public PageHome(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }


    public void loadHome() {
        chromeDriver.get("https://www.icarros.com.br/principal/index.jsp");
    }


    public String getTitle() {
        return chromeDriver.getTitle();
    }


    public PageFilteredSearch selectCarBrandAndModel(String brand, String model) throws InterruptedException {

        waitElement(chromeDriver);

        chromeDriver.findElement(By.cssSelector("div.col-xs-4 button.button--large")).click();
        Thread.sleep(5000);

        chromeDriver.findElement(By.xpath("//a[@id='15']")).click();
        Thread.sleep(3000);

        chromeDriver.findElement(By.xpath("//a[@id='607']")).click();
        Thread.sleep(3000);

        chromeDriver.findElement(By.xpath("//ul[@id='ftr_ul_0km_/_seminovo']//a[@id='1']")).click();
        Thread.sleep(3000);

        return new PageFilteredSearch(chromeDriver);
    }


    public static void waitElement(WebDriver chromeDriver) {

        FluentWait fluentWait = new FluentWait(chromeDriver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(ElementClickInterceptedException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.footer__content li.list-nav__item:nth-child(1) a.list-nav__link:nth-child(2)")));
    }

}
