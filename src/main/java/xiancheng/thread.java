package xiancheng;

/**
 * @Author: toryxu
 * @Date: 2018/11/6 0006 13:21
 * @Version 1.0
 */
public class thread {
    public static void main(String[] args) {
        fuck fuck1 = new fuck();
        fuck1.fuck();
    }
    static class fuck extends Thread{
        public void fuck(){
            System.out.println("fuck");
        }
    }

}
