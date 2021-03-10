package wz.life.base.day05.stringjoiner;

import java.util.StringJoiner;

/**
 *
 * 用指定分隔符拼接字符串数组时，使用StringJoiner或者String.join()更方便；
 *
 * 用StringJoiner拼接字符串时，还可以额外附加一个“开头”和“结尾”。
 *
 * @DESCRIPTION StringJoiner
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 11:58 上午
 */
public class Main {


    public static void main(String[] args) {
        //类似用分隔符拼接数组的需求很常见
        String[] names = {"bob","alice","grace"};
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (String name: names
             ) {
            sb.append(name).append(", ");
        }
        //去除 最后的,
        sb.delete(sb.length()-2,sb.length());
        sb.append("!");
        System.out.println(sb);


        //bob, alice, grace
        StringJoiner sj = new StringJoiner(", ");

        //指定开头与结尾
        //Hello bob, alice, grace!
         sj = new StringJoiner(", ","Hello ","!");
        for (String name: names
             ) {
            sj.add(name);
        }
        System.out.println(sj);


        //如果不需要指定开头与结尾可以使用 join
        //底层 实际就是用StringJoiner
        String s = String.join(",",names);
        System.out.println(s);


        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }



    static String buildSelectSql(String table, String[] fields) {
        // TODO:
        String prefix = "SELECT ";
        String suffix = " FROM "+table;
        StringJoiner sj = new StringJoiner(", ",prefix,suffix);
        for (String field: fields) {
            sj.add(field);

        }
        return sj.toString();
    }


}


