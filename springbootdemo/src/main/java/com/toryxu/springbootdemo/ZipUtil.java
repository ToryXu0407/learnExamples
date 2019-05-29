package com.toryxu.springbootdemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @Author: toryxu
 * @Date: 2019/5/29 0029 13:55
 * @Version 1.0
 */
public class ZipUtil {

    private static final String ZIP_NAME = "要生成的压缩包名字";
    /**
     * 压缩多个文件成一个zip文件
     *
     * <p>Title: compressionFile</p>
     * <p>Description: </p>
     * @time 下午1:48:38
     * @param srcfile  源文件列表
     * @param zipfile  压缩后的文件
     */
    public static void compressionFile(File[] srcfile, File zipfile) {
        byte[] buffer = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for (int i = 0; i < srcfile.length; i++) {
                FileInputStream fileInputStream = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                out.closeEntry();
                fileInputStream.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压缩
     *
     * <p>Title: uncompression</p>
     * <p>Description: </p>
     * @time 下午1:36:22
     * @param zipfile  需要解压缩的文件
     * @param descDir  解压后的目标目录
     */
    @SuppressWarnings({ "resource", "rawtypes" })
    public static void unompressionFile(File zipfile, String descDir) {
        try {
            ZipFile zipFile = new ZipFile(zipfile);
            for (Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zipFile.getInputStream(entry);
                OutputStream out = new FileOutputStream(descDir + zipEntryName);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 调用执行压缩
     *
     * <p>Title: excuteCompression</p>
     * <p>Description: </p>
     * @time 下午4:22:38
     * @param filename压缩包名字
     * @throws IOException
     */
    public static void excuteCompression(HttpServletRequest request, HttpServletResponse response, String filename,
                                         String pdfPath) throws IOException {
        String zipPath = request.getSession().getServletContext().getRealPath(ZIP_NAME);
        //创建文件夹
        File folder = new File(zipPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        folder.createNewFile();
        String filePath = pdfPath;
        File file = new File(filePath);
        // 获取文件夹下所有文件信息
        File[] srcfile = file.listFiles();
        // 压缩包存放位置
        File zipfile = new File(zipPath + "/" + filename + ".zip");
        // 调用压缩方法
        ZipUtil.compressionFile(srcfile, zipfile);

        // 删除生成的文件夹和文件
        String downPath = zipPath + "/" + filename + ".zip";
        ZipUtil.download(downPath, response);
        //删除源文件夹及其内容
        ZipUtil.deleteAll(file);
        //删除下载完的压缩包存储临时文件夹及其内容
        File zfile = new File(zipPath);
        ZipUtil.deleteAll(zfile);
    }

    /**
     * <p>Title: excuteUncompression</p>
     * <p>Description: </p>
     * @time 上午9:50:26
     * @param filePath
     * 这里需要两个路径
     * 首先传入一个要解压的文件所在路径
     * 然后定义解压之后的存储路径
     */
    public static void excuteUncompression(String filePath) {
        //获取桌面绝对路径
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        //需要解压缩的文件
        File file = new File(filePath);
        //解压后默认存放在桌面
        String dir = desktopPath;
        ZipUtil.unompressionFile(file, dir);
    }


    /**
     * 下载服务器下生成的文件
     *
     * <p>Title: download</p>
     * <p>Description: </p>
     * @time 下午2:51:34
     * @param path
     * @param response
     */
    public static void download(String path, HttpServletResponse response) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File file = new File(path);
            /* 读取要下载的文件，保存到文件输入流 */
            in = new FileInputStream(file);
            /* 设置响应头，控制浏览器下载该文件 */
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(file.getName().getBytes("UTF-8"), "ISO8859-1"));
            /* 创建缓冲输出流 */
            out = new BufferedOutputStream(response.getOutputStream());
            /* 定义缓冲区大小，开始读写 */
            byte buffer[] = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            /* 刷新缓冲区，写出 */
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 删除文件夹及其下面的所有文件
     *
     * <p>Title: deleteAll</p>
     * <p>Description: </p>
     * @time 下午4:09:03
     * @param file
     */
    public static void deleteAll(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            for (File f : file.listFiles()) {
                // 递归删除文件夹下的每一个文件
                deleteAll(f);
            }
            // 删除文件夹
            file.delete();
        }
    }
}