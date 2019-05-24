import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @Author: toryxu
 * @Date: 2019/4/8 0008 15:39
 * @Version 1.0
 */
public class test  implements Serializable {

    private static final long serialVersionUID = 1108406745348704415L;

    public static void main(String[] args) {
        String sb  = "\"name\"";
        sb.replace("\"","");
        System.out.println(sb);
    }
}
