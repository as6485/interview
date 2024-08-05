package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;

        System.out.println(fullJustify(words, maxWidth));
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        StringBuilder paddedLine = new StringBuilder();
        int width = 0;
        boolean lastLine = false;

        for(int i = 0; i< words.length; i++){
            String word = words[i];
            width+=word.length()+1;
            if(width <= maxWidth+1){
                line.add(word);
                ////prepare paddedLine and add to result if last word fits within maxWidth
                if(i == words.length-1){
                    lastLine = true;
                    paddedLine = preparePaddedLine(line, maxWidth, lastLine);
                    result.add(paddedLine.toString());
                }
            }
            else{
                //prepare paddedLine and add to result
                paddedLine = preparePaddedLine(line, maxWidth, lastLine);
                result.add(paddedLine.toString());

                //reset
                width = word.length()+1;
                line.clear();
                line.add(word);
                paddedLine = new StringBuilder();

                //prepare paddedLine and add to result if last word doesn't fit within maxWidth
                if(i == words.length-1){
                    lastLine = true;
                    paddedLine = preparePaddedLine(line, maxWidth, lastLine);
                    result.add(paddedLine.toString());
                }
            }
        }

        return result;
    }

    private static StringBuilder preparePaddedLine(List<String> line, int maxWidth, boolean lastLine) {
        StringBuilder paddedLine = new StringBuilder();
        int sum = 0;
        int j = 0;
        int nbrOfSpaces = 0;
        for (String word : line) {
            sum += word.length();
        }

        nbrOfSpaces = maxWidth - sum;

        // only one word _OR_ last line
        if(line.size() == 1 || lastLine){
            for(String ln : line){
                paddedLine.append(ln);
                if(nbrOfSpaces!=0){
                    paddedLine.append(' ');
                    nbrOfSpaces--;
                }
            }
            while(nbrOfSpaces!=0){
                paddedLine.append(' ');
                nbrOfSpaces--;
            }
        }
        //justify
        else {
            while(nbrOfSpaces!=0){
                line.set(j,line.get(j)+' ');
                nbrOfSpaces--;
                if(j < line.size()-2){
                    j++;
                }else{
                    j=0;
                }
            }
            for(String ln : line) {
                paddedLine.append(ln);
            }
        }

        return paddedLine;
    }
}
