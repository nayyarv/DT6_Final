package Enigma;
/**
 * File Name:
 * Creator: Varun Nayyar & Welly Mulyadi
 * Date: 12/04/12
 * Desc:
 */
public interface EnigmaMachine {

    /**
     * returns the number of rotors+reflectors in the machine whose position can be set
     * by the operator.  for example for the m3 this will be 3, for the m4 it will be 5.
     * this will be the length of the string returned by the set/get indicator methods.
     */
    int numberOfSettableWheels();

    /**
     *  set the orientation of the rotors (and settable reflectors) to the specified
     *  characters.  the characters correspond to the rotors (and settable reflector)
     *  in the same order as the walzenlage string.
     *  for any valid setting:
     *    m.getCurrentIndicators(m.setIndicators(setting)).equals(setting)
     */
    void setIndicators (String setting);

    /**
     *  refers to the current orientation of the rotors (and settable reflectors)
     *  ie what are the letters you can currently read thru the windows?
     *  the output characters should be in the same order as the walzenlage string
     */
    String getCurrentIndicators ();

    String encipher (String plainText);
}
