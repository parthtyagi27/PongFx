
package pongfx;

import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class OptionsWindow implements Handlers
{
    private AnchorPane root;
    private CheckBox smoothPlayerPaddleCheckbox;
    
    
    public void show()
    {
        Stage stage = new Stage();
        root = new AnchorPane();
        Scene scene = new Scene(root, 300, 350);
        stage.setTitle("Options");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/res/options.png")));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        render(root);
        bindHandlers();
    }
    
    private void render(AnchorPane root)
    {
       smoothPlayerPaddleCheckbox = new CheckBox("Smooth Paddles");
       smoothPlayerPaddleCheckbox.setTextAlignment(TextAlignment.CENTER);
       smoothPlayerPaddleCheckbox.setLayoutX(10);
       smoothPlayerPaddleCheckbox.setLayoutY(25);
       smoothPlayerPaddleCheckbox.setTooltip(new Tooltip("Use smoother Paddle movements"));
       root.getChildren().add(smoothPlayerPaddleCheckbox);
    }
    private void bindHandlers()
    {
        smoothPlayerPaddleCheckbox.setOnMouseClicked(smoothPaddle);
    }
}
