public class Snake {
    Node head; //head of list
    public Snake(int start, int l){
        for(int k = 0; k < l; k++){
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
    public void append(int x, int y){
        Node temp = new Node(x, y);
        
        if(head == null){
            head = temp;
            return;
        }
        temp.next = null;

        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = temp;       //could recode this for N(0) by having pointer to last node
        return;
    }
    public void push(int x, int y){
        Node temp = new Node(x, y);
        temp.next = head;
        head = temp;
    }
    public void deleteLast(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void move(int x, int y, boolean ateApple){   //movement by deleting last, pushing head
        if(!ateApple){ //only delete tail if haven't eaten apple
            deleteLast();
        }
        push(head.xcor+x,head.ycor+y);
    }
    public boolean ateSelf(int x, int y){
        Node temp = head.next;
        while(temp != null){
           if(temp.xcor == head.xcor + x && temp.ycor == head.ycor + y){
              return true;
           }
           temp = temp.next;
        }
        return false;
     }
}