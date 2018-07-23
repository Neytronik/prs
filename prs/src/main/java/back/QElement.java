package back;

import com.codeborne.selenide.ElementsCollection;
import javafx.beans.property.SimpleStringProperty;

public class QElement {
  //public String AppNmb;
  //public String executer;
    private final SimpleStringProperty client;
    private final SimpleStringProperty step;
  //public String status;
    private final SimpleStringProperty product;
    private final SimpleStringProperty sum;
  //public String result;
    private final SimpleStringProperty begDate;
    private final SimpleStringProperty finDate;

    public QElement(ElementsCollection row){

      //this.AppNmb = row.get(0).getText();
        this.client = new SimpleStringProperty(row.get(1).getText());
        this.step = new SimpleStringProperty(row.get(2).getText());
      //this.status = row.get(3).getText();
        this.product = new SimpleStringProperty(row.get(4).getText());
        this.sum = new SimpleStringProperty(ToParsableSum(row.get(5).getText()));
        this.begDate = new SimpleStringProperty(row.get(6).getText());
        this.finDate = new SimpleStringProperty(row.get(7).getText());
      //this.result = "";
      //this.executer = "";
    }

    public QElement(int a){

      //this.AppNmb = row.get(0).getText();
        this.client = new SimpleStringProperty("test");
        this.step = new SimpleStringProperty("test");
      //this.status = row.get(3).getText();
        this.product = new SimpleStringProperty("test");
        this.sum = new SimpleStringProperty("test");
        this.begDate = new SimpleStringProperty("test");
        this.finDate = new SimpleStringProperty("test");
      //this.result = "";
      //this.executer = "";
    }


    private String ToParsableSum(String tmp_sum)
    {

        StringBuilder bld_sum = new StringBuilder();

        for (int i = 0; tmp_sum.charAt(i) != 'р'; i++) {
            if (Character.isDigit(tmp_sum.charAt(i))) {
                bld_sum.append(tmp_sum.charAt(i));
            }
        }

        return bld_sum.toString();
    }

    public String getSum() {
        return sum.get();
    }

    public void setSum(String fSum) {
        sum.set(fSum);
    }

    public String getProduct() {
        return product.get();
    }

    public void setProduct(String fProduct){
        product.set(fProduct);
    }

    public String getFinDate() {
        return finDate.get();
    }

    public void setFinDate(String fFinDate) {
        finDate.set(fFinDate);
    }

    public String getClient() {
        return client.get();
    }

    public void setClient(String fClient) {
        client.set(fClient);
    }

    public String getBegDate() {
        return begDate.get();
    }

    public void setBegDate(String fBegDate) {
        begDate.set(fBegDate);
    }

    public String getStep() {
        return step.get();
    }

    public void setStep(String fStep) {
        step.set(fStep);
    }
}
