import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class SidePanel {

    String myFont, myFont2;
    DecimalFormat deci;

    public SidePanel() {
        myFont = SnakePanel.myFont;
        myFont2 = SnakePanel.myFont2;
        deci = SnakePanel.deci;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);  //draw right panel
        g.setFont(new Font(myFont, Font.BOLD, 30));;
        g.drawString("Snek", 620, 80);
  
        g.setColor(Color.white);
        g.setFont(new Font(myFont2, Font.PLAIN, 18));
        g.drawString("Score: " + SnakePanel.score, 530, 120);
        g.drawString("Fruits: " + SnakePanel.fruits, 530, 150);
        g.drawString("Value: " + SnakePanel.fruitWorth, 530, 180);
        g.drawString("Time: " + deci.format((double) SnakePanel.ms / 1000), 530, 210);
        g.drawString("High Score: " + SnakePanel.high, 530, 240);
  
        g.drawString("Up/W", 530, 330);
        g.drawString("Down/S", 530, 360);
        g.drawString("Left/A", 530, 390);
        g.drawString("Right/D", 530, 420);
        g.drawString("Pause:P", 530, 450);
        g.setFont(new Font(myFont, Font.PLAIN, 18));
        g.drawString("Controls :", 530, 300);
        g.drawString("Difficulty :", 670, 300);
    }

    public void drawStartScreen(Graphics g) {
        g.setColor(Color.cyan);
         g.setFont(new Font(myFont, Font.PLAIN, 35));
         g.drawString("Select a difficulty", 95, 225);
         g.drawString("to start", 185, 295);
    }

    public void drawEndScreen(Graphics g) {
        if(SnakePanel.score > SnakePanel.high) {
            SnakePanel.high = SnakePanel.score;
            g.setFont(new Font(myFont, Font.BOLD, 40));
            g.setColor(Color.orange);
            g.drawString("NEW HIGH SCORE !", 60, 180);
            g.setColor(Color.red);
            g.drawString("GAME OVER", 130, 255);
            g.setFont(new Font(myFont, Font.PLAIN, 35));
            g.drawString("Press Enter to Restart", 50, 330);
         } else {
            g.setColor(Color.red);
            g.setFont(new Font(myFont, Font.BOLD, 38));
            g.drawString("GAME OVER", 135, 200);
            g.setFont(new Font(myFont, Font.PLAIN, 35));
            g.drawString("Press Enter to Restart", 45, 275);
         }
    }
}
