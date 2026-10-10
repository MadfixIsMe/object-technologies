module com.school.ball {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.ball to javafx.fxml;
    exports com.school.ball;
}