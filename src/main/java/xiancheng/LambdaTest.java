//package xiancheng;
//
//import excel.Person;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
///**
// * @author toryxu
// * @version 1.0
// * @date 2020/10/15 9:40 下午
// */
//public class LambdaTest {
//
//    Person person3 = new Person("实例变量");
//
//    public void test() {
//        List<String> list = new ArrayList<>();
//        Person person1 = new Person("局部变量", "Male", new Date());
//        person1 = new Person("ToryXu", "Male", new Date());
////        //局部变量，并在定义之后修改了引用地址，报错
////        CompletableFuture.runAsync(() -> {
////            System.out.println(person1);
////        });
//        Person person2 = new Person("局部变量", "Male", new Date());
//        //局部变量，并在定义之后没有修改引用地址，具有final的语义，编译器自动加上final修饰符
//        CompletableFuture.runAsync(() -> {
//            System.out.println(person2);
//        });
//        //实例变量
//        CompletableFuture.runAsync(() -> {
//            System.out.println(person3);
//        });
//        //实例变量，修改引用地址
//        person3 = new Person("ToryXu");
//        CompletableFuture.runAsync(() -> {
//            System.out.println(person3);
//        });
//        final Person person4 = new Person("局部变量", "Male", new Date());
//        //局部变量，本身就通过final修饰
//        CompletableFuture.runAsync(() -> {
//            System.out.println(person4);
//        });
//    }
//
//    public static void main(String[] args) {
//        new LambdaTest().test();
//    }
//}
