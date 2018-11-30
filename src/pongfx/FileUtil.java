
package pongfx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileUtil
{
    //store options or prefrences
    
    public static String home = System.getProperty("user.home");
    public static String newLine = System.getProperty("line.separator");
    
    public static void write(String property, boolean config) throws FileNotFoundException, IOException
    {
        File file = new File(home + "\\PongFx");
        System.out.println(home);
        if(file.exists() == false)
        {
            file.mkdir();
            file.createNewFile();
        }
        Writer writer = new BufferedWriter(new FileWriter(file.getAbsolutePath() + "\\options.txt", true));
        String toBeWritten = Crypt.encrypt(property, config);
        writer.write(toBeWritten);
        writer.close();
        System.out.println(toBeWritten + " Printed...");
    }
    
    public static void read(String property) throws IOException
    {
        File file = new File(home + "\\PongFx");
        System.out.println(home);
        if(file.exists() == false)
        {
            file.mkdir();
            file.createNewFile();
        }
        FileReader pw = new FileReader(file.getAbsolutePath() + "\\options.txt");
        String toBeWritten = Crypt.decrypt(property);
        
        pw.close();
        System.out.println( " Printed...");
    }
}
