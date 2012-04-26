package Enigma;
/**
 * File Name:
 * Creator: Varun Nayyar & Welly Mulyadi
 * Date: 12/04/12
 * Desc:
 */
public class EnigmaBuilder {
    // Walzenlage: Choice and order of wheels
    // input walzenlage is three digits in range 1..8 denoting slow,med,fast rotors in that order.
    // (digits 1..8 correspond to enigma rotors I..VIII)

    public static EnigmaMachine constructM3 (String walzenlage) {
        assert (walzenlage.length()==4);

        return new EnigmaMachineMaker(walzenlage, false);  // replace this when you implement the M3
    }

    // walezenlage is four digits in range 1..8 denoting slowest,slow,med,fast rotors in
    // that order, followed by a letter in range A..C denoting the reflector type.
    public static EnigmaMachine constructM4 (String walzenlage) {
        assert (walzenlage.length()==5);
        //some very basic checking
        return new EnigmaMachineMaker(walzenlage, true);  // replace this when you implement the M4
    }

    // ringstellung is the ring settings for each of the 5 wheels (specified in the same
    // order as the wheels are given in the walzenlage).
    // Notice that the M4 is just the M4_1 with a ringstellung of "AAAAA"
    public static EnigmaMachine constructM4_1 (String walzenlage, String ringstellung) {
        //another time :P
        return null;  // replace this when you implement the M4_1
    }

}
