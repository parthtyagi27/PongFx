
package pongfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public interface Handlers extends Animations
{
    
    public EventHandler<KeyEvent> keyevent = (KeyEvent event) ->
    {
        if(event.getCode() == KeyCode.SPACE && PongFx.gameRunning == false)
        {
            System.out.println("true");
            PongFx.gameRunning = true;
            System.out.println("Game Running: true");
            UI ui = new UI();
            ui.removeUI(PongFx.root);
        }
    };
    
    public EventHandler<KeyEvent> keyDuringGame = (KeyEvent event) ->
    {
        if(event.getCode() == KeyCode.ESCAPE && PongFx.gameRunning == true && PongFx.gamePaused == false)
        {
            loop.stop();
            PongFx.gamePaused = true;
            System.out.println("Loop stopped...");
        }else if(event.getCode() == KeyCode.ESCAPE && PongFx.gameRunning == true && PongFx.gamePaused == true)
        {
            loop.start();
            PongFx.gamePaused = false;
            System.out.println("Loop started...");
        }
        
        if(event.getCode() == KeyCode.UP && PongFx.gameRunning == true && PongFx.gamePaused == false)
        {
            Controls.upPressed = true;
            Controls.downPressed = false;
            //Paddle.getPaddle1().setLayoutY(Paddle.getPaddle1().getLayoutY()-3);
        }else if(event.getCode() == KeyCode.DOWN && PongFx.gameRunning == true && PongFx.gamePaused == false)
        {
            Controls.downPressed = true;
            Controls.upPressed = false;
            //Paddle.getPaddle1().setLayoutY(Paddle.getPaddle1().getLayoutY()+3);
        }
        
        if(event.getCode() == KeyCode.O  && PongFx.gameRunning == true && PongFx.gamePaused == false)
        {
            loop.stop();
            OptionsWindow op = new OptionsWindow();
            op.show();
            System.out.println("Loaded Options Window...");
        }
    };
    
    public EventHandler<MouseEvent> smoothPaddle = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent event)
        {
            if(OptionsConfig.smoothPaddleMovement == false)
            {
                OptionsConfig.smoothPaddleMovement = true;
                try
                {
                    FileUtil.write("smoothmovement", OptionsConfig.smoothPaddleMovement);
                } catch (IOException ex) 
                {
                    Logger.getLogger(Handlers.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Smooth Paddles: True");
            }else if(OptionsConfig.smoothPaddleMovement == true)
            {
                OptionsConfig.smoothPaddleMovement = false;
                try
                {
                    FileUtil.write("smoothmovement", OptionsConfig.smoothPaddleMovement);
                } catch (IOException ex) 
                {
                    Logger.getLogger(Handlers.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Smooth Paddles: False");
            }
        }
    };
}
