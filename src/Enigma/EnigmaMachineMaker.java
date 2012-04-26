package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 16/04/12
 * Desc:
 */
public class EnigmaMachineMaker implements EnigmaMachine{
    private final static boolean DEBUG = false;

    private EnigmaComponent firstRotor;
    private boolean moveableReflector;

    //This class mostly modifies strings for input and output - rotors do most of the work

    public EnigmaMachineMaker(String walzenlage, boolean moveableReflector){
        this.moveableReflector=moveableReflector;
        firstRotor = new EnigmaRotor(convertForUse(walzenlage),moveableReflector);
    }

    @Override
    public void setIndicators (String setting){
        String converted;
        if (moveableReflector){
            converted=convertForUse(setting);
            //Since I need a string which starts with fast, med, slow, reflector
        } else{
            if (DEBUG) System.err.println("Setting a 3 rotor enigma");
            converted = reverse(setting);
        }
        if(DEBUG)System.err.println("Setting in: "+setting+" Reversed: "+converted);
        firstRotor.setIndicator(converted);
    }

    @Override
    public String getCurrentIndicators (){
        String ind = firstRotor.getAllIndicators();
        if(moveableReflector){
            return ind.substring(1, ind.length())+ind.charAt(0);
        } else {
            return ind;
        }
    }

    @Override
    public String encipher (String plainText){
        int len = plainText.length();
        StringBuilder encrypted = new StringBuilder();
        Letter letter = new Letter('A');
        for(int i=0; i<len; i++){
            letter.setLetter(plainText.charAt(i));
            //if (DEBUG) System.err.println(letter);
            //do stuff from fast i.e. first wheel
            firstRotor.rotate();
            firstRotor.encrypt(letter);
            //if (DEBUG) System.err.println(letter);
            encrypted.append(letter.getLetter());
        }
        return encrypted.toString();
    }

    @Override
    public int numberOfSettableWheels(){
        return firstRotor.numWheelsSettable();
    }

    //Due to implementation - rotor takes care of a lot,
    //I just send it a string, and it does the rest, since only it knows the
    // next component.

    private String convertForUse(String string){
        //converts to form (fast,medium1, (medium2), slow, reflector - which is what i need)
        int len = string.length();
        String temp = string.substring(0, len-1);
        //if(DEBUG) System.err.println("String: "+string+" Temp: "+temp);
        temp = reverse(temp);
        //if(DEBUG) System.err.println("Fixed String: "+temp+string.charAt(len-1));

        return temp+string.charAt(len-1);
    }

    private String reverse(String string){
        StringBuilder forReverse = new StringBuilder(string);
        forReverse.reverse();
        return forReverse.toString();
    }

}
