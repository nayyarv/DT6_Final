package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public interface EnigmaComponent {

    public void encrypt(Letter l);
    //Encrypts an individual letter via the wiring in the rotor/reflector

    public void rotate();
    //Rotates the component

    public String getAllIndicators();
    //Gets indicator (if it has one)

    public int numWheelsSettable();
    //Works out number of settable wheels

    public void setIndicator(String string);
    //Sets the indicator section

    public void checkDoubleStep();
    //The wheel has not been rotated this turn

}
