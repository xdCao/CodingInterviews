package leetcode;

/**
 * Created by xdcao on 2017/7/31.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if (s.equals("")){
            return 0;
        }

        int maxLen=1;

        for (int i=0;i<s.length();i++){
            int temp=1;
            for (int k=i+1;k<s.length();k++){
                boolean flag=true;
                for (int j=i;j<k;j++){
                    if (s.charAt(k)==s.charAt(j)){
                        flag=false;
                    }
                }
                if (flag){
                    temp++;
                    if (k==s.length()-1){
                        if (temp>maxLen){
                            return temp;
                        }else {
                            return maxLen;
                        }
                    }
                }else {
                    if (temp>maxLen){
                        maxLen=temp;
                    }
                    temp=1;
                    break;
                }
            }
        }

        return maxLen;

    }

    public static void  main(String[] args){
        LongestSubstring longestSubstring=new LongestSubstring();
        int i = longestSubstring.lengthOfLongestSubstring("abcb");
        System.out.println(i);
    }


}
