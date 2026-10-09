module com.school.auto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.auto to javafx.fxml;
    exports com.school.auto;
}