
import com.alibaba.fastjson.JSONObject;

/**
 * Json工具类 返回状态码自定义
 * @Author: Monkey
 * @Date: Created in 16:21  2018/3/14.
 * @Description:
 */
public class JsonUtil {

    public JsonUtil() {
    }

    public static JSONObject createFailJson(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "400");
        jsonObject.put("msg", msg);
        jsonObject.put("page", "");
        return jsonObject;
    }

    public static JSONObject createFailJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "400");
        jsonObject.put("msg", "操作失败");
        jsonObject.put("page", "");
        return jsonObject;
    }
    public static JSONObject createOkJson(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", msg);
        jsonObject.put("page", "");
        return jsonObject;
    }

    public static JSONObject createOkJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", "success");
        jsonObject.put("page", "");
        return jsonObject;
    }

    public static JSONObject createOkObject(Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("entity", object);
        jsonObject.put("msg", "success");
        return jsonObject;
    }

    public static JSONObject createPageObject(Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("page", object);
        jsonObject.put("msg", "success");
        return jsonObject;
    }

    public static JSONObject dataOSFailJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "User not logged in");
        jsonObject.put("code", "530");
        jsonObject.put("page", "");
        return jsonObject;
    }

    public static JSONObject dataOSUserFailJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "Imperfect user information");
        jsonObject.put("code", "531");
        jsonObject.put("page", "");
        return jsonObject;
    }
}
