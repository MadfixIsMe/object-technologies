module com.example.cvicenie_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.cvicenie_1 to javafx.fxml;
    exports com.example.cvicenie_1;
}