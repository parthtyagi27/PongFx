
package pongfx;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball implements Animations
{
    public static Circle ball;
    
    public Ball()
    {
        ball = new Circle((PongFx.root.getWidth())/2, (PongFx.root.getHeight())/2, 25, Color.CORNFLOWERBLUE);
        loop.start();
    }
    
    public static Circle getBall()
    {
        return ball;
    }
    
    public void render(AnchorPane root)
    {
        root.getChildren().add(ball);
        System.out.println("Ball Rendered...");
    }
}
