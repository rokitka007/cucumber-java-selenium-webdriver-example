package com.automatedtest.sample.searchresultpage;

import com.automatedtest.sample.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;

public class SearchResultPage extends BasePage {

    private static final String RESULTS_URL_SELECTOR = "sr-hotel__name";

    @FindBy(className = RESULTS_URL_SELECTOR)
    private List<WebElement> results;

    SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    void checkExpectedUrlInResults(String expectedName, int nbOfResultsToSearch) {
        wait.forPresenceOfElements(5, By.className(RESULTS_URL_SELECTOR), "Result url");
        Integer indexOfLink = IntStream.range(0, Math.min(this.results.size(), nbOfResultsToSearch))
                .filter(index -> expectedName.equals(this.results.get(index).getText()))
                .findFirst()
                .orElse(-1);
        Assert.assertTrue("Url " + expectedName + " wasn't found in the results.",
                !indexOfLink.equals(-1));
    }
}

