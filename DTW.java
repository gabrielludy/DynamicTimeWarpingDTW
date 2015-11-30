import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;


/*
	verificar se os fors daqui e da main estao certos. e  descobrir como vou fazer pra desocbrir a classe a partir dos numeros da tabela. 
	descobrir o q eh o retorno da dtw
*/

public class DTW {
	ArrayList<Serie> qList;		//teste
	ArrayList<Serie> sList;		//treino

	public DTW(ArrayList<Serie> q, ArrayList<Serie> s){
		this.qList = q;
		this.sList = s;		
	}

	public void calculateDTW(){
		float hit = 0;
		float iteracoes = 0;

		for(int i=0; i < qList.size(); i++){				//para cada teste
			ArrayList<ResultAndNum> resAndNum = new ArrayList<ResultAndNum>();

			for(int j=0; j < sList.size(); j++){			//para comparar com um treino
				
				float result = calculateDTWaux(qList.get(i).getPontos(), sList.get(j).getPontos());

				resAndNum.add( new ResultAndNum(result, sList.get(j).getNumClass() ) );
//System.out.println("  result:"+result);
			}	


			//ordena em ordem crescente de results
			Collections.sort(resAndNum, new Comparator<ResultAndNum>() {
			        public int compare(ResultAndNum object1, ResultAndNum object2) {
			            return Float.compare(object1.getResult(), object2.getResult());
	        		}
			    }
			);


			//compara as classes
			if(resAndNum.get(0).getNumClass() == qList.get(i).getNumClass()){
				hit = hit+1;
			}

			iteracoes = iteracoes+1;
//System.out.println("hits:"+hit+" "+resAndNum.get(0).getNumClass()+" "+qList.get(i).getNumClass() + " iteracoes: "+iteracoes );

		}
System.out.println("hits:"+hit+" iteracoes:"+iteracoes );
		float hitPercentage = hit/iteracoes;

		System.out.println("hit percentage: " + hitPercentage);

//new java.util.Scanner(System.in).nextLine();
	}

	

	private float calculateDTWaux(ArrayList<Float> qPoints, ArrayList<Float> sPoints){
		float[][] dtwTable;
		float cost;
		dtwTable = new float[qPoints.size()+1][sPoints.size()+1];

		//System.out.println(Arrays.deepToString(dtwTable));

		//inicia tabela
		for(int i = 0; i <= qPoints.size(); i++){
			dtwTable[i][0] = Float.MAX_VALUE;
		}
		for(int i = 0; i <= sPoints.size(); i++){
			dtwTable[0][i] = Float.MAX_VALUE;	
		}

		dtwTable[0][0] = 0F;

		//preenche tabela
		for(int i=1; i <= qPoints.size(); i++){
			
			for(int j=1; j <= sPoints.size(); j++){

				dtwTable[i][j] = (qPoints.get(i-1) - sPoints.get(j-1)) * (qPoints.get(i-1) - sPoints.get(j-1)) + minimum(dtwTable[i-1][j], dtwTable[i][j-1], dtwTable[i-1][j-1]);

//System.out.println("dtwTable[i][j]: "+ minimum(dtwTable[i-1][j-1], dtwTable[i][j-1], dtwTable[i-1][j]) );
//System.out.println("minnn: "+ dtwTable[i-1][j-1]+"," +dtwTable[i][j-1]+","+ dtwTable[i-1][j]);
//new java.util.Scanner(System.in).nextLine();
			}
		}
		
//System.out.println(Arrays.deepToString(dtwTable));		
//System.out.println("return: "+dtwTable[qList.size()-1][sList.size()-1]+ ","+dtwTable[qList.size()][sList.size()]+","+dtwTable[1][1]);
//new java.util.Scanner(System.in).nextLine();

		return dtwTable[qPoints.size()][sPoints.size()];
	}

	private float minimum(float a, float b, float c) {
    	return Math.min( Math.min(a, b), c);
	}


}
