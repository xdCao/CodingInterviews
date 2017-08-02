package leetcode;

import java.util.HashMap;

/**
 * Created by xdcao on 2017/8/2.
 */
public class Roman2Integer {

    public int romanToInt(String s) {

        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=0;

        for (int i=0;i<s.length();i++){
            if (i==0){
                sum=sum+map.get(s.charAt(0));
            }else {
                if (map.get(s.charAt(i))<=map.get(s.charAt(i-1))){
                    sum=sum+map.get(s.charAt(i));
                }else {
                    sum=sum-map.get(s.charAt(i-1))*2+map.get(s.charAt(i));
                }
            }

            if (i>=3){
                if (s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==s.charAt(i-2)&&s.charAt(i-2)==s.charAt(i-3)){
                    throw new RuntimeException("不能连续三个相同数");
                }
            }

        }

        if (sum>=4000){
            throw new RuntimeException("不能超过3999");
        }

        return sum;


    }


    public static void main(String[] args) {

        Roman2Integer roman2Integer=new Roman2Integer();
        int i = roman2Integer.romanToInt("DCXXI");
        System.out.println(i);

    }

}
