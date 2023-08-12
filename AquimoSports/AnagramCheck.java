package AquimoSports;

import java.util.HashMap;
import java.util.Scanner;

public class AnagramCheck {
    //Method 1: Using Boolean array of visited index
    //Complexity: O(N^2)
    public static boolean isStringsAnagram(String str1, String str2){
        //To check the index is visited or not
        boolean[] isVisted=new boolean[str2.length()];
        boolean isAnagram=false;
        if(str1.length() != str2.length()){
            return false;
        }

        for(int i=0;i<str1.length();i++){
            isAnagram=false;
            char c=str1.charAt(i);
            for(int j=0;j<str2.length();j++){
                if(str2.charAt(j)==c && !isVisted[j]){
                    isAnagram=true;
                    isVisted[j]=true;
                    break;
                }
            }
            if(!isAnagram){
                return false;
            }
        }
        return true;
    }

    //Method 2: Using array of length 256 of ASCII Value of character
    // Complexity: O(N)
    public static boolean isStringsAnagramMetod2(String str1, String str2){
        //Since we have 256 different character in key board and all has unique scii value
        int[] AsciiValue=new int[256];
        if(str1.length() != str2.length()){
            return false;
        }
        for(char c:str1.toCharArray()){
            int index=(int) c;
            AsciiValue[index]++;
        }
        for(char c:str2.toCharArray()){
            int index=(int) c;
            AsciiValue[index]--;
        }
        for(int i=0;i<256;i++){
            if(AsciiValue[i] !=0){
                return false;
            }
        }
        return true;
    }

    //Method 3: using HashMap
    //Time Complexity: O(N)
    public static boolean AnagramsMethod3(String str1, String str2){
        HashMap<Character,Integer> frequencyOfChar=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            //getOrDefault() is used to check if that character is already present then get frequency otherwise get 0
            //and then I'm incementing by 1
            frequencyOfChar.put(ch, frequencyOfChar.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            if(frequencyOfChar.containsKey(ch)==false){
                return false;
            }
            else if(frequencyOfChar.get(ch)==1){
                frequencyOfChar.remove(ch);
            }
            else {
                frequencyOfChar.put(ch, frequencyOfChar.get(ch) - 1);
            }
        }
        if(frequencyOfChar.size()==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("First String: ");
        String str1=sc.nextLine();
        System.out.print("Second String: ");
        String str2=sc.nextLine();
        System.out.println("Method 1 result: "+ isStringsAnagram(str1,str2));
        System.out.println("Method 2 result: "+ isStringsAnagramMetod2(str1,str2));
        System.out.println("Method 3 result: "+ AnagramsMethod3(str1,str2));

    }
}
