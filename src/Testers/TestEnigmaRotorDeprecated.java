package Testers;
import Deprecated.*;
import Enigma.Letter;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public class TestEnigmaRotorDeprecated {
    public static void main(String[] args){
        String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         final String rotorWiring ="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        EnigmaRotorDeprecated john = new RotorDeprecatedI();
        Letter fun = new Letter('A');
        Letter counter = new Letter('A');



        for (int i = 0; i<26;i++){
            john.encode(fun, true);
            System.out.print(fun.getLetter());
            counter.nextLetter();
            fun.setLetter(counter);
        }


        System.out.println("\nExpected: "+temp);
        System.out.println("\n"+john.getRotorWiring());





    }

}
