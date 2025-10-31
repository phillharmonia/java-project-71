package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

import static hexlet.code.DiffNode.Status.ADDED;
import static hexlet.code.DiffNode.Status.REMOVED;
import static hexlet.code.DiffNode.Status.UNCHANGED;
import static hexlet.code.DiffNode.Status.CHANGED;


public class DiffBuilder {

    public static List<DiffNode> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        List<DiffNode> diff = new ArrayList<>();

        for (String key : allKeys) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);

            if (!data1.containsKey(key)) {
                diff.add(new DiffNode(key, ADDED, null, val2));
            } else if (!data2.containsKey(key)) {
                diff.add(new DiffNode(key, REMOVED, val1, null));
            } else if (Objects.equals(val1, val2)) {
                diff.add(new DiffNode(key, UNCHANGED, val1, val2));
            } else {
                diff.add(new DiffNode(key, CHANGED, val1, val2));
            }
        }

        return diff;
    }
}
