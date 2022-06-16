import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Image;

public class SnakeDrive {
    public static void main(String[] args){
        JFrame frame = new JFrame("Snek");
         frame.setSize(825, 541);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	 frame.setContentPane(new SnakePanel());
         frame.setVisible(true);
         frame.setResizable(false);
        Image i = Toolkit.getDefaultToolkit().getImage("snake.png");
        frame.setIconImage(i);
    }
}
