package com.gokul.mediumquestions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {

//    3. Longest Substring Without Repeating Characters

    public static void main(String[] args) {

    String word=" ";
//    int maxLength=getNumberOfCharactersBruteForce(word);
        int maxLength=getNumberOdCharactersSlidingWindow(word);
        System.out.println(maxLength);

    }

    public static int getNumberOfCharactersBruteForce(String word){

        if(word.length()<-1)
            return 0;
        int maxvalue=0;
        Set<Character>characterSet=new HashSet<>();
        char[] charArray= word.toCharArray();

        for(int i=0;i<word.length();i++){
            for(int j=i;j<word.length();j++){
                if(!characterSet.add(charArray[j])){
                    i=j+1;
                    maxvalue=Integer.max(maxvalue,characterSet.size());
                    characterSet.clear();
                }
                characterSet.add(charArray[j]);
            }
        }

        return maxvalue;
    }

    public  static int getNumberOdCharactersSlidingWindow(String s){

        int pointer1=0;
        int pointer2=0;

        int maxLength=0;

        Set<Character>characterSet=new HashSet<>();

        while(pointer2<s.length()){
            if(!characterSet.contains(s.charAt(pointer2))){
                characterSet.add(s.charAt(pointer2));
                maxLength=Math.max(maxLength,characterSet.size());
                pointer2++;
            }
            else {
                characterSet.remove(s.charAt(pointer1));
                pointer1++;
            }
        }

        return maxLength;
    }
}
