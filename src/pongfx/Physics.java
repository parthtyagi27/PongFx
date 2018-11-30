
package pongfx;

import java.util.Random;

public class Physics
{
    public static boolean movingLeft = false;
    public static boolean movingRight = true;
    public static boolean movingUp;
    public static boolean movingDown;
    
    private Random random;
    
    
    public static void generateInitialMovement()
    {
        String update;
        
        Random random = new Random();
        int generatedNumber = random.nextInt(2);
        if(generatedNumber == 0)
        {
            movingUp = true;
            movingDown = false;
            update = "Upwards";
        }else
        {
            movingUp = false;
            movingDown = true;
            update = "Downwards";
        }
        
        System.out.println("Generated Movement: " + update);
    }
    
}
