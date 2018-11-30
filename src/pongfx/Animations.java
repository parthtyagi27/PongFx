
package pongfx;

import javafx.animation.AnimationTimer;

public interface Animations 
{
    
  
    public AnimationTimer loop = new AnimationTimer()
    {
        @Override
        public void handle(long now)
        {
            if(PongFx.gameRunning == true)
            {
                PongFx.checkCollision();
                if(Physics.movingRight == true)
                {
                    Ball.getBall().setCenterX(Ball.getBall().getCenterX()+3);
                    
                    if(Physics.movingDown == true)
                    {
                        Ball.getBall().setCenterY(Ball.getBall().getCenterY()+3);
                    }else if(Physics.movingUp == true)
                    {
                        Ball.getBall().setCenterY(Ball.getBall().getCenterY()-3);
                    }
                    
                }else if(Physics.movingLeft == true)
                {
                    Ball.getBall().setCenterX(Ball.getBall().getCenterX()-3);
                    
                    if(Physics.movingDown == true)
                    {
                        Ball.getBall().setCenterY(Ball.getBall().getCenterY()+3);
                    }else if(Physics.movingUp == true)
                    {
                        Ball.getBall().setCenterY(Ball.getBall().getCenterY()-3);
                    }
                }
               
                if(Controls.upPressed == true)
                {
                    Paddle.getPaddle1().setLayoutY(Paddle.getPaddle1().getLayoutY()-3);
                }else if(Controls.downPressed == true)
                {
                    Paddle.getPaddle1().setLayoutY(Paddle.getPaddle1().getLayoutY()+3);
                }

            }
        }
    };
    
}
