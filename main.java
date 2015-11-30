import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class main {

	public static void main(String[] args){
		
		ArrayList<Rotulo> rotulosList;
		ArrayList<Serie> treinoList;
		ArrayList<Serie> testeList;

		//cria lista de rotulos
		//rotulosList = buildRotuloList("rotulos3D.txt");
		rotulosList = buildRotuloList("rotulos.txt");


		//cria lista de treino
		//treinoList = buildSerieList("treino3D.txt");
		treinoList = buildSerieList("treino.txt");

		//cria lista de teste
		//testeList = buildSerieList("teste3D.txt");
		testeList = buildSerieList("teste.txt");


		//faz o DTW
long startTime = System.currentTimeMillis();		
		DTW dtw = new DTW(testeList, treinoList);
		dtw.calculateDTW();
long stopTime = System.currentTimeMillis();
long elapsedTime = stopTime - startTime;
System.out.println("tempo de execução: "+elapsedTime+" ms");
	}


	public static ArrayList<Rotulo> buildRotuloList(String fileName){
		int i, numClass;
		String line, data[], moviment;
		ArrayList<Rotulo> rotulos = new ArrayList<Rotulo>();
		

		File file = new File(fileName);
	
		try{
		
			Scanner scanner = new Scanner(file);

			for(i = 0; i < 12; i++){		//esta setado como padrao que tem 12 rotulos

				line = scanner.nextLine();
				data = line.split("\t");
				numClass = Integer.parseInt(data[0]);
				moviment = data[1];

				Rotulo novoRotulo = new Rotulo(numClass, moviment);

				rotulos.add(novoRotulo);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir o arquivo");
		}

		return rotulos;
	}

	public static ArrayList<Serie> buildSerieList(String fileName){
		int numClass;
		String line, data[];
		ArrayList<Serie> serieList = new ArrayList<Serie>();

		File file = new File(fileName);
	
		try{

			Scanner scanner = new Scanner(file);

			while(scanner.hasNext()){
				ArrayList<Float> pontos = new ArrayList<Float>();

				//le a classe
				line = scanner.nextLine();
				data = line.split(" ");
				numClass = Integer.parseInt(data[0]);

				//le os pontos
				for(int i = 1; i < data.length; i++){
					pontos.add( Float.parseFloat( data[i] ) );				
				}

				Serie newLineSerie = new Serie(numClass, pontos);
				serieList.add(newLineSerie);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir o arquivo");
		}



//para conferir
/*

		for(int i = 0; i < list.size(); i++){
			System.out.println("Serie " + i + ": ");
			System.out.println("NumClass: " + list.get(i).getNumClass());

			System.out.print("Pontos: ");

			for(int k = 0; k < list.get(i).getPontos().size(); k++) {

				System.out.print(list.get(i).getPontos().get(k) +" ");
			
			}
					
			System.out.println();
		}	
*/

		return serieList;
	}

}
