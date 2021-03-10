package wz.life.base.day05.recordingclass;

/**
 * 使用String、Integer等类型的时候，这些类型都是不变类，一个不变类具有以下特点：
 *
 * 定义class时使用final，无法派生子类；
 * 每个字段使用final，保证创建实例后无法修改任何字段。
 * 假设我们希望定义一个Point类，有x、y两个变量，同时它是一个不变类，可以这么写：
 * @DESCRIPTION 记录类
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/1 10:35 上午
 */
public final class Point {

    //final定义的变量需要进行初始化 直接初始化 或者构造器初始化
    private final int x;
    private final int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int x(){
        return this.x;
    }
    public int y(){
        return this.y;
    }

}
