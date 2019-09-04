import java.util.HashMap;

/**
 * @author RayTing
 * @date 2019-09-02 14:07
 */
public class TestOut {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        System.out.println("map = " + map);
        String arg = map.get("1");
        System.out.println("arg = " + arg);

        map.remove("3");
        System.out.println(map);
    }
}
