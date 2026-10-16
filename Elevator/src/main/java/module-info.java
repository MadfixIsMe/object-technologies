module com.school.elevator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.elevator to javafx.fxml;
    exports com.school.elevator;
}