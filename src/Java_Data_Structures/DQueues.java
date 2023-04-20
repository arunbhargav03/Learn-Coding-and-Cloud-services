package Java_Data_Structures;

import java.util.Scanner;

public class DQueues {

    int front;
    int rear;
    int[] arr;

    DQueues(int size)
    {
        front=rear=-1;
        arr=new int[size];
    }

    void enqueue(int a)
    {
        if(rear==arr.length-1)
            System.out.println("overflow");
        else
            arr[++rear]=a;

        if(front==-1)
            front++;
    }

    int dequeue()
    {
        int x=-1;
        if(front==-1)
            System.out.println("underflow");
        else
            x=arr[front++];
        if(rear==0)
            rear--;
        return x;
    }

    void peekFirst() {
        System.out.println("First element in Array : "+arr[front]);
    }

    void peekLast() {
        System.out.println("Last element in Array : "+arr[rear]);
    }

    void display()
    {
        int count = 0;
        for(int i=front;i<=rear;i++) {
        count += 1;
            System.out.print(arr[i] + " ");
        }
        if (count == 0)
            System.out.println("Queue is empty");


        System.out.println();


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size Queue: ");
        int size = sc.nextInt();

        DQueues dQueue = new DQueues(size);

        System.out.println("Queue operations:");
        System.out.println("1. enqueue");
        System.out.println("2. dequeue");
        System.out.println("3. peekFirst");
        System.out.println("4. peekLast");
        System.out.println("5. Display All Elements");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("Enter operation number (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    dQueue.enqueue(value);
                    break;

                case 2:
                    int popped = dQueue.dequeue();
                    if (popped != -1) {
                        System.out.println("Popped element: " + popped);
                    }
                    break;

                case 3:
                    dQueue.peekFirst();
                    break;
                case 4:
                    dQueue.peekLast();
                    break;
                case 5:
                    dQueue.display();
                    break;
                case 6 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid number");
                    break;


            }
            System.out.println();
        }
    }
}