import java.util.Scanner;

class Main {
    public static void main(String[] args ) {

        char operators;
        Double num1, num2, output;

        //creation of an object for scanner class
        Scanner input = new Scanner(System.in);

        // User entering the operator
        System.out.println("Enter the operator: ");
        operators = input.next().charAt(0);

        //user enters the First number
        System.out.println("Enter the First Number: ");
        num1 = input.nextDouble();

        //user enters the second number
        System.out.println("Enter the Second Number: ");
        num2 = input.nextDouble();

        switch (operators){

            //addition operation
            case '+':
                output = num1 + num2;
                System.out.println(num1 + "+" + num2 + "=" + output);
                break;

            // Subtraction Operation
            case '_':
                output = num1 - num2;
                System.out.println(num1 + "-" + num2 + "=" + output);
                break;

            //Multiplication Operation
            case '*':
                output = num1 * num2;
                System.out.println(num1 + "*" + num2 + "=" + output);
                break;

             //Division Operation
            case '/':
                output = num1 / num2;
                System.out.println(num1 + "/" + num2 + "=" + output);
                break;

            default:
                System.out.println( "Invalid Operator!");
                break;
        }

        input.close();
    }
}
