package wz.life.exception.day01.customexception;

/**
 * Exception
 * │
 * ├─ RuntimeException
 * │  │
 * │  ├─ NullPointerException
 * │  │
 * │  ├─ IndexOutOfBoundsException
 * │  │
 * │  ├─ SecurityException
 * │  │
 * │  └─ IllegalArgumentException
 * │     │
 * │     └─ NumberFormatException
 * │
 * ├─ IOException
 * │  │
 * │  ├─ UnsupportedCharsetException
 * │  │
 * │  ├─ FileNotFoundException
 * │  │
 * │  └─ SocketException
 * │
 * ├─ ParseException
 * │
 * ├─ GeneralSecurityException
 * │
 * ├─ SQLException
 * │
 * └─ TimeoutException
 *
 * @DESCRIPTION 自定义异常
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 10:55 上午
 */
public class Main {
    public static void main(String[] args) {
        //当我们在代码中需要抛出异常时，尽量使用JDK已定义的异常类型。
        // 例如，参数检查不合法，应该抛出IllegalArgumentException：



        //在一个大型项目中，可以自定义新的异常类型，
        // 但是，保持一个合理的异常继承体系是非常重要的。
        //
        //一个常见的做法是自定义一个BaseException作为“根异常”，
        // 然后，派生出各种业务类型的异常。
        //
        //BaseException需要从一个适合的Exception派生，
        // 通常建议从RuntimeException派生：

        //public class BaseException extends RuntimeException {
        //}
        //其他业务类型的异常就可以从BaseException派生：
        //
        //public class UserNotFoundException extends BaseException {
        //}
        //
        //public class LoginFailedException extends BaseException {
        //}
        //
        //...

    }

    static void precess1(int age){
        if (age <= 0){
            throw new IllegalArgumentException();
        }
    }
}
