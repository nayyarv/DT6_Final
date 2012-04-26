package Testers;

import Enigma.*;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 14/04/12
 * Desc:
 */
public class TestM3 {

    public static void main(String[] args){

        {
             EnigmaMachineMaker test = new EnigmaMachineMaker("123B",false);
            System.out.println("Num Settable wheels: "+test.numberOfSettableWheels());


            //System.out.println("Indicator is: "+test.getCurrentIndicators());
              //test.testing();
            String code = test.encipher("AAAA");

            System.out.println("Enciphered AAAA: "+code);
             //System.out.println(test.getCurrentIndicators());

             code = test.encipher("AAAA");



            System.out.println("Current indicators: "+test.getCurrentIndicators());

            test.setIndicators("AAA");

            System.out.println("Ressetting indicators\nCurrent indicators: "+test.getCurrentIndicators());
            code = test.encipher("AAAA");

            System.out.println("Enciphered AAAA: "+code);

            System.out.println("Current indicators: "+test.getCurrentIndicators());
        }

        {
            {
                System.out.println ("longer test...");
                // test from http://enigmaco.de/enigma/enigma.html
                EnigmaMachine m3 = new EnigmaMachineMaker ("123B", false);

                String plainText  = "WHEREEVERYOUGOTHEREYOUAREWHEREEVERYOUGOTHEREYOUAREWHEREEVERYOUGOTHEREYOUAREWHEREEVERYOUGOTHEREYOUAREWHEREEVERYOUGOTHEREYOUAREWHEREEVERYOUGOTHEREYOUARE";
                String cipherText = "KPCURNSYDGLDHCUGTOOMLAQGCDQKHOUMRBNBFXDEKUIKBCJHKVPEGLYXBTKFFATZEYYLTNFQGLDSQXOYKUHSGPLVNJTWCZXXKEFBBZGHPLHKVGIFBPLRSVSQYOIXTNEGPMNPBGVDXYHMUNUUDYYLZX";

                //m3.setIndicators ("AAA");

                String ans = m3.encipher(plainText);


                //System.out.println(ans);
                System.out.println("Correct encode?: "+ans.equalsIgnoreCase(cipherText));
                assert (ans.equals (cipherText));
            }

        }




        {
            EnigmaMachine m3 = new EnigmaMachineMaker("451B",false);

        String cipherText = "BTNJJFJGELCFIPFTLANTCABHGKDFCJWYMPKTFRLWOIQHLBXZCYSBFTIJREAJWHHWQUVLIEVYBANINWFKQYMYRELWPHEYWNSOZCRKIFNDGCNGDQLVTQEWHITLYCNLGCLTJGDLPPWXMTZHNYSLNYMGVOWJQMYEOJAIXYINDUWFGEEIQGXRXKYFMQNLCTQVJEFVGPKUNOXMTMKNJQGGIIKAJZIEHUPVVGZVTNCMSQSWMATLOORQDOXASDTCFBSQDQJPXUCUWTVJEYPNDMGUBBLSRXBINNVOUZZGZRFSCATQWKMCVRBYLEHGVPFXIINZRLMNOWFONLDUGPPQNVNQFTYPIEOCMCXFFQWHNKYTWHFBOFZGQQBYSPNWWSHGULJYFZYBHJAPOQREBQIONTDFFGRWLHHAOLMEJBBZSPXTKDNQYDRFKTGIDVZKPLJZUDELBWQGTURXWJJHCJYXVEMXIQZNAPPDLQKEEBDTGYVBNCNUFKWYFFNETMZLJRBASQTTSTQJTTYQFBLXSGOJXRIXAFCYXMCPBMZQNHHRQTOWIYAMVUGVJGMIGVEWJOTAYXGOLQQCRCQOYCMGZMSSLCLEBMSBIAJKYBLCHCDPYGLPLCKGXTXMKIAKXQWFHYLCGBFGYTQWIKSKOHYHPBJRYBJYAIFGAMGYEMLYOQZONCGXDQSZZIHPQFYXYRTOFOCUVAVEOPXLJUZUXTJUWWDMRDZZAHGTTLNAYCSLVLOFRYYZEDBNPRCIHBYTNVBWYQKJQMEMBJSTLXRDQQFXQBTDMQURKFPYSFQRXIWBZUEALOKHWKCFACIIDVMJVZEZECZYPGNTFZBYMFBEWOPLKKLPZQXGCDIMPMBSVDIUDRRJRBMODKYKHVBOYLMYHOVEMBTVIALAAEFFIAXTHVCMLOFWPVVILTXTAMCSLEBMPDMZMPSPNZVVYFMIXQAPKXRTLVFVUBQULGNJYTXXUWZZOORJQXMMRTSUVJJKYUCKFIXOTOPTQZQQXSYMUBSCHGGELPFZNQSZOYZSLQKWP";
        String plainText = "OURFORMOFGOVERNMENTDOESNOTENTERINTORIVALRYWITHTHEINSTITUTIONSOFOTHERSOURGOVERNMENTDOESNOTCOPYOURNEIGHBORSBUTISANEXAMPLETOTHEMITISTRUETHATWEARECALLEDADEMOCRACYFORTHEADMINISTRATIONISINTHEHANDSOFTHEMANYANDNOTOFTHEFEWBUTWHILETHEREEXISTSEQUALJUSTICETOALLANDALIKEINTHEIRPRIVATEDISPUTESTHECLAIMOFEXCELLENCEISALSORECOGNIZEDANDWHENACITIZENISINANYWAYDISTINGUISHEDHEISPREFERREDTOTHEPUBLICSERVICENOTASAMATTEROFPRIVILEGEBUTASTHEREWARDOFMERITNEITHERISPOVERTYANOBSTACLEBUTAMANMAYBENEFITHISCOUNTRYWHATEVERTHEOBSCURITYOFHISCONDITIONTHEREISNOEXCLUSIVENESSINOURPUBLICLIFEANDINOURPRIVATEBUSINESSWEARENOTSUSPICIOUSOFONEANOTHERNORANGRYWITHOURNEIGHBORIFHEDOESWHATHELIKESWEDONOTPUTONSOURLOOKSATHIMWHICHTHOUGHHARMLESSARENOTPLEASANTWHILEWEARETHUSUNCONSTRAINEDINOURPRIVATEBUSINESSASPIRITOFREVERENCEPERVADESOURPUBLICACTSWEAREPREVENTEDFROMDOINGWRONGBYRESPECTFORTHEAUTHORITIESANDFORTHELAWSHAVINGAPARTICULARREGARDTOTHOSEWHICHAREORDAINEDFORTHEPROTECTIONOFTHEINJUREDASWELLASTHOSEUNWRITTENLAWSWHICHBRINGUPONTHETRANSGRESSOROFTHEMTHEREPROBATIONOFTHEGENERALSENTIMENT";

        m3.setIndicators ("IYP");


        String answer = m3.encipher(plainText);
            System.out.println("Indicators: " + m3.getCurrentIndicators());
        System.out.println(answer);
            System.out.println("Current indicators: " +m3.getCurrentIndicators());
        System.out.println(answer.equalsIgnoreCase(cipherText));


        }






        //test.testFunction();

        System.out.println("M3 tests passed. You are Awesome!");
    }

}
