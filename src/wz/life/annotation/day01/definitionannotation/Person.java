package wz.life.annotation.day01.definitionannotation;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/6 12:07 上午
 */
@Report(type = 1)
public class Person {
}

//则它的子类默认也定义了该注解： 因为@Inherited
class Student extends Person{

}
