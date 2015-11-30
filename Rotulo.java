import java.io.*;



public class Rotulo {
	int numClass;
	String moviment;

	public Rotulo(int num, String mov){
		this.numClass = num;
		this.moviment = mov;
	}
	
	public void setNumClass(int num){ this.numClass = num; }
	public int getNumClass(){ return this.numClass; }

	public void setMoviment(String mov){ this.moviment = mov; }
	public String getMoviment(){ return this.moviment; }

	public String toString(){ return ("numClasse: " +  this.getNumClass() + "\tmovimento: " + this.getMoviment()); }
	
}
