
package DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DllDemo {

    public static Map<String, DllNode> myDoubleLinkedLists;

    public static DllDemo demo = new DllDemo();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        myDoubleLinkedLists = new HashMap<>();
        mainMenu();
    }

    private static void mainMenu() {

        do{
            System.out.println("*****Welcome to create Double LinkedList****");
            System.out.println("\n1. Create a new List");
            System.out.println("\n2. Manage existing list");
           // System.out.println("\n3. Display all lists");
            System.out.println("\n4. Delete list");
            System.out.println("\n5.EXIT");
            System.out.println("\nEnter ur choice : ");
            switch (in.nextInt()){
                case 1:
                    System.out.println("Enter the name of the list: ");
                    String name = in.next();
                    DllNode head = DllDemo.demo.createNewList();
                    DllDemo.myDoubleLinkedLists.put(name, head);
                    break;

                case 2:
                    System.out.println("Enter the name of the list to manage: ");
                    manageList(in.next());
                    break;
                case 4:
                    System.out.println("Enter the name of the list to delete: ");
                    deleteList(in.next());
                    break;
                case 5:
                    System.exit(0);
                    break;
                default: System.out.println("\n Wrong Choice!");
                    break;
            }
        }while(true);
    }

    private static void deleteList(String name) {
        if(DllDemo.myDoubleLinkedLists.containsKey(name)){
            DllDemo.myDoubleLinkedLists.remove(name);
        }else{
            System.out.println("linked list with give name doesn't exist");
        }

    }

    private static void manageList(String name) {
        DllNode head = null;
        if(DllDemo.myDoubleLinkedLists.containsKey(name)){
            head= DllDemo.myDoubleLinkedLists.get(name);
        }else{
            System.out.println("linked list with give name doesn't exist");
        }

        if(head==null){
            System.out.println(name+" is empty please insert values");
            head = DllDemo.demo.createNewList();
            DllDemo.myDoubleLinkedLists.put(name, head);
        }else{
            int choice=0;
            do{
                System.out.println("\n********* Manage MENU *********");
                System.out.println("\n1.Insert Next");
                System.out.println("\n2.Insert In Beginning");
                System.out.println("\n3.Insert At A  Particular Pos");
                System.out.println("\n4.Delete At a Pos");
                System.out.println("\n5.Reverse the list");
                System.out.println("\n6.Length of list");
                System.out.println("\n7.Display list");
                System.out.println("\n8.Back to previous menu.");
                System.out.println("\nEnter ur choice : ");
                String value;
                choice=in.nextInt();
                switch(choice) {

                    case 1:
                        System.out.println("\nEnter the value ");
                        value = in.next();
                        DllDemo.myDoubleLinkedLists.put(name, DllDemo.demo.insertNext(value, head));
                        break;
                    case 2:
                        System.out.println("\nEnter the value ");
                        value = in.next();
                        DllDemo.myDoubleLinkedLists.put(name, DllDemo.demo.insertInBegining(value, head));
                        break;
                    case 3:
                        System.out.println("\nEnter the value ");
                        value = in.next();
                        System.out.println("\nEnter the position ");
                        DllDemo.myDoubleLinkedLists.put(name,DllDemo.demo.insertAtPosition(value, in.nextInt(), head));
                        break;
                    case 4:
                        System.out.println("\nEnter the position to delete");
                        DllDemo.myDoubleLinkedLists.put(name, demo.deleteAtPosition(in.nextInt(), head));
                        break;
                    case 5:
                        DllDemo.myDoubleLinkedLists.put(name,demo.reverse_old(head));
                        break;
                    case 6:
                        System.out.println("Length of "+name+" is : "+DllDemo.demo.calcLength(head));
                        break;
                    case 7:
                        DllDemo.demo.display(head);
                        break;
                    case 8:
                        break;
                    default: System.out.println("\n Wrong Choice!");
                        break;

                }
            }while(choice!=8);

        }

    }

    private DllNode createNewList() {
        DllNode head=null;
        System.out.println("\n********* Create MENU *********");
        System.out.println("\n1. Insert Next");
        System.out.println("\n2. Back to previous menu.");
        System.out.println("\nEnter ur choice : ");
        String value;
        int choice=in.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("\nEnter the value ");
                value = in.next();
                head = DllDemo.demo.insertNext(value, head);
                break;
            case 2:
                break;
            default: System.out.println("\n Wrong Choice!");
                break;
        }
        return head;
    }

    private int calcLength(DllNode head) {
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


    public DllNode insertNext(String value, DllNode head){
        DllNode dllNode = new DllNode();
        dllNode.data= value;
        if(head == null){
            head = dllNode;
        }else{
            DllNode temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = dllNode;
            dllNode.prev =temp;
        }
        return head;
    }

    public DllNode insertInBegining(String value, DllNode head){
        DllNode dllNode = new DllNode();
        dllNode.data= value;
        if (head == null){
            head = dllNode;
        }
        else{
            DllNode temp = head;
            temp.prev = dllNode;
            dllNode.next = temp;
            head = dllNode;
        }
        return head;
    }

    public void display(DllNode head){
        DllNode temp = head;
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

    public DllNode insertAtPosition(String value, int position, DllNode head){
        int length = calcLength(head);
        if(length<position){
            System.out.println("Length of LinkedList is :"+length);
            System.out.println("The give position "+position+" is greater than linked list length press Y to insert in last of current list or N to exit?");
            Scanner in=new Scanner(System.in);
            if("Y".equalsIgnoreCase(in.next())){
                head=insert(value, position, head);
            }
        }else{
            head=insert(value, position, head);
        }
        return head;
    }

    public DllNode insert(String value, int position, DllNode head){
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
        return head;
    }
    public DllNode deleteAtPosition(int position, DllNode head){
        int length = calcLength(head);
        if(length<position){
            System.out.println("Length of LinkedList is :"+length);
            System.out.println("The give position "+position+" is greater than linked list length please enter correct position.");

        }else{
           head= delete(position, head);
        }
        return head;
    }

    public DllNode delete(int position, DllNode head ){
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
        return head;
    }

    public DllNode reverse_old(DllNode head) {

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
        return head;
    }

}

