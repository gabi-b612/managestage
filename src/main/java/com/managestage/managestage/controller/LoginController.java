package com.managestage.managestage.controller;

import com.managestage.managestage.services.AuthService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.regex.Pattern;

public class LoginController {

    public FontAwesomeIcon closeBtn;
    public Button submitBtn;
    public TextField emailInput;
    public PasswordField passwordInput;

    private final AuthService authService = new AuthService();

    public void closeLoginForm(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void loginAdmin(MouseEvent mouseEvent) {
        String email = emailInput.getText();
        String password = passwordInput.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Veuillez remplir tous les champs.", Alert.AlertType.ERROR);
            return;
        }
        if (!isValidEmail(email)) {
            showAlert("entrer une adresse email valide.", Alert.AlertType.ERROR);
            return;
        }
        try {
            String token = authService.login(email,password);

            if (!token.isEmpty()) {
                showAlert(token, Alert.AlertType.INFORMATION);
            }
        } catch (Exception e) {
            showAlert("Email ou mot de passe incorrect" , Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Erreur");
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
