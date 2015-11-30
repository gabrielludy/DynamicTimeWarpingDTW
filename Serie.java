import java.io.*;
import java.util.ArrayList;

public class Serie {
	int numClass;
	ArrayList<Float> pontos;

	public Serie(int num, ArrayList<Float> pts){
		this.numClass = num;
		this.pontos = pts;
	}


	public void setNumClass(int num){ this.numClass = num; }
	public int getNumClass(){ return this.numClass; }

	public ArrayList<Float> getPontos(){
		return this.pontos;
	}

}
