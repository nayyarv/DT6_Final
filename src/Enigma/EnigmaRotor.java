package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public class EnigmaRotor implements EnigmaComponent {
    private final static boolean DEBUG = false;
    private final static boolean DEBUGCONSTRUCTOR = false;

    private Wheel rotorWiring; //Wheel takes care of encoding, free rotation and alignment
    private String notch; //Stores the notch location(s)

    private EnigmaComponent nextComponent;  //slower component (to the right)


    @Deprecated
    public EnigmaRotor(char rotorValue){
        create(rotorValue);
    }

    @Deprecated
    public void connect(EnigmaComponent next){
        nextComponent=next;
    }


    public EnigmaRotor(String partWalzenlage, boolean reflectorMoveable){
        //we create a rotor that creates the next rotor on the line

        if(DEBUGCONSTRUCTOR) System.err.println(partWalzenlage);
        create(partWalzenlage.charAt(0));
        char nextChar = partWalzenlage.charAt(1);
        if(DEBUGCONSTRUCTOR) System.err.println("Next char: " + nextChar);
        if(Character.isDigit(nextChar)){
            //if digit create a rotor
            if(DEBUGCONSTRUCTOR) {
                System.out.println("Creating rotor with setting: "+ nextChar);

            }
            nextComponent = new EnigmaRotor(partWalzenlage.substring(1), reflectorMoveable);

        } else if (Character.isLetter(nextChar)){ //end of the string - we make a reflector now
            //Create reflector
            if(DEBUGCONSTRUCTOR) System.out.println("Creating reflector with setting: "+ nextChar +
                    " and moveable: "+reflectorMoveable);
            nextComponent = new EnigmaReflector(nextChar, reflectorMoveable);


        } else {
            System.err.println("We have a problem - incorrect input");
        }

    }

    public void create(char rotorValue){//for my spare constructor
        String rotorRequest = "ROTOR"+rotorValue;
        RotorTypesEnigma newRotor = RotorTypesEnigma.valueOf(rotorRequest);
        //using enums :)
        rotorWiring = new Wheel(newRotor.getEncryption());
        notch = newRotor.getNotch();
    }

    public void encrypt(Letter letter){

        assert (nextComponent !=null);
        if(DEBUG) System.out.print(" Letter encoded out: " + letter);

        rotorWiring.encodeOut(letter); //encode on the way out
        if(DEBUG) System.out.println(" becomes : "+letter);
        nextComponent.encrypt(letter); //give to next rotor
        //letter will be modified - means i don't need left and right pointers
        if(DEBUG) System.out.print(" Letter encoded in: " + letter);
        rotorWiring.encodeIn(letter);//encode on the way back
        if(DEBUG) System.out.println(" becomes: "+letter);

    }

    public void rotate(){
        if(atNotch()){
            nextComponent.rotate();
            //Simple turn at notch
        } else {
            //might be set weirdly - check double stepping
            nextComponent.checkDoubleStep();
        }
        rotorWiring.rotateOnce();//turn the current rotor :)
    }

    public void checkDoubleStep(){
        if(this.getClass()!= nextComponent.getClass()){
            //i.e next component is not rotor
            //i.e next component is reflector
            //i.e. we are at the last rotor
            if(nextComponent.numWheelsSettable()==1){
                //i.e. it's a moveable reflector - double stepping will still apply
                if(atNotch()){
                    nextComponent.rotate();
                    rotorWiring.rotateOnce();
                }
                //System.err.println("We have a moving reflector next!!");
            }

        } else if(atNotch()){
            //then next component will move and take me along with it
            //does not apply if last component
            nextComponent.rotate(); //rotate next wheel
            rotorWiring.rotateOnce();//rotate current wheel
        } else {
            nextComponent.checkDoubleStep(); //go through to check more doublestepping
        }
    }

    private boolean atNotch(){
        return notch.contains(rotorWiring.getIndividualIndicator().toString());
        //is the wheel at the notch?
        //Uses a simple string search
    }

    public String getAllIndicators(){
        return nextComponent.getAllIndicators() + rotorWiring.getIndividualIndicator().toString();
    }

    public void setIndicator(String string){
        Letter l = new Letter(string.charAt(0));
        rotorWiring.setIndicator(l);
        nextComponent.setIndicator(string.substring(1));
    }

    @Override
    public int numWheelsSettable(){
        return (1+nextComponent.numWheelsSettable());
    } //nice and recursive

    @Override
    public String toString() {
        return "EnigmaRotor {" +
                "rotorWiring='" + rotorWiring + '\'' +
                ", notch='" + notch + '\'' +
                //", position=" + position +
                '}';
    }

}
