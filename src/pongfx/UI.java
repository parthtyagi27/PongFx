package pongfx;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UI implements Handlers
{
    private static Label spaceLabel;
    public static Label scoreLabelPlayer;
    public static Label scoreLabelAi;
    
    PongFx pong;
    
    public UI()
    {
        pong = new PongFx();
    }
    
    public void showUI(AnchorPane root)
    {
        spaceLabel = new Label("Press the SpaceBar to play");
        spaceLabel.setFocusTraversable(true);
        spaceLabel.setLayoutX(240);
        spaceLabel.setLayoutY(200);
        spaceLabel.setTextFill(Color.WHITE);
        spaceLabel.setFont(Font.font(24));
        spaceLabel.setOnKeyReleased(keyevent);
        root.getChildren().add(spaceLabel);
        System.out.println("UI Drawn...");
    }
    
    public void removeUI(AnchorPane root)
    {
        root.getChildren().remove(spaceLabel);
        System.out.println("Removed UI...");
        pong.render();
        
        scoreLabelAi = new Label("Score: ");
        scoreLabelPlayer = new Label("Score: ");
        scoreLabelAi.setLayoutY(10);
        scoreLabelAi.setLayoutX(690);
        scoreLabelPlayer.setLayoutX(5);
        scoreLabelPlayer.setLayoutY(10);
        scoreLabelAi.setTextFill(Color.WHITE);
        scoreLabelPlayer.setTextFill(Color.WHITE);
        scoreLabelAi.setFont(new Font(14));
        scoreLabelPlayer.setFont(new Font(14));
        root.getChildren().addAll(scoreLabelAi, scoreLabelPlayer);
        

        
    }
    
    public static void updateUI(Label label, int score)
    {
        label.setText("Score: " + score);
        System.out.println("Score Updated...");
    }
}
