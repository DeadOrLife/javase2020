package wz.life.base.day04.interfaceclass;

/**
 *
 * Java的接口（interface）定义了纯抽象规范，一个类可以实现多个接口；
 *
 * 接口也是数据类型，适用于向上转型和向下转型；
 *
 * 接口的所有方法都是抽象方法，接口不能定义实例字段；
 *
 * 接口可以定义default方法（JDK>=1.8）。
 *
 *
 * abstract     class	            interface
 * 继承	        只能extends一个class	可以implements多个interface
 * 字段	        可以定义实例字段	    不能定义实例字段
 * 抽象方法	    可以定义抽象方法	    可以定义抽象方法
 * 非抽象方法	    可以定义非抽象方法	    可以定义default方法
 *
 * 如果一个抽象类没有字段，所有方法全部都是抽象方法：
 * 就可以把该抽象类改写为接口：interface。
 *
 *
 * 实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，
 * 会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
 *
 * 所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。
 * 因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
 *
 * default方法和抽象类的普通方法是有所不同的。因为interface没有字段，
 * default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
 *
 * @DESCRIPTION 接口
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/26 11:02 下午
 */
public class Main {
    public static void main(String[] args) {

    }
}

interface Hello{
    void hello();
}

interface Person extends Hello{
    default  void run(){
        System.out.println(getName() + " run");

    }
    String getName();
}

class Student implements Person{
    private String name;

    @Override
    public void run() {
        System.out.println("Studnet.run");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void hello() {

    }
}
