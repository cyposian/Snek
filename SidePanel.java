import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class SidePanel {

    String bodyFont;
    Font mainFont;
    DecimalFormat deci;

    public SidePanel() {
        bodyFont = "Monospaced";
        deci = new DecimalFormat("0.00");

        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("./font/PROXON.ttf");
            mainFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
         } catch (IOException e) {
            e.printStackTrace();
         } catch (FontFormatException e) {
            e.printStackTrace();
         }
    }

    public void draw(Graphics g) { // draw main panel
        g.setColor(Color.yellow);
        g.setFont(mainFont.deriveFont(Font.BOLD, 30f));;
        g.drawString("Snek", 620, 80);
  
        g.setColor(Color.white);
        g.setFont(new Font(bodyFont, Font.PLAIN, 18));
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
        g.setFont(mainFont.deriveFont(18f));
        g.drawString("Controls :", 530, 300);
        g.drawString("Difficulty :", 670, 300);
    }

    public void drawStartScreen(Graphics g) {
        g.setColor(Color.cyan);
         g.setFont(mainFont.deriveFont(35f));
         g.drawString("Select a difficulty", 95, 225);
         g.drawString("to start", 185, 295);
    }

    public void drawEndScreen(Graphics g) {
        if(SnakePanel.score > SnakePanel.high) {
            SnakePanel.high = SnakePanel.score;
            g.setFont(mainFont.deriveFont(Font.BOLD, 40f));
            g.setColor(Color.orange);
            g.drawString("NEW HIGH SCORE !", 60, 180);
            g.setColor(Color.red);
            g.drawString("GAME OVER", 135, 255);
            g.setFont(mainFont.deriveFont(35f));
            g.drawString("Press Enter to Restart", 55, 330);
         } else {
            g.setColor(Color.red);
            g.setFont(mainFont.deriveFont(Font.BOLD, 38f));
            g.drawString("GAME OVER", 135, 200);
            g.setFont(mainFont.deriveFont(35f));
            g.drawString("Press Enter to Restart", 45, 275);
         }
    }
}
