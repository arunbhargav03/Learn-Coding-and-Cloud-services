package Java_Data_Structures;

import java.util.Scanner;


public class DStack {
    int [] arr;
    int top;
    int size;
    public DStack(int size){
        arr = new int[size];
        top = -1;
        this.size = size;
    }
    void push(int x) {
        if (top >= size - 1){
        System.out.println("overflow");}
        else {
        arr[++top] = x;}
       }
    int pop(){
        if (top < 0){
            System.out.println("underflow");
        return-1;}
        else{
            return arr [top--];
        }
        }
    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return arr[top];
        }

            }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size stack: ");
        int size = sc.nextInt();

        DStack stack = new DStack(size);

        System.out.println("Stack operations:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        while (true) {
            System.out.print("Enter operation number (1-3): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped element: " + popped);
                    }
                    break;

                case 3:
                    int peeked = stack.peek();
                    if (peeked != -1) {
                        System.out.println("Top element: " + peeked);
                    }
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("invalid number");
                    break;


            }
            System.out.println();
        }
    }
}