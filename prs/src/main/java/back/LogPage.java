package back;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogPage {
    private String login;
    private String password;
    private String logPage;
    private SelenideElement logForm = $("input[id=j_username]");
    private SelenideElement passForm = $("#j_password");

    public LogPage(String login, String password, String address) {
        this.logPage = address;
        this.login = login;
        this.password = password;
    }


    public boolean Open() {

        if (!"".equals(logPage)) {
            open(logPage);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean LogIn() {
        if (!"".equals(login) && !"".equals(password)) {
            logForm.setValue(login);
            passForm.setValue(password);
            passForm.pressEnter();

            return true;
        }

        return false;
    }


    public String getLogPage() {
        return logPage;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
