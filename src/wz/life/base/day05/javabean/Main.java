package wz.life.base.day05.javabean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 *
 * JavaBean是一种符合命名规范的class，它通过getter和setter来定义属性；
 *
 * 属性是一种通用的叫法，并非Java语法规定；
 *
 * 可以利用IDE快速生成getter和setter；
 *
 * 使用Introspector.getBeanInfo()可以获取属性列表
 *
 *
 * @DESCRIPTION java bean
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 11:03 下午
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
        //运行上述代码，可以列出所有的属性，以及对应的读写方法。
        // 注意class属性是从Object继承的getClass()方法带来的。

        /*
age
  public int wz.life.base.day05.javabean.Person.getAge()
  public void wz.life.base.day05.javabean.Person.setAge(int)
child
  public boolean wz.life.base.day05.javabean.Person.isChild()
  null
class
  public final native java.lang.Class java.lang.Object.getClass()
  null
name
  public java.lang.String wz.life.base.day05.javabean.Person.getName()
  public void wz.life.base.day05.javabean.Person.setName(java.lang.String)
*/
    }
}
