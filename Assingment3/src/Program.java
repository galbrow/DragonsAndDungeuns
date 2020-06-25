import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        try {
            List<String> levelFiles=Files.list(Paths.get(args[0])).sorted().map(Path::toString).collect(Collectors.toList());
            for(String levelPath: levelFiles) {
                List<String> levelData = Files.readAllLines(Paths.get(levelPath));
                for (String s :levelData)
                    System.out.println(s);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
