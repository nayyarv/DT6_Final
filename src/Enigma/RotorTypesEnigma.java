package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public enum RotorTypesEnigma {
    ROTOR1 ("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"),
    ROTOR2 ("AJDKSIRUXBLHWTMCQGZNPYFVOE","E"),
    ROTOR3 ("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"),
    ROTOR4 ("ESOVPZJAYQUIRHXLNFTGKDCMWB", "J"),
    ROTOR5 ("VZBRGITYUPSDNHLXAWMJQOFECK", "Z"),
    ROTOR6 ("JPGVOUMFYQBENHZRDKASXLICTW", "ZM"),
    ROTOR7 ("NZJHGRCXMYSWBOUFAIVLPEKQDT", "ZM"),
    ROTOR8 ("FKQHTLXOCBJSPDZRAMEWNIUYGV", "ZM");


    private final String encryption;
    private final String notch;

    RotorTypesEnigma(String encryption, String notch){
        this.encryption = encryption;
        this.notch = notch;
    }

    public String getNotch() {
        return notch;
    }

    public String getEncryption() {
        return encryption;
    }
}
