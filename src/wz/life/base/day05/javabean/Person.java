package wz.life.base.day05.javabean;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 11:04 下午
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isChild() {
        return age <= 6;
    }
}
