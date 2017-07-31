package leetcode;

/**
 * Created by xdcao on 2017/7/31.
 */
public class ReverseInteger {

    public int reverse(int x) {

        String str=String.valueOf(x);
        if (str.charAt(0)=='-'){
            StringBuilder builder=new StringBuilder();
            builder.append("-");
            for (int i=str.length()-1;i>=1;i--){
                builder.append(str.charAt(i));
            }
            int result = 0;
            try {
                result=Integer.parseInt(builder.toString());
            }catch (Exception e){
                return 0;
            }
            return result;
        }else {
            StringBuilder builder=new StringBuilder();
            for (int i=str.length()-1;i>=0;i--){
                builder.append(str.charAt(i));
            }
            int result = 0;
            try {
                result=Integer.parseInt(builder.toString());
            }catch (Exception e){
                return 0;
            }
            return result;
        }


    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        int reverse = reverseInteger.reverse(1534236469);
        System.out.println(reverse);
    }

}
