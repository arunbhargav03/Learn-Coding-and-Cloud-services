import java.util.Scanner;

class Main {
    public static void main(String[] args ) {

        char operators;
        int num1, num2, output;

        //creation of an object for scanner class
        Scanner input = new Scanner(System.in);

        // User entering the operator
        System.out.println("Enter the operator: from these symbols +, -, /, *, %");
        operators = input.next().charAt(0);

        //user enters the First number
        System.out.println("Enter the First Number: ");
        num1 = input.nextInt();

        //user enters the second number
        System.out.println("Enter the Second Number: ");
        num2 = input.nextInt();

        switch (operators){

            //addition operation
            case '+':
                output = num1 + num2;
                System.out.println(num1 + "+" + num2 + "=" + output);
                break;

            // Subtraction Operation
            case '-':
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

        for(int i=0; i<args.length; i++ ){
            System.out.println(i);
            System.out.println(args[i]);

        }

        for (String str :args) {
            System.out.println(str);
        }

        if(num1>num2 || num1<8 ){

        }else{

        }

        while("str".equals("str")){

        }

        do{
            int o =num1 + num2;
        }while(num1<num2);

        input.close();
    }
}
