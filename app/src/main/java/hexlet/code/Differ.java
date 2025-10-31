package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.List;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String content1 = Files.readString(Path.of(filePath1));
        String content2 = Files.readString(Path.of(filePath2));

        String ext1 = getFileExtension(filePath1);
        String ext2 = getFileExtension(filePath2);

        Map<String, Object> data1 = Parser.parse(content1, ext1);
        Map<String, Object> data2 = Parser.parse(content2, ext2);

        List<DiffNode> diff = DiffBuilder.buildDiff(data1, data2);

        return Formatter.format(diff, format);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    private static String getFileExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return (index == -1) ? "" : filePath.substring(index + 1);
    }
}
