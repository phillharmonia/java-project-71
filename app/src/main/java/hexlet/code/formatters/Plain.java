package hexlet.code.formatters;

import hexlet.code.DiffNode;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<DiffNode> diff) {
        StringBuilder result = new StringBuilder();

        for (DiffNode node : diff) {
            String property = node.key();
            Object oldValue = node.value1();
            Object newValue = node.value2();

            switch (node.status()) {
                case ADDED -> result.append(
                        String.format("Property '%s' was added with value: %s%n",
                                property, stringify(newValue))
                );
                case REMOVED -> result.append(
                        String.format("Property '%s' was removed%n", property)
                );
                case CHANGED -> result.append(
                        String.format("Property '%s' was updated. From %s to %s%n",
                                property, stringify(oldValue), stringify(newValue))
                );
                case UNCHANGED -> {

                }
                default -> throw new IllegalStateException("Неизвестный статус: " + node.status());
            }
        }

        return result.toString().trim();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map<?, ?> || value instanceof List<?>) {
            return "[complex value]";
        }
        return value.toString();
    }
}
