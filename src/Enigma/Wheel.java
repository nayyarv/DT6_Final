package Enigma;
import java.util.ArrayList;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 13/04/12
 * Desc:
 */
public class Wheel {
    private static final boolean DEBUG = false;

    //wheel acts as an actual wheel - it moves everything as it moves
    private ArrayList<Letter> encryptionWheel = new ArrayList<Letter>();
    private Letter indicator;



    public Wheel(String encryption){
        int len = encryption.length();
        for(int i=0;i<len;i++){
            encryptionWheel.add(new Letter(encryption.charAt(i)));//fill my list array
        }
        indicator = new Letter('A');//as default
    }

    public void setIndicator(Letter l){
        while (!indicator.equals(l)){
            rotateOnce();
        }
    }

    public Letter getIndividualIndicator() {
        return indicator;
    }

    public void rotateOnce(){//Free rotation
        Letter temp = encryptionWheel.remove(0);
        encryptionWheel.add(temp);
        //moves wheel
        indicator.nextLetter();// change indicator

        for(Letter l : encryptionWheel){
            l.prevLetter();
        }//Since the wheel has moved, each string now corresponds to the previous letter
    }

    public void encodeOut(Letter l){//From button press towards reflector
        int index = l.charIndex();
        l.setLetter(encryptionWheel.get(index));
        if(DEBUG) {
            System.err.println(encryptionWheel.toString());
            System.err.println("Encoding out, Index was: "+index+" Input was " + (char)(index + 'A') + ", returns " + l.toString());
        }
    }

    public void encodeIn(Letter l){//From reflector to output
        int index = encryptionWheel.indexOf(l);
        assert (index!=-1);
        if(DEBUG) {
            //System.err.println(encryptionWheel.toString());
            System.err.print("Encoding In, Input was: "+ l);
        }
        l.charFromIndex(index);
        if(DEBUG) System.err.print(" returns: "+ l+'\n');
    }

    @Override
    public String toString() {
        return encryptionWheel.toString();
    }
}
