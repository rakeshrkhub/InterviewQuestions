package MostAskedQue;

public class NoOfBalanceSubstring {
    public static int balancedStringSplit(String s) {
        int cR=0,cL=0,count=0;
        for(int i:s.toCharArray())
        {
            if( i== 'R' )
                cR++;

            else if( i=='L' )
                cL++;

            if(cR==cL)
            {
                count++;
                cR=0;cL=0;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        /* Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

        Given a balanced string s, split it into some number of substrings such that:

        Each substring is balanced.
        Return the maximum number of balanced strings you can obtain.



        Example 1:

        Input: s = "RLRRLLRLRL"
        Output: 4
        Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'. */
        String str="RRLRRLRLLLRL";
        System.out.println(balancedStringSplit(str));

    }
}
