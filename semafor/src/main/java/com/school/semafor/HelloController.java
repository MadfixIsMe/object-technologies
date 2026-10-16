import com.school.semafor.Semafor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

Semafor s = new Semafor();

public class HelloController {
    @FXML private Pane root;

    @FXML private void draw(){
        root.getChildren().add(s);
    }

    @FXML protected void zmenStav(){
        s.zmenStav();
    }

    @FXML protected void auto(){
        s.start();
    }
}

