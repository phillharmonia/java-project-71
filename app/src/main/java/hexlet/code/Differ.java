package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate(String filePath1, String filePath2)  throws Exception {
        Map<String, Object> data1 = readFile(filePath1);
        Map<String, Object> data2 = readFile(filePath2);

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        StringBuilder result = new StringBuilder("{\n");

        for (String key : allKeys) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);

            if (!data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(val1).append("\n");
            } else if (!data1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(val2).append("\n");
            } else if (val1 == null && val2 == null || val1 != null && val1.equals(val2)) {
                result.append("    ").append(key).append(": ").append(val1).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(val1).append("\n");
                result.append("  + ").append(key).append(": ").append(val2).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
    private static Map<String, Object> readFile(String filePath) throws Exception {
        Path path = Path.of(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }
}