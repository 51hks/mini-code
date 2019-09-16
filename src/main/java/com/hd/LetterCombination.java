package com.hd;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    private static char[][] LETTER_ARR = new char[][]{{}, {}
            , {'a', 'b', 'c'}
            , {'d', 'e', 'f'}
            , {'g', 'h', 'i'}
            , {'j', 'k', 'l'}
            , {'m', 'n', 'o'}
            , {'p', 'q', 'r', 's'}
            , {'t', 'u', 'v'}
            , {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        dfs(digits, new StringBuilder(), res, 0);
        return res;
    }

    private static void dfs(String digits, StringBuilder sb, List<String> res, int start) {

        if (start >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        int n = digits.charAt(start) - '0';
        char[] tempArray = LETTER_ARR[n] ;

        if(tempArray.length == 0){
            dfs(digits, sb, res, start+1);
            return ;
        }
        for (char c : tempArray) {
            sb.append(c);
            dfs(digits, sb, res, start + 1);
            sb.setLength(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("46"));
    }
}
