package jtkj;

import java.text.DecimalFormat;

/**
 * @Author: toryxu
 * @Date: 2019/4/16 0016 15:48
 * @Version 1.0
 */
public class hktest {
    public static void main(String[] args) {
//        int a = ;
       double a = 0.0233;
        DecimalFormat df = new DecimalFormat("#.00");
        Double c = Double.valueOf(df.format(a));
        System.out.println(c);
    }
}
