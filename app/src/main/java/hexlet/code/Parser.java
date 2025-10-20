package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String extension) throws Exception {
        ObjectMapper mapper;

        switch (extension) {
            case "json" -> mapper = new ObjectMapper();
            case "yaml" -> mapper = new ObjectMapper(new YAMLFactory());
            default -> throw new IllegalArgumentException("Формат: " + extension + " не поддерживается");
        }

        return mapper.readValue(content, Map.class);
    }
}