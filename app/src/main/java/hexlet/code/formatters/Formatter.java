package hexlet.code.formatters;

import hexlet.code.DiffNode;
import java.util.List;

public class Formatter {

    public static String format(List<DiffNode> diff, String formatName) throws Exception {
        return switch (formatName) {
            case "plain" -> Plain.format(diff);
            case "stylish", "" -> Stylish.format(diff);
            case "json" -> Json.format(diff);
            default -> throw new IllegalArgumentException("Unknown format: " + formatName);
        };
    }
}
