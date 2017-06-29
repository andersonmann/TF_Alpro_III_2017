import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {

	public static void main(String[] args) throws IOException {

		Path caminho = Paths.get(System.getProperty("user.home"), "Downloads/TF_Alpro/input/F_1.txt");
		@SuppressWarnings("resource")
		Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
		linhas.forEach(System.out::println);

	}
}