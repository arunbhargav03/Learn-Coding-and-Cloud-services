package DoubleLinkedList;

import java.util.Scanner;

public class DllDemo {
    DllNode head = null;

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        DllDemo demo = new DllDemo();
        do
        {
            System.out.println("\n********* MENU *********");
            System.out.println("\n1.Insert In Next");
            System.out.println("\n2.Insert In Beginning");
            System.out.println("\n3.Insert At A  Particular Pos");
            System.out.println("\n4.Delete At a Pos");
            System.out.println("\n5.Length");
            System.out.println("\n6.Reverse");
            System.out.println("\n7.Display");
            System.out.println("\n8.EXIT");
            System.out.println("\nenter ur choice : ");
            String value;
            int choice=in.nextInt();
            switch(choice)
            {

                case 1:
                    System.out.println("\nenter the value ");
                    value = in.next();

                    demo.insertNext(value);
                    break;
                case 2:
                    System.out.println("\nenter the value ");
                    value = in.next();
                    demo.insertInBegining(value);
                    break;
                case 3:
                    System.out.println("\nenter the value ");
                    value = in.next();
                    System.out.println("\nenter the position ");
                    demo.insertAtPosition(value,in.nextInt());
                    break;

                case 5:
                    System.out.println("size is:"+demo.calcLength());
                    break;
                case 7:
                    demo.display();
                    break;
                case 4:
                    System.out.println("\nenter the position to delete");
                    demo.deleteAtPosition(in.nextInt());
                    break;
                case 6:
                    demo.reverse_old();
                    break;

                case 8: System.exit(0);
                    break;
                default: System.out.println("\n Wrong Choice!");
                    break;
            }
            //System.out.println("\n do u want to cont... ");
        }while(true);


    }

    private int calcLength() {
        DllNode temp = head;
        int length=0;
        if(head!=null){
            length++;
            while(temp.next!=null){
                length++;
                temp=temp.next;
            }
        }
        return length;
    }


    public void insertNext(String value){
        DllNode dllNode = new DllNode();
        dllNode.data= value;
        if(this.head == null){
            this.head = dllNode;
        }else{
            DllNode temp = this.head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = dllNode;
            dllNode.prev =temp;
        }

    }

    public void insertInBegining(String value){
        DllNode dllNode = new DllNode();
        dllNode.data= value;
        if (this.head == null){
            this.head = dllNode;
        }
        else{
            DllNode temp = this.head;
            temp.prev = dllNode;
            dllNode.next = temp;
            this.head = dllNode;
        }

    }

    public void display(){
        DllNode temp = this.head;
        int i=1;
        while(temp.next!=null){
            System.out.println(i+" :data-->"+temp.data);
            temp=temp.next;
            i++;
        }
        if(temp.next == null){
            System.out.println(i+" :data-->"+temp.data);

        }
    }

    public void insertAtPosition(String value, int position){
        int length = calcLength();
        if(length<position){
            System.out.println("Length of LinkedList is :"+length);
            System.out.println("The give position "+position+" is greater than linked list length press Y to insert in last of current list or N to exit?");
            Scanner in=new Scanner(System.in);
            if("Y".equalsIgnoreCase(in.next())){
                insert(value, position);
            }
        }else{
            insert(value, position);
        }

    }

    public void insert(String value, int position ){
        DllNode dllNode = new DllNode();
        dllNode.data= value;
        DllNode temp = head;
        int index=1;
        if(temp==null){
            head = dllNode;
        }else{
            while(index<position) {
                if (temp.next != null) {
                    temp = temp.next;
                    index++;
                }else{
                    break;
                }
            }
            if(temp.next!=null && temp.prev!=null){
                dllNode.prev=temp.prev;
                dllNode.next=temp;
                temp.prev.next=dllNode;
            }
            else if(temp.next==null){
                temp.next=dllNode;
                dllNode.prev=temp;
            }else if(temp.prev==null){
                dllNode.next=temp;
                temp.prev =dllNode;
                head=dllNode;
            }
        }
    }
    public void deleteAtPosition(int position){
        int length = calcLength();
        if(length<position){
            System.out.println("Length of LinkedList is :"+length);
            System.out.println("The give position "+position+" is greater than linked list length please enter correct position.");

        }else{
            delete(position);
        }

    }

    public void delete(int position ){
        DllNode temp = head;
        int index=1;
        if(temp==null){
            System.out.println("linked list is empty");
        }else{
            while(index<position) {
                if (temp.next != null) {
                    temp = temp.next;
                    index++;
                }else{
                    break;
                }
            }
            if(temp.next!=null && temp.prev!=null){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }
            else if(temp.next==null && temp.prev==null){
                head=null;
            }
            else if(temp.prev==null){
                temp.next.prev = null;
                head = temp.next;
            }
            else if(temp.next==null){
                temp.prev.next=null;
            }
        }
    }

    public void reverse_old() {

        DllNode lastNode = head;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
        }
        DllNode temp = null;

        while (lastNode != null) {
            temp = lastNode.next;
            lastNode.next = lastNode.prev;
            lastNode.prev = temp;
            lastNode = lastNode.next;
        }
        while(head.prev!=null){
            head=head.prev;
        }
    }

}
