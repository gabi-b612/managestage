module com.managestage.managestage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires fontawesomefx;
    requires org.json;

    opens com.managestage.managestage to javafx.fxml;
    exports com.managestage.managestage;
    exports com.managestage.managestage.controller;
    opens com.managestage.managestage.controller to javafx.fxml;
}