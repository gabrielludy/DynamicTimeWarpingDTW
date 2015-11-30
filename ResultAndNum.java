import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class ResultAndNum {
	int numClass;
	float result;

	public ResultAndNum(float res, int num){
		this.numClass = num;
		this.result = res;
	}


	public void setNumClass(int num){ this.numClass = num; }
	public int getNumClass(){ return this.numClass; }

	public void setResult(float res){ this.result = res; }
	public float getResult(){ return this.result; }

	
	public String toString(){
		String ret = null;

		ret += "numClass: " + this.numClass;
		ret += " result: " + this.result;
		ret += "  ";

		return ret;
	}
	

}
