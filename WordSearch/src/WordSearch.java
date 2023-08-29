package WordSearch.src;
import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] m;

    private String horiString;
    private String vertString = "";

    public WordSearch(int size, String str) {
        m = new char[str.length() / size][size];
        horiString = str;
        for (int i = 0; i < str.length() / size * size; i++) {
            m[i / size][i % size] = str.charAt(i);
        }
        for (int k = 0; k < m.length / size * size; k++) {
            for (int p = 0; p < m.length; p++) {
                vertString += m[p][k];
            }
        }
        System.out.println("vert " + vertString);
    }

    public boolean isFound(String word) {
        if (  checkVertical(word) || checkHorizontal(word) || checkDiagRightUp(word) || checkDiagRightDown(word) || checkDiagLeftDown(word) || checkDiagLeftUp(word)) {
            return true;
        }
        return false;
    }

    public boolean checkHorizontal(String w) {
        StringBuilder reverse = new StringBuilder();
        reverse.append(horiString);
        reverse.reverse();
        boolean forward=false, backward=false;

        if (horiString.indexOf(w) == -1 && horiString.lastIndexOf(w) == -1) {
            forward = false;
        }  else if ((horiString.indexOf(w) / 8 == horiString.lastIndexOf(w) / 8)) {
            forward = true;
        }
          if ((reverse.indexOf(w) == -1 && reverse.lastIndexOf(w) == -1) ) {
            backward = false;
        } else if ((horiString.indexOf(w) / 8 == horiString.lastIndexOf(w) / 8)){
            backward = true;
        }
        return forward || backward;

    }

    public boolean checkVertical(String w) {
        StringBuilder reverse = new StringBuilder();
        reverse.append(vertString);
        reverse.reverse();
        boolean forward=false, backward=false;

        if (vertString.indexOf(w) == -1 && vertString.lastIndexOf(w) == -1) {
            forward = false;
        }  else if ((vertString.indexOf(w) / 8 == vertString.lastIndexOf(w) / 8)) {
            forward = true;
        }
          if ((reverse.indexOf(w) == -1 && reverse.lastIndexOf(w) == -1) ) {
            backward = false;
        } else if ((reverse.indexOf(w) / 8 == reverse.lastIndexOf(w) / 8)){
            backward = true;
        }
        return forward || backward;


    }

    public boolean checkDiagRightDown(String w) {
        int currentIndex = horiString.indexOf(w.charAt(0));
        int i = 0;
        while (true) {
            for (i = 1; i < w.length(); i++) {
                int nextIndex = currentIndex + 9;

                if (nextIndex > horiString.length()) {
                    return false;
                }

                if (horiString.charAt(nextIndex) == w.charAt(i)) {
                    continue;
                } else {
                    currentIndex = horiString.indexOf(w.charAt(0), currentIndex+1);
                    if (currentIndex == -1 || currentIndex > horiString.length()) {
                        return false;
                    }

                    break;
                } 
            

            }
            if (i == w.length()) {
                return true;
            }
        }
    }

    public boolean checkDiagRightUp(String w) {
        int currentIndex = horiString.indexOf(w.charAt(0));
        int i = 0;
        while (true) {
            for (i = 1; i < w.length(); i++) {
                int nextIndex = currentIndex - 6;

                if (nextIndex > horiString.length() ||  nextIndex < 0) {
                    return false;
                }

                if (horiString.charAt(nextIndex) == w.charAt(i)) {
                    continue;
                } else {
                    currentIndex = horiString.indexOf(w.charAt(0), currentIndex+1);
                    if (currentIndex == -1 || currentIndex > horiString.length()) {
                        return false;
                    }

                    break;
                } 
            

            }
            if (i == w.length()) {
                return true;
            }
        }
    }

    public boolean checkDiagLeftDown(String w) {
        int currentIndex = horiString.indexOf(w.charAt(0));
        int i = 0;
        while (true) {
            for (i = 1; i < w.length(); i++) {
                int nextIndex = currentIndex + 7;

                if (nextIndex > horiString.length()) {
                    return false;
                }

                if (horiString.charAt(nextIndex) == w.charAt(i)) {
                    continue;
                } else {
                    currentIndex = horiString.indexOf(w.charAt(0), currentIndex+1);
                    if (currentIndex == -1 || currentIndex > horiString.length()) {
                        return false;
                    }

                    break;
                } 
            

            }
            if (i == w.length()) {
                return true;
            }
        }
    }

    public boolean checkDiagLeftUp(String w) {
        int currentIndex = horiString.indexOf(w.charAt(0));
        int i = 0;
        while (true) {
            for (i = 1; i < w.length(); i++) {
                int nextIndex = currentIndex - 9;

                if (nextIndex > horiString.length() || nextIndex < 0) {
                    return false;
                }

                if (horiString.charAt(nextIndex) == w.charAt(i)) {
                    continue;
                } else {
                    currentIndex = horiString.indexOf(w.charAt(0), currentIndex+1);
                    if (currentIndex == -1 || currentIndex > horiString.length()) {
                        return false;
                    }

                    break;
                } 
            

            }
            if (i == w.length()) {
                return true;
            }
        }
    }


    public String toString() {
        String str = "";
        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {
                str += m[i][k] + " ";
            }
            str += "\n";
        }
        return str;
    }
}
