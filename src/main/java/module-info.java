module com.managestage.managestage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.managestage.managestage to javafx.fxml;
    exports com.managestage.managestage;
}