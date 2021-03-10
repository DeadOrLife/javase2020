package wz.life.exception.day01.customexception;

/**
 * 抛出异常时，尽量复用JDK已定义的异常类型；
 *
 * 自定义异常体系时，推荐从RuntimeException派生“根异常”，再派生出业务异常；
 *
 * 自定义异常时，应该提供多种构造方法。
 *
 * @DESCRIPTION 自定义异常
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 11:00 上午
 */
public class BaseException extends RuntimeException{

    //上述构造方法实际上都是原样照抄RuntimeException。
    // 这样，抛出异常的时候，就可以选择合适的构造方法。
    // 通过IDE可以根据父类快速生成子类的构造方法。
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
