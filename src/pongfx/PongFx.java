
package pongfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Parth
 */
public class PongFx extends Application implements Handlers
{
    public static AnchorPane root;
    public static boolean gameRunning = false;
    public static boolean gamePaused = false;
    
    private static Paddle paddle;
    private static UI ui;
    private static Ball ball;
    
    public void start(Stage primaryStage)
    {
      
        root = new AnchorPane();
        
        Scene scene = new Scene(root, 750, 450);
        scene.setOnKeyPressed(keyDuringGame);
        primaryStage.setTitle("PongFx");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/icon.png")));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        primaryStage.show();
        initalize();
    }
    
    private void initalize()
    {
        ui = new UI();
        paddle = new Paddle();
        ball = new Ball();
        ui.showUI(root);
    }
    
    public void render()
    {
        paddle.render(root);
        ball.render(root);
        System.out.println("Rendered...");
        Physics.generateInitialMovement();
    }
    
    public static void checkCollision()
    {
        if(gameRunning == true)
        {
            if(Ball.getBall().intersects(Paddle.getPaddle2().getBoundsInParent()))
            {
                System.out.println("Collision with Paddle 2");
                Physics.movingRight = false;
                Physics.movingLeft = true;
                
            }else if(Ball.getBall().intersects(Paddle.getPaddle1().getBoundsInParent()))
            {
                System.out.println("Collision with Paddle 1");
                Physics.movingRight = true;
                Physics.movingLeft = false;
            }else if((Ball.getBall().getCenterY() + Ball.getBall().getRadius()) <= 45)
            {
                System.out.println("Collision with Edge");
                Physics.movingUp = false;
                Physics.movingDown = true;
            }else if((Ball.getBall().getCenterY() + Ball.getBall().getRadius()) >= 455)
            {
                System.out.println("Collision with Edge");
                Physics.movingUp = true;
                Physics.movingDown = false;
            }else if((Ball.getBall().getCenterX() + Ball.getBall().getRadius()) <= 45)
            {
                System.out.println("Collision with Edge");
                Physics.movingRight = true;
                Physics.movingLeft = false;
                Score.scoreForAi++;
                UI.updateUI(UI.scoreLabelAi, Score.scoreForAi);
            }else if((Ball.getBall().getCenterX() + Ball.getBall().getRadius()) >= 755)
            {
                System.out.println("Collision with Edge");
                Physics.movingRight = false;
                Physics.movingLeft = true;
                Score.scoreForPlayer++;
                UI.updateUI(UI.scoreLabelPlayer, Score.scoreForPlayer);
            }
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
