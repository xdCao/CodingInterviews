package leetcode;

/**
 * Created by xdcao on 2017/8/2.
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb=new StringBuilder();

        if (strs!=null&&strs.length>0){
            for (int i=0;i<strs[0].length();i++){
                char c=strs[0].charAt(i);
                boolean flag=true;
                for (String s:strs){
                    if (s.length()<i+1){
                        return sb.toString();
                    }else {
                        if (s.charAt(i)!=c){
                            flag=false;
                        }
                    }
                }
                if (flag){
                    sb.append(c);
                }else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        String[] strings=new String[]{
                "baa",
                "bba"
        };
        LongestCommonPrefix commonPrefix=new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(strings));

    }


}
