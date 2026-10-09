module com.school.semaforr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.semaforr to javafx.fxml;
    exports com.school.semaforr;
}