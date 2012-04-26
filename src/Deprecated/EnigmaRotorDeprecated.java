package Deprecated;


import Enigma.Letter;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */

public abstract class EnigmaRotorDeprecated {
    //#defines
    private static final boolean DEBUG = false;
    private static final String labelling = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //fields
    private String rotorWiring;
    private String notch; //since it could have multiple notches.
    private Letter position = new Letter('A'); //As default

    public EnigmaRotorDeprecated(String rotorWiring, String notch){
        this.rotorWiring = rotorWiring;
        this.notch = notch;
    }

    //private
    private void wiringEncoder(Letter letter, String from, String to){
        int index = from.indexOf(letter.getLetter());
        letter.setLetter(to.charAt(index));
        //Models the internal wiring

    }

    public void encode (Letter toEncode, boolean directionOut){//out
        //We create a imaginary wheel that doesnt move inside
        // And we are encoding through this imaginary wheel
        //Allows for easy encoding

        String from = labelling;
        String to = rotorWiring;
        if(!directionOut){
            from = rotorWiring;
            to = labelling;
        } //allows to encode from left to right or right to left

        int dist = 3;

        if(DEBUG)System.err.println(dist+" "+ toEncode);

        //toEncode.increaseLetterBy(dist);

        if(DEBUG)System.err.println(toEncode);

        // This ensures the output from prev wheel goes into the right wheel input

        wiringEncoder(toEncode, from,to);

        //toEncode.decreaseLetterBy(dist);

        //Send to next rotor!!
    }


    //for now public
    public void move(){


    }

    public String getRotorWiring() {
        return rotorWiring;
    }


    public String getNotch() {
        return notch;
    }

    public char getPosition() {
        return position.getLetter();
    }

    public void setPosition(char position) {
        this.position.setLetter(position);
    }


}
