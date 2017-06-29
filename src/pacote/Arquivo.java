package pacote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

	private int count = 0;

	public void leSimulacao() throws IOException {

		try (BufferedReader buffer = new BufferedReader(new FileReader("F_25"))) {

			// Carrega os dados da arvore Canhota que consta no arquivo
			String linha = null;
			linha = buffer.readLine();
			int arvoreEsquerda;
			arvoreEsquerda = Integer.parseInt(linha.toString());
			int[] centraltE = new int[arvoreEsquerda + 1];
			count += 11;
			for (int i = 0; i < arvoreEsquerda; i++) {
				count += 17;
				String le = null;
				le = buffer.readLine();
				int nodo;
				int esquerdo;
				int central;
				nodo = Integer.parseInt(le.split(" ")[0]);
				esquerdo = Integer.parseInt(le.split(" ")[1]);
				central = Integer.parseInt(le.split(" ")[2]);
				centraltE[nodo] = central;
			}

			// Carrega os dados da arvore Destra que consta no arquivo
			String novalinha;
			novalinha = buffer.readLine();
			int arvoreDestra;
			arvoreDestra = Integer.parseInt(novalinha.toString());
			int[] centraltD = new int[arvoreDestra + 1];
			count += 8;
			for (int i = 0; i < arvoreDestra; i++) {
				count += 17;
				String nodoD = null;
				nodoD = buffer.readLine();
				int nodo;
				int direito;
				int central;
				nodo = Integer.parseInt(nodoD.split(" ")[0]);
				central = Integer.parseInt(nodoD.split(" ")[1]);
				direito = Integer.parseInt(nodoD.split(" ")[2]);
				centraltD[nodo] = central;
			}

			int[] visE = new int[arvoreEsquerda + 1];

			// Descobre o comprimento mais longo da árvore canhota
			int comprimentoCanhota = 0;
			int sDCcanhota = 0;
			count += 7;
			for (int i = 1; i <= arvoreEsquerda; i++) {
				if (visE[i] == 0) {
					count += 21;
					int ccomprimentoCanhota = 0;
					int cur = i;
					visE[cur] = 1;
					while (centraltE[cur] != 0) {
						cur = centraltE[cur];
						ccomprimentoCanhota++;
						visE[cur] = 1;
					}
					comprimentoCanhota = Math.max(comprimentoCanhota, ccomprimentoCanhota);
					if (i == 1) {
						sDCcanhota = ccomprimentoCanhota;
					}
				}

			}
			// Descobre o comprimento mais longo da árvore destra
			int[] visD = new int[arvoreDestra + 1];
			int comprimentoDestra = 0;
			int sDCdestra = 0;
			count += 7;
			for (int i = 1; i <= arvoreDestra; i++) {
				count += 21;
				if (visD[i] == 0) {
					int ccomprimentoDestra = 0;
					int cur = i;
					visD[cur] = 1;
					while (centraltD[cur] != 0) {
						cur = centraltD[cur];
						ccomprimentoDestra++;
						visD[cur] = 1;
					}
					comprimentoDestra = Math.max(comprimentoDestra, ccomprimentoDestra);
					if (i == 1) {
						sDCdestra = ccomprimentoDestra;
					}
				}

			}

			// Calcula qual vertice é mais satisfatório ser utilizado = o que
			// cobre maior numero de nodos centrais.
			int vert_sup = Math.max(Math.min(sDCcanhota, comprimentoDestra), Math.min(sDCdestra, comprimentoCanhota));
			count += 9;
			System.out.print(arvoreEsquerda + arvoreDestra - vert_sup - 1);
			System.out.print("\n");
			System.out.println("Contador: " + count);

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
			System.exit(1);
		}
	}

}
