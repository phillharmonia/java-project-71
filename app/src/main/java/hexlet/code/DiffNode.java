package hexlet.code;

public record DiffNode(String key, Status status, Object value1, Object value2)  {
    public enum Status {
        ADDED, REMOVED, CHANGED, UNCHANGED
    }
}
