import java.awt.Color;
import java.awt.Graphics;

public class Apple {

   private int xcor, ycor;
   private int appleX, appleY;

   public Apple(Snake s) {
      do{
         appleX = randomLocation(); // random location inside grid boundaries
         appleY = randomLocation();
         } while(inSnake(s, appleX, appleY)); // not spawn in snake
      xcor = appleX;
      ycor = appleY;
   }

   public int getxcor() {
      return xcor;
   }

   public int getycor() {
      return ycor;
   }

   public int randomLocation() {
      return (int)Math.floor((Math.random()*25))*20+1;
   }

   public boolean inSnake(Snake s, int x, int y) {
      Snake.Node temp = s.head;
      while(temp != null) {
         if(temp.xcor == x && temp.ycor == y) {
            return true;
         }
         temp = temp.next;
      }
      return false;
   }

   public void drawApple(Graphics g) {
      g.setColor(Color.red);
      if(this != null)
         g.fillOval(xcor, ycor, 20, 20);
   }
}
