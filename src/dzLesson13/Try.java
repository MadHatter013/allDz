package dzLesson13;



import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Try {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Locale.getDefault());
//        Locale.setDefault(Locale.CANADA);
//        Locale.setDefault(new Locale("ru"));
        System.out.println(Locale.getDefault());

        ResourceBundle rb = ResourceBundle.getBundle("topic", Locale.getDefault());
        for (String key : rb.keySet()) {
            String value = rb.getString(key);
//            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(value);
        }
    }

}
