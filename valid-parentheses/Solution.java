import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class Solution{
    public static boolean isValid(String s) {
    Stack<String> stack = new Stack<>();
    Map<String,String> map = new HashMap<>();

    //mapping brackets
    map.put("]","[");
    map.put("}","{");
    map.put(")","(");


    for(int i=0;i<s.length();i++){
        int ptr = i;
        if( Stream.of("(","[","{").anyMatch(ii -> ii.equals(s.charAt(ptr)+"")))
            stack.push(s.charAt(i)+""); //push opening brackets
        else{
            if(stack.empty()) // closing bracket but no brackets in stack
                return false;
           if(stack.peek().equals(map.get(s.charAt(i)+""))){
                stack.pop(); //closing bracket matches opening brancket at head
           }
           else // closing bracket but no opening bracket
            return false;
        }
    }
    if(stack.empty() && s.length()>1) //string validated so stack empty
        return true;
    return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}