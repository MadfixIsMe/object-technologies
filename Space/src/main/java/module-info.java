module com.school.space {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.space to javafx.fxml;
    exports com.school.space;
}