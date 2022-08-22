package FilmQuess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {

        static List<String> films = new ArrayList<>(Arrays.asList("JOKER",
                "INCEPTION","GREENMILE","THOR","LEON","GODFATHER"));
        static Scanner scan = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("---Welcome to the FilmQuess Game---");
            System.out.println("Please choose a film over index number.");
            System.out.println("Index numbers are 0-"+(films.size()-1));

            int numbersOfIndex=0;
            int numberOfQuess= 0;
            try {
                numbersOfIndex=scan.nextInt();
                numberOfQuess = selectedFilmWordNumber(films.get(numbersOfIndex),numbersOfIndex);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please use valid index 0- "+(films.size()-1));
                numbersOfIndex=scan.nextInt();
                numberOfQuess = selectedFilmWordNumber(films.get(numbersOfIndex),numbersOfIndex);
            }

            System.out.println("This movie has " + (numberOfQuess/2) + " letter");
            System.out.println("You have " + numberOfQuess + " chance to find movie.");

            boolean isQuessRight=false;
            int falseCount=1;


            System.out.println("Please pick carefully!");
            String filmQuess= scan.next().toUpperCase();

            while (!isQuessRight){
                if (!(films.get(numbersOfIndex).equals(filmQuess))){
                    System.out.println("Please try again!");
                    System.out.println("You have "+ (numberOfQuess-(falseCount)) +" chance.");
                    filmQuess= scan.next().toUpperCase();
                    falseCount++;
                } else  {
                    System.out.println("Congratulations! You win.");
                    isQuessRight=true;
                }
                if(falseCount==numberOfQuess){
                    System.out.println("Unfortanetly,You lose.");
                    System.out.println("The film is :" + films.get(numberOfQuess));
                    isQuessRight=true;
                }


            }

        }
        public static int selectedFilmWordNumber(String str,int x){
            //We are giving to player 10 chance to find correct movie with this method.
            return str.length()*2;
        }

}
