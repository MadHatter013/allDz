package dzLesson13;



import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Try {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(Locale.getDefault());
////        Locale.setDefault(Locale.CANADA);
////        Locale.setDefault(new Locale("ru"));
//        System.out.println(Locale.getDefault());
//
//        ResourceBundle rb = ResourceBundle.getBundle("topic", Locale.getDefault());
//        for (String key : rb.keySet()) {
//            String value = rb.getString(key);
////            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
//            System.out.println(value);
//        }
//    }
public static void main(String[] args) {
    double number = 123.4567;
    Locale locFR = new Locale("fr");

    NumberFormat numberFormat1 = NumberFormat.getInstance();
    System.out.println("Число в текущей локали: " + numberFormat1.format(number));

    NumberFormat numberFormat2 = NumberFormat.getInstance(locFR);
    System.out.println("Число во французской локали: " + numberFormat2.format(number));

    NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance();
    System.out.println("Денежная единица в текущей локали: " + numberFormat3.format(number));

    NumberFormat numberFormat4 = NumberFormat.getCurrencyInstance(locFR);
    System.out.println("Денежная единица во французской локали: " + numberFormat4.format(number));

    NumberFormat numberFormat5 = NumberFormat.getPercentInstance();
    System.out.println("Процент в текущей локали: " + numberFormat5.format(number));

    NumberFormat numberFormat6 = NumberFormat.getPercentInstance(locFR);
    System.out.println("Процент во французской локали: " + numberFormat6.format(number));
}
}
