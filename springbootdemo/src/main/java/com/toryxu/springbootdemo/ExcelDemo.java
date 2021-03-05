//package com.toryxu.springbootdemo;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static com.toryxu.springbootdemo.ZipUtil.excuteCompression;
//
///**
// * @Author: toryxu
// * @Date: 2019/5/24 0024 16:27
// * @Version 1.0
// */
//@Controller
//public class ExcelDemo {
//    @RequestMapping("/export")
//    public void export(HttpServletResponse response) {
//        //模拟从数据库获取需要导出的数据
//        List<Person> personList = new ArrayList<>();
//        Person person1 = new Person("路飞", "1", new Date());
//        Person person2 = new Person("娜美", "2", new Date());
//        Person person3 = new Person("索隆", "1", new Date());
//        Person person4 = new Person("小狸猫", "1", new Date());
//        personList.add(person1);
//        personList.add(person2);
//        personList.add(person3);
//        personList.add(person4);
//        //导出操作
//        ExcelUtils.exportExcel(personList, "花名册", "草帽一伙", Person.class, "海贼王.xls", response);
//    }
//
//    @RequestMapping("/importExcel")
//    public void importExcel() {
//        String filePath = "F:\\海贼王.xls";
//        //解析excel，
//        List<Person> personList = ExcelUtils.importExcel(filePath, 0, 1, Person.class);
//        //也可以使用MultipartFile,使用 ExcelUtils.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
//        System.out.println("导入数据一共【" + personList.size() + "】行");
//        //TODO 保存数据库
//    }
//
//    @RequestMapping("/exportZip")
//    public void exportZip(HttpServletRequest request, HttpServletResponse response) {
//        String fileName = "zipTest";
//        String filePath = "E:\\IDEAPrograms\\baocun";
//        try {
//            excuteCompression(request,response,fileName,filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void main(String[] args) {
//        ExcelDemo excelDemo = new ExcelDemo();
//        excelDemo.importExcel();
//    }
//}
