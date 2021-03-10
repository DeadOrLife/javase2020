package wz.life.io.day01.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * 练习
 * 请利用File对象列出指定目录下的所有子目录和文件，并按层次打印。
 *
 * 例如，输出：
 *
 * Documents/
 *   word/
 *     1.docx
 *     2.docx
 *     work/
 *       abc.doc
 *   ppt/
 *   other/
 *
 * @DESCRIPTION
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/26 9:36 上午
 */
public class Practice {

    public static void main(String[] args) throws IOException {

        String url = "/Users/jamesbean/Desktop/Documents";
        File file = new File(url);


        printFile(url,"");

//        for (File f: file.listFiles()
//             ) {
//            System.out.println(f);
//        }

//        File files[] = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isFile();
//            }
//        });

//        File[] fs2 = file.listFiles(new FilenameFilter() { // 仅列出.exe文件
//            @Override
//            public boolean accept(File dir, String name) {
//                return !name.endsWith(".DS_Store"); // 返回true表示接受该文件
//            }
//        });

//        for (File f: files) {
//            System.out.println(f);
//        }
//        for (File f: fs2) {
//            System.out.println(f.getName());
//        }
//        for (String f: file.list()) {
//            System.out.println(f);
//        }


    }

    public static void printFile(String pathName,String indentation){
        Path path = Paths.get(pathName);
        File file = path.toFile();
        File[] list = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.endsWith(".DS_Store");
            }
        });
        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println(indentation+f.getName()+"/");
                printFile(f.getAbsolutePath(),indentation+"  ");
            }else {
                System.out.println(indentation+f.getName());
            }

//            System.out.println(f.getName());
//            if (f.isDirectory()) {
//                printFile(f.getAbsolutePath());
//            }
        }
    }
}
