package Enigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 13/04/12
 * Desc:
 */
public enum ReflectorTypes {
    REFLECTORA("EJMZALYXVBWFCRQUONTSPIKHGD"),
    REFLECTORB("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
    REFLECTORC("FVPJIAOYEDRZXWGCTKUQSBNMHL");

    private final String encryption;

    ReflectorTypes(String encryption){
        this.encryption=encryption;
    }

    public String getEncryption() {
        return encryption;
    }
}
