package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPastebinPage extends AbstractPage {

    @FindBy(id = "success")
    private List<WebElement> success;

    @FindBy(xpath = "//div[@id='code_frame']/div[@id='selectable']/ol")
    private WebElement typeOfSyntaxHighlightning;

    @FindBy(xpath = "//textarea[@id='paste_code']")
    private WebElement resultCode;

    protected ResultPastebinPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResolutionSuccess() {
        return success.size() > 0;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public String getSyntaxHighlightning() {
        return typeOfSyntaxHighlightning.getAttribute("class");
    }

    public String getCodeEquals() {
        return resultCode.getText();
    }
}
