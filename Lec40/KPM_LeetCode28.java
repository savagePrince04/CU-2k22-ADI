package Lec40;

public class KPM_LeetCode28 {
    class Solution {
        private int[] computeTemporaryArray(char pattern[]){
            int [] lps = new int[pattern.length];
            int index =0;
            for(int i=1; i < pattern.length;){
                if(pattern[i] == pattern[index]){
                    lps[i] = index + 1;
                    index++;
                    i++;
                }else{
                    if(index != 0){
                        index = lps[index-1];
                    }else{
                        lps[i] =0;
                        i++;
                    }
                }
            }
            return lps;
        }
        /**
         * KMP algorithm of pattern matching.
         */
        public int KMP(char []text, char []pattern){

            int lps[] = computeTemporaryArray(pattern);
            int i=0;
            int j=0;
            while(i < text.length && j < pattern.length){
                if(text[i] == pattern[j]){
                    i++;
                    j++;
                }else{
                    if(j!=0){
                        j = lps[j-1];
                    }else{
                        i++;
                    }
                }
            }
            if(j == pattern.length){
                return (i-pattern.length);
            }
            return -1;
        }
        public int strStr(String haystack, String needle) {
            char[] a = haystack.toCharArray();
            char[] b = needle.toCharArray();
            return KMP(a ,b);
        }
    }
}
