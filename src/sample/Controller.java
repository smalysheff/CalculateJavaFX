package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text textWindow;
    private long num1 = 0;
    private long num2 = 0;

    private boolean start = true;

    private String operator = "";
    Model model = new Model();


    @FXML
    private void processNum(ActionEvent event){
        if(start){
            textWindow.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        textWindow.setText(textWindow.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)){
            if(!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(textWindow.getText());
            textWindow.setText("");
        }
        if(operator.isEmpty()) return;
        textWindow.setText(String.valueOf(model.calculation(num1, Long.parseLong(textWindow.getText()), operator)));
        operator = "";
        start = true;
    }

    @FXML
    private void processClear(ActionEvent event){
        textWindow.setText("");
    }


}
