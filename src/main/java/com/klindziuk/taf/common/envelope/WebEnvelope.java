package com.klindziuk.taf.common.envelope;

import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.driver.DriverManager;
import com.klindziuk.taf.common.log.Info;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Wrapper class for 'WebElement'
 */
public class WebEnvelope implements Envelope {

    private By by;
    private WebDriver webDriver;
    private WebElement webElement;

    public WebEnvelope(LocatorType locatorType, String locatorPath) {
        this.by = LocatorType.getBy(locatorType, locatorPath);
        this.webDriver = DriverManager.getDriver();
    }

    @Override
    public boolean isVisible() {
        try {
            return getWebElement().isDisplayed() && getWebElement().isEnabled();
        } catch (NoSuchElementException | StaleElementReferenceException sErEx) {
            return false;
        }
    }

    @Override
    public boolean isVisible(int timeOut) {
        try {
            this.webElement = new WebDriverWait(this.webDriver, timeOut).until(
                    ExpectedConditions.visibilityOfElementLocated(this.by));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void waitForNotVisible() {
        new WebDriverWait(this.webDriver, TimeConstant.SECONDS_15).until(
                ExpectedConditions.invisibilityOfElementLocated(this.by));
    }

    @Override
    public String getText() {
        return waitForVisible().getWebElement().getText();
    }

    @Override
    public WebEnvelope waitForVisible() {
        this.webElement = new WebDriverWait(this.webDriver, TimeConstant.SECONDS_20).until(
                ExpectedConditions.visibilityOfElementLocated(this.by));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WebElement> getElementList() {
        return new WebDriverWait(this.webDriver, TimeConstant.SECONDS_20).until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

   public WebEnvelope sendText(String text) {
        getWebElement().sendKeys(text);
        return this;
    }

    public WebEnvelope click() {
        getWebElement().click();
        return this;
    }

    public WebEnvelope pause(int seconds) {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException iEx) {
            Thread.currentThread().interrupt();
            Info.error(iEx);
        }
        return this;
    }

    public WebElement getWebElement() {
        if (Objects.nonNull(this.webElement)) {
            return this.webElement;
        }
        this.webElement = this.webDriver.findElement(this.by);
        return this.webElement;
    }
}
