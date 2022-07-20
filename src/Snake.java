package src;
import java.awt.Color;
import java.awt.Graphics;

public class Snake {

    Node head; // head of list

    public Snake(int start, int l) {
        for(int k = 0; k < l; k++) {
            this.append(start, start);
        }
    }

    public static class Node { /* Linked list Node.  This inner class is made static so that main() can access it */
        int xcor;
        int ycor;
        Node next;
        public Node(int x, int y){
            xcor = x;
            ycor = y;
            next = null;
        }
        public void setxcor(int x){
            xcor = x;
        }
        public void setycor(int y){
            ycor = y;
        }
    }

    public void append(int x, int y) {
        Node temp = new Node(x, y);
        
        if(head == null) {
            head = temp;
            return;
        }
        temp.next = null;

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = temp;       // could recode this for O(1) by having pointer to last node
        return;
    }

    public void push(int x, int y) {
        Node temp = new Node(x, y);
        temp.next = head;
        head = temp;
    }

    public void deleteLast() {
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void move(int x, int y, boolean ateApple) {   // movement by deleting last, pushing head
        if(!ateApple) { // only delete tail if haven't eaten apple
            deleteLast();
        }
        push(head.xcor + x, head.ycor + y);
    }
    public boolean ateSelf(int x, int y) {
        Node temp = head.next;
        while(temp != null) {
           if(temp.xcor == head.xcor + x && temp.ycor == head.ycor + y) {
              return true;
           }
           temp = temp.next;
        }
        return false;
     }

     public void drawSnake(Graphics g) {
        Snake.Node temp = head;
        while(temp != null) { // draw snake body
           g.setColor(Color.black);   // borders of segments
           g.drawRect(temp.xcor, temp.ycor, 20, 20);
           g.setColor(Color.green);   // body
           g.fillRect(temp.xcor + 1, temp.ycor + 1, 19, 19);
           temp = temp.next;
        }
  
        temp = head; // drawing eyes and tongue
        if(SnakePanel.direction == 0) { // up
           g.setColor(Color.black);
           g.fillRect(temp.xcor + 6, temp.ycor + 3, 1, 6);
           g.fillRect(temp.xcor + 14, temp.ycor + 3, 1, 6);
           g.setColor(Color.red);
           g.drawLine(temp.xcor + 10, temp.ycor, temp.xcor + 10, temp.ycor - 3);
           g.drawLine(temp.xcor + 10, temp.ycor - 3, temp.xcor + 8, temp.ycor - 5);
           g.drawLine(temp.xcor + 10, temp.ycor - 3, temp.xcor + 12, temp.ycor - 5);
        } else if(SnakePanel.direction == 2) { // down
           g.setColor(Color.black);
           g.fillRect(temp.xcor + 6, temp.ycor + 11, 1, 6);
           g.fillRect(temp.xcor + 14, temp.ycor + 11, 1, 6);
           g.setColor(Color.red);
           g.drawLine(temp.xcor + 10, temp.ycor + 20, temp.xcor + 10, temp.ycor + 23);
           g.drawLine(temp.xcor + 10, temp.ycor + 23, temp.xcor + 8, temp.ycor + 25);
           g.drawLine(temp.xcor + 10, temp.ycor + 23, temp.xcor + 12, temp.ycor + 25);
        } else if(SnakePanel.direction == 1) { // right
           g.setColor(Color.black);
           g.fillRect(temp.xcor + 11, temp.ycor + 6, 6, 1);
           g.fillRect(temp.xcor + 11, temp.ycor + 14, 6, 1);
           g.setColor(Color.red);
           g.drawLine(temp.xcor + 20, temp.ycor + 10, temp.xcor + 23, temp.ycor + 10);
           g.drawLine(temp.xcor + 23, temp.ycor + 10, temp.xcor + 25, temp.ycor + 8);
           g.drawLine(temp.xcor + 23, temp.ycor + 10, temp.xcor + 25, temp.ycor + 12);
        } else { // left
           g.setColor(Color.black);
           g.fillRect(temp.xcor + 3, temp.ycor + 6, 6, 1);
           g.fillRect(temp.xcor + 3, temp.ycor + 14, 6, 1);
           g.setColor(Color.red);
           g.drawLine(temp.xcor, temp.ycor + 10, temp.xcor - 3, temp.ycor + 10);
           g.drawLine(temp.xcor - 3, temp.ycor + 10, temp.xcor - 5, temp.ycor + 8);
           g.drawLine(temp.xcor - 3, temp.ycor + 10, temp.xcor - 5, temp.ycor + 12);
        }
    }
}