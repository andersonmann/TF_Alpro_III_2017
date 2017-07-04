package pacote;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Reader {

	public static void main(String[] args) throws IOException {
		
		List<Integer> valores = Arrays.asList();

		//Path caminho = Paths.get(System.getProperty("user.home"), "Downloads/TF_Alpro/input/F_1.txt");		
		Path caminho = Paths.get("F_1");
		
		//@SuppressWarnings("resource")
		Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
		
		linhas.forEach(s -> System.out.println(s));
		
		linhas.close();
		//linhas.forEach(System.out::println);

	}
}