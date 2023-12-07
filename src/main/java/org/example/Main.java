package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String order="worldabcefghijkmnpqstuvxyz";
        String[] words={"word", "world","row"};
        HashMap<Character,Integer> pair=new HashMap<>();
        for(int i=0;i<order.length();i++){
            pair.put(order.charAt(i),i);

        } //System.out.println(pair);

        int n=words.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(toSwap(words[j], words[j+1], pair)){
                    String temp=words[j];
                    words[j]=words[j+1];
                    words[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(words));
    }
    private static boolean toSwap(String one, String two, HashMap pair) {
        int i=0;
        int j=0;
        while(i<one.length() && j<two.length()) {
            char ch1 = one.charAt(i);
            char ch2 = two.charAt(j);
            int num1 = (int) pair.get(ch1);
            int num2 = (int) pair.get(ch2);
            if (num1 > num2) {
                return true;
            } else if (num1 < num2) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return false;
    }

}
