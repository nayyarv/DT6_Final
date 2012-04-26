package Testers;
import Enigma.*;


/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 13/04/12
 * Desc:
 */
public class TestWheel {

    public static void main(String[] args){
        Wheel funny = new Wheel(RotorTypesEnigma.ROTOR1.getEncryption());
        System.out.println(funny);

       // System.out.println(funny.getIndividualIndicator().equals('A'));


        Letter C = new Letter('A');
        funny.encodeOut(C);
        System.out.println(C);

        funny.rotateOnce();

        System.out.println("Rotating\n"+funny);

        funny.encodeOut(C);
        System.out.println(C);

        Letter A = new Letter('A');
        funny.setIndicator(A);
        System.out.println("Resetting\n" + funny);
        C.setLetter('E');
        funny.encodeIn(C);

        System.out.println(C);




        //funny.rotateOnce();
        //System.out.println("Rotating\n"+funny);


    }
}
