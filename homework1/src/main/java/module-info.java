module com.school.homework1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.homework1 to javafx.fxml;
    exports com.school.homework1;
}