module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.swing;
    requires java.naming;

    opens hust.soict.dsai.javafx.painter;
    opens hust.soict.dsai.aims.screen to javafx.fxml;
}