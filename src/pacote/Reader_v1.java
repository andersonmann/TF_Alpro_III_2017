package pacote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader_v1 {

	private int count = 0; 

	public void leSimulacao() throws IOException {

		try (BufferedReader buffer = new BufferedReader(new FileReader("F_17"))) {

			// Carrega os dados da arvore Canhota que consta no arquivo
			String linha = null;	// 1
			linha = buffer.readLine();	//2
			int arvoreEsquerda;
			arvoreEsquerda = Integer.parseInt(linha.toString()); //3
			int[] centraltE = new int[arvoreEsquerda + 1]; // 2
			count += 7; // 2 
			for (int i = 0; i < arvoreEsquerda; i++) { //3
				count ++;
				String le = null; // 1
				le = buffer.readLine(); // 2
				int nodo;
				int esquerdo;
				int central;
				nodo = Integer.parseInt(le.split(" ")[0]); // 3
				esquerdo = Integer.parseInt(le.split(" ")[1]); //3
				central = Integer.parseInt(le.split(" ")[2]); //3
				centraltE[nodo] = central; // 1
				count+=13;
			}

			// Carrega os dados da arvore Destra que consta no arquivo
			String novalinha;
			novalinha = buffer.readLine(); //2
			int arvoreDestra;
			arvoreDestra = Integer.parseInt(novalinha.toString()); //3
			int[] centraltD = new int[arvoreDestra + 1]; // 2
			count += 8;
			for (int i = 0; i < arvoreDestra; i++) {
				count++;
				String nodoD = null;
				nodoD = buffer.readLine();
				int nodo;
				int direito;
				int central;
				nodo = Integer.parseInt(nodoD.split(" ")[0]);
				central = Integer.parseInt(nodoD.split(" ")[1]);
				direito = Integer.parseInt(nodoD.split(" ")[2]);
				centraltD[nodo] = central;
				count+=13;
			}

			int[] visE = new int[arvoreEsquerda + 1];

			// Descobre o comprimento mais longo da árvore canhota
			int comprimentoCanhota = 0;
			int sDCcanhota = 0;
			count += 4;
			for (int i = 1; i <= arvoreEsquerda; i++) {
				if (visE[i] == 0) {
					count ++;
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
				count+=12;

			}
			// Descobre o comprimento mais longo da árvore destra
			int[] visD = new int[arvoreDestra + 1];
			int comprimentoDestra = 0;
			int sDCdestra = 0;
			count += 4;
			for (int i = 1; i <= arvoreDestra; i++) {
				count++;
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
				count+=12;

			}

			// Calcula qual vertice é mais satisfatório ser utilizado = o que
			// cobre maior numero de nodos centrais.
			int vert_sup = Math.max(Math.min(sDCcanhota, comprimentoDestra), Math.min(sDCdestra, comprimentoCanhota));
			count += 4;
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
