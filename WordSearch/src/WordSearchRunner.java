package WordSearch.src;
import java.util.*;

import java.io.*;

public class WordSearchRunner {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();


        WordSearch ms = new WordSearch(8, "APPLEXYPXLHJKEEDEGGLLXXCGFPDGOGNMYNTAHUUPUQDGBTSBTHIGHMSILKXLTHI");

        String[] words = "APPLE AXE APEX CAT HEX EGG HAT COMPUTER GUM THIS TUG THIGH".split(" ");

        System.out.println(ms.toString());

        for (String s : words) {

            if (ms.isFound(s)) {

                System.out.println(s + " was found in the matrix.");

            } else {

                System.out.println(s + " was not found in the matrix.");

            }

        }
        long endTime   = System.nanoTime();
long totalTime = endTime - startTime;
System.out.println(totalTime);


    }

}
