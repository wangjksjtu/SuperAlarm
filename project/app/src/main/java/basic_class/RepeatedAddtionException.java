package basic_class;

/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class RepeatedAddtionException extends Exception {
    public RepeatedAddtionException() {
        super("The items has existed!");
    }
}
