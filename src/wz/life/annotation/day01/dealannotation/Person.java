package wz.life.annotation.day01.dealannotation;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/6 12:23 上午
 */
public class Person {
    @Range(min = 1,max = 2022)
    public  String name;

    @Range(max=1022)
    public String city;

    @Range(max = 1112)
    public int age;

    @Range(max = 1112)
    public int a;

    @Range(max = 1112)
    private int b;

    @Range(max = 1112)
    protected int c;

    @Range(max = 1112)
     int d;

}
