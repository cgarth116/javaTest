package sample.autorization;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class autorizationController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button enterButton;

        @FXML
        private TextField loginField;

        @FXML
        private Text accessDenied;

        @FXML
        void initialize() {
                enterButton.setOnAction(event -> {
                        String login = loginField.getText().trim();
                        String password = passwordField.getText().trim();

                        if (!login.equals("") && !password.equals("")){
                                login(login,password);
                        }
                });
        }

        private void login(String login, String password) {
                if (login.equals("admin") && password.equals("root")) {
                        openNewWindow("../mainWindow/mainWindow.fxml");
                } else {

                }
        }

        public  void openNewWindow(String window){
                enterButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(window));

                try{
                        loader.load();
                } catch (IOException e){
                        System.out.println(e.getMessage());
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.showAndWait();
        }
}

