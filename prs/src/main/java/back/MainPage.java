package back;

import com.codeborne.selenide.ElementsCollection;
import sample.Controller;

import java.io.FileWriter;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private String mainPage;
    private ElementsCollection table = $$("#productform\\:claimedTasks_data tr");



    public MainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public ArrayList<QElement> Parse(String client, String step, String sumFrom, String sumTo, String finDate) {

        if ("".equals(sumFrom)) sumFrom = "0";
        if ("".equals(sumTo)) sumTo = "1000000000000000";

        ArrayList<QElement> res = new ArrayList<QElement>(20);
        for (int i = 0; i < table.size(); i++) {
            ElementsCollection row = table.get(i).$$("td:not(*:last-child)");

            QElement tmp = new QElement(row);

            if (tmp.getClient().contains(client) &&
                    (tmp.getStep().contains(step) || "".equals(step)) &&
                    (Long.parseLong(sumFrom) <= Long.parseLong(tmp.getSum()) && Long.parseLong(tmp.getSum()) <= Long.parseLong(sumTo)) &&
                    (tmp.getFinDate().equals(finDate) || "".equals(finDate))) {

                res.add(tmp);
            }
        }

        return res;
    }

    public boolean Open() {

        if (!"".equals(mainPage)) {
            open(mainPage);

            return true;
        }

        return false;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }


}
