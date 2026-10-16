module com.school.animals {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.school.animals to javafx.fxml;
    exports com.school.animals;
}