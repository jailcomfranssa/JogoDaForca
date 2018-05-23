package Pacote;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class jogoDaForca {
//	private String [] palavra; // um  array  com  as  n  palavras  (lidas  do  arquivo)      
//	private String [] diga; //    um  array  com  as  n  dicas  (lidas  do  arquivo) 
	private int quantPalavra = 0;  // quantidade  de  palavras  do  arquivo  (lido  do  arquivo) 
	private int sorte = -1; // índice  da  palavra  sorteadado  jogo 
	private int acertos; // total de acerto do jogo
	private int erros; // total de erros do jogo
	private int indcPalavra;
	private String arquivo,palavraSort,dicaSort;
	private ArrayList<String> palavras =new ArrayList<>();
	private ArrayList<String> dica =new ArrayList<>();
	
	
	public jogoDaForca(String n) {
		arquivo = n;
	
		try {		
			Scanner arq=new Scanner( new File(arquivo));
			String texto;
			double total, soma=0;
			String[] colunas;
			while(arq.hasNextLine()) {
				quantPalavra = quantPalavra+1; // conta o numero de palavra no arquivo
				texto = arq.nextLine();
				colunas = texto.split(";");
				palavras.add(colunas[0]);
				dica.add(colunas[1]);					
			}			
//				System.out.println(palavras);
//				System.out.println(dica);
				//System.out.println(quantPalavra);			
			arq.close();
			
		} catch (Exception e) {
			System.out.println("arquivo inexistente");
			System.exit(0);	
		}
		
	}
	
	public void inicializar() {
		
		acertos = 0;
		erros = 0;
		Random randon = new Random();
		indcPalavra = randon.nextInt(quantPalavra);
		
		//System.out.println(indcPalavra);
		
		palavraSort=  palavras.get(indcPalavra); // sorteia a palavra
		dicaSort=  dica.get(indcPalavra);        // soteia a dica da palavra
	 
//	 System.out.println(palavraSort);
//	 System.out.println(dicaSort);
	}
	
	public int[] jogar(String letra) {
		
		int indec[] = null, j = 0,tamanho=0,flag=0;
		String copy = new String(palavraSort);
		
		for(int i =0;i<palavraSort.length();i++) {
			if(copy.substring(i,i+1).equals(letra)) {
				acertos++;
				tamanho++;
				flag=1;
				indec=new int[tamanho];		
			}
		}
		for(int i=0;i<copy.length();i++) {
			if(copy.substring(i,i+1).equals(letra)) {
				indec[j]=i+1;
				j++;	
			}
		}
		if(flag == 0) {
			erros++;
		}
		
		//System.out.println(palavraSort=palavraSort.replaceAll(letra,"#"));
		palavraSort=palavraSort.replace(letra,"#");
		return indec;
	}
	
	public  boolean  advinhar(String  palavra) {
		if(palavraSort.equals(palavra)) {
			return true;
		}
		else {
			return false;			
		}	
	}
	public  int  getTamanho() {
		int tamanho = palavraSort.length();
		return tamanho;
	}
	public  int  getAcertos() {
		return acertos;
	}
	public  int  getErros() {
		return erros;
	}
	public  String  getDica() {
		return dicaSort;
	}
	public String getPalavraSort() {
		return palavraSort;
	}	
}