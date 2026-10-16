module com.school.shapes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.shapes to javafx.fxml;
    exports com.school.shapes;
}