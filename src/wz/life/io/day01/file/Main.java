package wz.life.io.day01.file;

import sun.plugin2.os.windows.Windows;
import sun.security.action.GetPropertyAction;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;

/**
 *
 * 小结
 * Java标准库的java.io.File对象表示一个文件或者目录：
 *
 * 创建File对象本身不涉及IO操作；
 * 可以获取路径／绝对路径／规范路径：getPath()/getAbsolutePath()/getCanonicalPath()；
 * 可以获取目录的文件和子目录：list()/listFiles()；
 * 可以创建或删除文件和目录。
 *
 * @DESCRIPTION File对象
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/25 10:08 下午
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //注意Windows平台使用\作为路径分隔符，在Java字符串中需要用\\表示一个\。Linux平台使用/作为路径分隔符：

        //Windows
//        String url = "C:\\Users\\jamesbean\\Desktop\\3333.txt";

        //Linux
        String url = "/Users/jamesbean/Desktop/11111.txt";
        File f = new File(url);
//        System.out.println(f.createNewFile());
//        System.out.println(f.exists());
//        System.out.println(f);

        //传入相对路径时，相对路径前面加上当前目录就是绝对路径

        //假设当前目录是C:\Docs
        File f1 = new File("sub\\javac");//绝对路径是C:\Docs\sub\javac
        File f2 = new File(".\\sub\\javac");//绝对路径是C:\Docs\sub\javac
        File f3 = new File("..\\sub\\javca");//绝对路径时C:\sub\javac

        //可以用.表示当前目录，..表示上级目录。

        File f4 = new File("..");
        System.out.println(f4.getPath());//getPath返回构造方法传入的路径
        System.out.println(f4.getAbsolutePath());//getAbsolutePath返回绝对路径
        System.out.println(f4.getCanonicalPath());//getCanonicalPath 返回规范路径

        // ..
        // /Users/jamesbean/IdeaProjects/2020/javase/..
        // /Users/jamesbean/IdeaProjects/2020

//        绝对路径可以表示成C:\Windows\System32\..\notepad.exe，而规范路径就是把.和..转换成标准的绝对路径后的路径：C:\Windows\notepad.exe。

//        因为Windows和Linux的路径分隔符不同，File对象有一个静态变量用于表示当前平台的系统分隔符：

        System.out.println(File.separator);// 根据当前平台打印"\"或"/"


        //底层源码
        char slash = AccessController.doPrivileged(
                new GetPropertyAction("file.separator")).charAt(0);
        char colon = AccessController.doPrivileged(
                new GetPropertyAction("path.separator")).charAt(0);
        String javaHome = AccessController.doPrivileged(
                new GetPropertyAction("java.home"));

        System.out.println(slash);// /
        System.out.println(colon);// :
        System.out.println(javaHome);// /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre



        //isFile() 是否是已存在的文件
        //isDirectory() 是否是已存在的目录
        File f12 = new File("C:\\Windows");
        File f22 = new File("C:\\Windows\\notepad.exe");
        File f32 = new File("C:\\Windows\\nothing");
        System.out.println(f12.isFile());
        System.out.println(f12.isDirectory());
        System.out.println(f22.isFile());
        System.out.println(f22.isDirectory());
        System.out.println(f32.isFile());
        System.out.println(f32.isDirectory());


        //用File 对象获取文件的信息、如 文件的权限 与大小

        //canRead() 是否可读
        //canWrite() 是否可写
        //canExecute() 是否可执行
        //length() 字节大小

        //创建文件 与 删除文件

        File file = f;
        //需要 判断 文件是否存在  不存在 则执行创建
        if(file.createNewFile()){
            //文件创建成功
            System.out.println("文件创建成功");
            if(file.delete()){
                //文件删除成功
                System.out.println("文件删除成功");
            }
        }

        //临时文件
        //createTempFile() 创建一个临时文件
        //deleteOnExit() 在JVM退出时候自动删除该文件
        //前缀 与 后缀
        File temp = File.createTempFile("tmp-",".txt");
        temp.deleteOnExit();
        System.out.println(temp.isFile());
        System.out.println(temp.getAbsolutePath());

        //遍历文件和目录

        //当File对象表示一个目录时，可以使用list()和listFiles()列出目录下的文件和子目录名。listFiles()提供了一系列重载方法，可以过滤不想要的文件和目录：
        File f111 = new File("C:\\Windows");
        File[] fs1 = f111.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f111.listFiles(new FilenameFilter() { // 仅列出.exe文件
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);


//        和文件操作类似，File对象如果表示一个目录，可以通过以下方法创建和删除目录：
//
//        boolean mkdir()：创建当前File对象表示的目录；
//        boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
//        boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。


        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);// ./project/study
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2); // /Users/jamesbean/IdeaProjects/2020/javase/./project/study
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);  //  /Users/jamesbean/IdeaProjects/2020/javase/project/study
        File f222 = p3.toFile(); // 转换为File对象
        System.out.println(f222);// /Users/jamesbean/IdeaProjects/2020/javase/project/study
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }

    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
