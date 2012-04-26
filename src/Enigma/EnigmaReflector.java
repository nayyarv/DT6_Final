package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 14/04/12
 * Desc:
 */
public class EnigmaReflector implements EnigmaComponent {
    private Wheel encryption;
    public final boolean moveable;

    //Essentially, these act as terminator functions - they will be called,
    // but they don't need to do much.

    public EnigmaReflector(char reflectorVal,boolean moveable){
        this.moveable = moveable;
        String reflectorRequest = "REFLECTOR"+reflectorVal;
        ReflectorTypes newReflector = ReflectorTypes.valueOf(reflectorRequest);
        encryption = new Wheel(newReflector.getEncryption());
    }

    public void rotate(){
        //simply rotates the wheel once if moveable,
        // it will be called from the slowest rotor.
        if(moveable){
            encryption.rotateOnce();
        } //no need for any other checking
    }

    public String getAllIndicators(){
        if (moveable){
            return encryption.getIndividualIndicator().toString();
        } else {
            return "";
        }

    }

    public void setIndicator(String string){
        if(moveable){
            Letter l = new Letter(string.charAt(0));
            encryption.setIndicator(l);
        }
    }

    public void encrypt(Letter l){
        encryption.encodeIn(l);//Only needed
    }

    public void checkDoubleStep(){} //No doublestepping to check on the reflector anyway
    //This serves the purpose of terminating the function calls

    @Override
    public int numWheelsSettable(){

        if(moveable){
            return 1;
        } else {
            return 0;
        }
        //return moveable? 1:0; //Muhahahaha
    }

    @Override
    public String toString() {
        return "EnigmaReflector{" +
                "encryption=" + encryption +
                ", moveable=" + moveable +
                '}';
    }

}
