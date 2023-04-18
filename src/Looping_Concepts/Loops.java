package Looping_Concepts;


import java.util.Scanner;

class Loops {
    public static void main(String[] args) {

        int x,y,z,k;
        char movie;


        //creation of an object for scanner class
        Scanner input = new Scanner(System.in);

        //creation switch case inputs
        System.out.println(" Select the any character to win the movie tickets (a to z): ");
        movie = input.next().charAt(0);

        //user enters the number
        System.out.println("Enter the Number: ");
        x = input.nextInt();

        //if else statement
        if (x >= 10){
            System.out.println("x is greater than the 10: " + x);
        } else{
            System.out.println("x is less than 10: "+ x);
        }

        //Simple if statement
        if (x <= 10){
            System.out.println(" Enter the second number: ");
            y = input.nextInt();

            //performing operation
            z =x+y;
            System.out.println(x + "+" + y + "=" + z);
        }

        //while Loop
        while (x >= 12){
            System.out.println("The value of x: "+x);
            x++;
        }

        //Do-while loop
        do{
            System.out.println("The value of x: "+x);
            x--;
        } while (x >= 10);

        //for loop execution
        for(x=x; x<=10; x++){
            System.out.println("The value of x is: "+x);
        }

        //for each loop execution
        for(k=0; k< args.length;k++){
            System.out.println(args[k]);
        }


        //Switch case execution
        switch (movie){

            case 'a':
                System.out.println("Thriller");
                break;

            case 'b':
                System.out.println("Crime");
                break;

            case 'c':
                System.out.println("Horror");
                break;

            case 'd':
                System.out.println("Comedy");
                break;

            case 'e':
                System.out.println("Love/Romantic");
                break;

            default:
                System.out.println("You haven't won any Movie tickets: Better Luck Next time");
                break;

        }
        input.close();
    }
}