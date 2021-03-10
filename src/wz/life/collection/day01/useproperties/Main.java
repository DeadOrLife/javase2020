package wz.life.collection.day01.useproperties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *
 * load()读取文件
 * store()写入配置文件
 *
 * java集合库提供的Properties用于读写配置文件.properties。.properties文件可以使用UTF-8编码。
 *
 * 可以从文件系统、classpath或其他任何地方读取.properties文件。
 *
 * 读写Properties时，注意仅使用getProperty()和setProperty()方法，不要调用继承而来的get()和put()等方法。
 *
 * @DESCRIPTION 使用Properties
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/10 11:06 下午
 */
public class Main {


    public static void main(String[] args) throws IOException {


        //读取文件
        //1.创建properties文件
        //2.调用load读取文件
        //3.调用getProperty()获取配置
        String f = "src/wz/life/collection/day01/useproperties/xx.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(f));
        System.out.println(properties.getProperty("file"));
//        调用getProperty()获取配置时，如果key不存在，将返回null。
//        我们还可以提供一个默认值，这样，当key不存在的时候，就返回默认值。


        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        Properties props = new Properties();
        props.load(input);

        System.out.println("course: " + props.getProperty("course"));
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));

        Properties props2 = new Properties();
        props2.setProperty("url", "http://www.liaoxuefeng.com");
        props2.setProperty("language", "Java");
        props2.store(new FileOutputStream("src/wz/life/collection/day01/useproperties/xx.properties"),"这是写入注释");


//        编码
//        早期版本的Java规定.properties文件编码是ASCII编码（ISO8859-1），如果涉及到中文就必须用name=\u4e2d\u6587来表示，非常别扭。从JDK9开始，Java的.properties文件可以使用UTF-8编码了。
//
//        不过，需要注意的是，由于load(InputStream)默认总是以ASCII编码读取字节流，所以会导致读到乱码。我们需要用另一个重载方法load(Reader)读取：
//
//        Properties props = new Properties();
//        props.load(new FileReader("settings.properties", StandardCharsets.UTF_8));
//        就可以正常读取中文。InputStream和Reader的区别是一个是字节流，一个是字符流。字符流在内存中已经以char类型表示了，不涉及编码问题。

    }
}
