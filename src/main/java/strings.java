/**
 * @Author: toryxu
 * @Date: 2019/3/25 0025 19:02
 * @Version 1.0
 */
public class strings {
    public static void main(String[] args) {
        //a='123'是存放在常量池内，用new的话是存放在堆内。
        //Java 堆是所有线程共享的一块内存区域，
        //在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例以及数组都在这里分配内存。
        //栈存放局部变量
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的String对象一个是常量池中的String对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的String对象
        String s4 = new String("abc");// 堆内存的地址值
        String s5 = "abc";
        System.out.println(s4 == s5);// 输出false,因为一个是堆内存，一个是常量池的内存，故两者是不同的。
        System.out.println(s4.equals(s5));// 输出true
    }
}
