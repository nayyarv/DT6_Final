package Testers;

import Enigma.RotorTypesEnigma;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 12/04/12
 * Desc:
 */
public class TestRotorTypes {

    public static void main(String[] args){
        //System.out.println(RotorTypesEnigma.ROTOR3.ordinal());
        for(RotorTypesEnigma rotorTypes: RotorTypesEnigma.values()){
            //System.out.println(rotorTypes);
        }

        char rotor = '1';

        StringBuffer rotorRequest = new StringBuffer();
        rotorRequest.append("ROTOR" + rotor);
        System.out.println(rotorRequest);

        RotorTypesEnigma rotorTypes = RotorTypesEnigma.valueOf(rotorRequest.toString());

        System.out.println(rotorTypes.getEncryption() + " " + rotorTypes.getNotch());


    }
}
