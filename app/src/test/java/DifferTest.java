import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DifferTest {
    @Test
    public void testGenerateFlatJson() throws Exception {
        String file1 = Path.of("src", "test", "resources", "file1.json").toString();
        String file2 = Path.of("src", "test", "resources", "file2.json").toString();

        String actual = Differ.generate(file1, file2);

        assertTrue(actual.contains("- follow: false"));
        assertTrue(actual.contains("host: hexlet.io"));
        assertTrue(actual.contains("- proxy: 123.234.53.22"));
        assertTrue(actual.contains("- timeout: 50"));
        assertTrue(actual.contains("+ timeout: 20"));
        assertTrue(actual.contains("+ verbose: true"));
    }
    @Test
    public void testGenerateFlatYaml() throws Exception {
        String file1 = Path.of("src", "test", "resources", "file1.yml").toString();
        String file2 = Path.of("src", "test", "resources", "file2.yml").toString();

        String actual = Differ.generate(file1, file2);

        assertTrue(actual.contains("- follow: false"));
        assertTrue(actual.contains("host: hexlet.io"));
        assertTrue(actual.contains("- proxy: 123.234.53.22"));
        assertTrue(actual.contains("- timeout: 50"));
        assertTrue(actual.contains("+ timeout: 20"));
        assertTrue(actual.contains("+ verbose: true"));
    }
}
