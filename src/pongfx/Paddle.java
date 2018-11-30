
package pongfx;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle
{
    private static Rectangle paddle1, paddle2;
    
    public Paddle()
    {
        paddle1 = new Rectangle(5, (PongFx.root.getHeight() - 160)/2, 40, 160);
        paddle1.setFill(Color.WHITE);
        paddle2 = new Rectangle((PongFx.root.getWidth()- 45), (PongFx.root.getHeight() - 160)/2, 40, 160);
        paddle2.setFill(Color.WHITE);
    }
    
    public void render(AnchorPane root)
    {
        root.getChildren().addAll(paddle1, paddle2);
        System.out.println("Paddles Rendered...");
    }
    
    public static Rectangle getPaddle1()
    {
        return paddle1;
    }
    
    public static Rectangle getPaddle2()
    {
        return paddle2;
    }
}
