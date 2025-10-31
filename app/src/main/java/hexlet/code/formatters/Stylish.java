package hexlet.code.formatters;
import hexlet.code.DiffNode;
import java.util.List;

public class Stylish {
    public static String format(List<DiffNode> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (DiffNode node : diff) {
            String key = node.key();
            Object val1 = node.value1();
            Object val2 = node.value2();

            switch (node.status()) {
                case ADDED -> result.append("  + ").append(key).append(": ").append(val2).append("\n");
                case REMOVED -> result.append("  - ").append(key).append(": ").append(val1).append("\n");
                case CHANGED -> {
                    result.append("  - ").append(key).append(": ").append(val1).append("\n");
                    result.append("  + ").append(key).append(": ").append(val2).append("\n");
                }
                case UNCHANGED -> result.append("    ").append(key).append(": ").append(val1).append("\n");
                default -> throw new IllegalArgumentException("Unknown status: " + node.status());
            }
        }

        result.append("}");
        return result.toString();
    }
}
