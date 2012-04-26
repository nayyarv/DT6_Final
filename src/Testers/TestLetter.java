package Testers;

import Enigma.Letter;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public class TestLetter {
    public static void main(String[] args){
        /*
        Letter john = new Letter('a');
        System.out.println(john);
        john.nextLetter();
        System.out.println("Next Letter\n"+ john);

        Letter bob = new Letter('z');
        System.out.println("\n" +bob);
        bob.nextLetter();
        System.out.println("Next Letter\n"+bob);


        Letter frank = new Letter('B');
        System.out.println("\n" +frank);
        frank.prevLetter();
        System.out.println("Prev Letter" +frank);
        frank.prevLetter();
        System.out.println("Prev Letter" +frank);


        Letter welly = new Letter('B');
        System.out.println("Dist from A of " +welly.getLetter()+": " + 3  );
        welly.nextLetter();
        System.out.println("Dist from A of " +welly.getLetter()+": " + 3);
        welly.setLetter('A');
        System.out.println("Dist from A of " +welly.getLetter()+": " +3);


         */
        Letter a = new Letter('A');
        Letter b = new Letter('b');
        Letter temp = new Letter('Z');

        String labelling = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(temp.equals(b));
        System.out.println(temp.equals(a));



        //Testing index of
        System.out.println("Index of a is: " + a.charIndex());
        System.out.println("Index of b is: " + b.charIndex());
        System.out.println("INdex of Z is: "+ temp.charIndex());


        //int index = labelling.charIndex(temp.getLetter());

       int index4 = 4;
        a.charFromIndex(index4);

        int index0 = 0;
        b.charFromIndex(index0);

        int index25 = 22;
        temp.charFromIndex(index25);

        System.out.println("Char at index4: "+ a );
        System.out.println("Char at index0: "+ b );
        System.out.println("Char at index22: "+ temp );









    }


}
