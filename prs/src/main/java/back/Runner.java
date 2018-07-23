package back;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import sample.Controller;

import java.util.ArrayList;

import static com.codeborne.selenide.Configuration.browser;

public class Runner {
    private LogPage lp;
    private MainPage mp;

    private String LogPageUrl = "file:///C:/Users/dimka/IdeaProjects/prs/testPages/%D0%A0%D0%B5%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%86%D0%B8%D1%8F%20%D0%B2%20%D1%81%D0%B8%D1%81%D1%82%D0%B5%D0%BC%D0%B5.html";
    private String MainPageUrl = "file:///C:/Users/dimka/IdeaProjects/prs/testPages/%D0%93%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F%20%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0.html";

    private String login = "finex.rul600r";
    private String password = "123";

    public void Go(Controller ctrl) {
        browser = "Chrome";

        lp = new LogPage(login, password, LogPageUrl);
        lp.Open();
        lp.LogIn();

        mp = new MainPage(MainPageUrl);
        mp.Open();
        ArrayList<QElement> data = mp.Parse(ctrl.getClientTextField().getText(),
                ctrl.getStepTextField().getText(),
                ctrl.getSumFromTextField().getText(),
                ctrl.getSumToTextField().getText(),
                ctrl.getFinDateTextField().getText()
        );

        ctrl.storage.addAll(data);
    }
}
