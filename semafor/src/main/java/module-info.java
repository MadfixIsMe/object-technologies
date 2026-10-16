module com.school.semafor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.semafor to javafx.fxml;
    exports com.school.semafor;
}