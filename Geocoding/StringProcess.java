package Geocoding;

/**
 * Created by 1234 on 3/17/2017.
 */
public class StringProcess {

    //String str;
    String words[];
    public StringProcess() {
    }

    public String[] getStr(String str) {



        str = str.replaceAll(",", " ");
        str = str.replaceAll("\\.", " ");

        str = str.replaceAll(" обл ", " ");


        str = str.replaceAll(" р-н ", " ");
        str = str.replaceAll(" г ", " ");

        str = str.replaceAll(" ул ", " ");





        str = str.replaceAll("№", " ");
        str = str.replaceAll("/", " ");




        for(int i=0; i<4; i++) {
            str = str.replaceAll("  ", " ");
        }

        words = str.split(" ");

        return words;
    }
}
