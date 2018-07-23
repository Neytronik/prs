package sample;

import back.QElement;

import back.Runner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javax.xml.soap.Text;

public class Controller {

    @FXML
    private TableView<QElement> outputTableView;

    @FXML
    private TableColumn<QElement, String> clientCol;

    @FXML
    private TableColumn<QElement, String> stepCol;

    @FXML
    private TableColumn<QElement, String> productCol;

    @FXML
    private TableColumn<QElement, String> sumCol;

    @FXML
    private TableColumn<QElement, String> begDateCol;

    @FXML
    private TableColumn<QElement, String> finDateCol;

    @FXML
    private TextField clientTextField;

    @FXML
    private TextField stepTextField;

    @FXML
    private TextField finDateTextField;

    @FXML
    private TextField sumFromTextField;

    @FXML
    private TextField sumToTextField;

    public final ObservableList<QElement> storage = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        clientCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("client"));
        stepCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("step"));
        productCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("product"));
        sumCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("sum"));
        begDateCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("begDate"));
        finDateCol.setCellValueFactory(new PropertyValueFactory<QElement, String>("finDate"));

        outputTableView.setItems(storage);

        /*
        sumToTextField.textProperty().addListener((ObservableValue o, TextField oldVal, TextField newVal) -> {
            if (!"".equals(oldVal.getText()) && !oldVal.getText().matches("[0-9]+"))
                sumToTextField.setText("dsgjfkd");

        });
        */
    }

    @FXML
    private void ClearTextFields (){
        clientTextField.clear();
        stepTextField.clear();
        finDateTextField.clear();
        sumFromTextField.clear();
        sumToTextField.clear();
    }

    @FXML
    private void Search() {

        outputTableView.getItems().clear();

        Runnable runner  = () ->{
            Runner ins = new Runner();
            ins.Go(this);
        };

        new Thread(runner).run();
    }

    public TextField getClientTextField() {
        return clientTextField;
    }

    public TextField getFinDateTextField() {
        return finDateTextField;
    }

    public TextField getStepTextField() {
        return stepTextField;
    }

    public TextField getSumFromTextField() {
        return sumFromTextField;
    }

    public TextField getSumToTextField() {
        return sumToTextField;
    }
}
