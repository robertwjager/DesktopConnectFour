import java.util.*;

class MapUtils {

    public static void mapShare(Map<String, String> map) {
        // Check if the key "a" exists
        if (map.containsKey("a")) {
            // Get the value associated with key "a"
            String valueA = map.get("a");

            // Set the value of key "b" to the value of key "a"
            map.put("b", valueA);
        }

        // Remove the key "c"
        map.remove("c");
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(":");
            map.put(pair[0], pair[1]);
        }
        MapUtils.mapShare(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}