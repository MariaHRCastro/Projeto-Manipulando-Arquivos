package aplicativo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Individuo;

public class Programa {

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Individuo individuo = null;
		
		List <Individuo> individuos = new ArrayList<>();
		
		System.out.println("Digite o local do arquivo: ");
		String local = sc.next();
		File arquivo = new File(local);
		
		String parente = arquivo.getParent();
		
		String novoNome = parente+"\\dadosAtualizados.txt";
		
		File novoArquivo = new File(novoNome);
		
		novoArquivo.createNewFile();
		
		if (novoArquivo.exists()) {
			System.out.println("Sucesso na criação do novo arquivo!");
		}
		else {
			System.out.println("Falha na geração de um novo arquivo!");
		}
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo));
				BufferedWriter escrever = new BufferedWriter(new FileWriter(novoArquivo))){
			String linha = br.readLine();
			while (linha!=null) {
				String [] campos = linha.split(",");
				String nome = campos[0];
				String cpf = campos[1];
				String tel = campos[2];
				Integer idade = Integer.parseInt(campos[3]);
				
				individuo = new Individuo(nome, cpf, tel, idade);
				
				individuos.add(individuo);
				linha = br.readLine();
			}
			
			System.out.println();
			System.out.println("RELATÓRIO");
			escrever.write("RELATÓRIO:\n");
			for (Individuo i: individuos) {
				System.out.println(i);
				String texto = String.valueOf(i);
				escrever.write(texto+"\n");
				System.out.println();
			}
			System.out.println();
			System.out.println("Número de Indivíduos Cadastrados: "+individuos.size());
			System.out.println();
			
			Integer soma = 0;
			for (Individuo i:individuos) {
				if(i.getIdade()>18) {
					soma+= 1;
				}
			}
			System.out.println("Número de indivíduos maiores de idade: "+ soma);
			
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: Não foi possível encontrar o arquivo.");
		} catch (IOException e) {
			System.out.println("ERRO: "+ e.getMessage());
			
	}

		sc.close();
}
}
