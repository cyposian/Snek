package src;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Image;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snek");
         frame.setSize(825, 541);
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         SnakePanel snek = new SnakePanel();
       	 frame.setContentPane(snek);
         frame.setVisible(true);
        Image i = Toolkit.getDefaultToolkit().getImage("/media/snake.png");
        frame.setIconImage(i);

        snek.startGameThread();
    }
}
