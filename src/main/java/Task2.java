import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {

        List<NamedObject> namedObjects = List.of(
                () -> "obj1",
                () -> "obj2",
                () -> "obj3",
                () -> "obj3"
        );

        Grouper.groupByName(namedObjects);
    }

    @FunctionalInterface
    public interface NamedObject {
        String getName();
    }

    public static class Grouper {

        public static Map<String, List<NamedObject>> groupByName(Collection<NamedObject> namedObjects) {
            return namedObjects
                    .stream()
                    .collect(Collectors.groupingBy(NamedObject::getName));
        }
    }
}
