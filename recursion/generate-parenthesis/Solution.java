import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> ans = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        //oc oc
        //gen("",o,c) -> gen("(",o-1,c+1)
        //gen("(",o-1,c+1) -> gen("()",o-1,c) or gen("((",o-2,c+2)
        solve("",n,0);
        return ans;
    }
    static void solve(String str, int openBracketLeft, int closedBracketLeft){
        if(openBracketLeft == closedBracketLeft && openBracketLeft == 0){
            ans.add(str);
            return;
        }
        if(openBracketLeft>0)
            solve(str+"(",openBracketLeft-1, closedBracketLeft+1);
        if(closedBracketLeft>0)
            solve(str+")",openBracketLeft, closedBracketLeft-1);
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));    
    }
}