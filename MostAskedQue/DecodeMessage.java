package MostAskedQue;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public static void main(String[] args) {
        // LeetCode 2325. Decode the Message (Easy)
        //Instead of string decodedMessage, we can use StringBuilder as it is more faster than String

        String key="the quick brown fox jumps over the lazy dog";
        String message="vkbs bs t suepuv";
        char c='a';
        Map<Character,Character> keyMess=new HashMap<>();
        for(int i=0;i<key.length();i++){
            if(!keyMess.containsKey(key.charAt(i)) && key.charAt(i) !=' '){
                keyMess.put(key.charAt(i),c);
                c++;
            }
        }
        String decodedMessage="";
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' '){
                decodedMessage +=' ';
            }
            else{
                char x=keyMess.get(message.charAt(i));
                decodedMessage +=x;
            }
        }
        System.out.println(decodedMessage);
    }
}
