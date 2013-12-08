package parsing;

import java.util.ArrayList;

public class Resultat {
	private String terme;
	private int idf;
	private ArrayList<Text_Struct> resultats;
	
	
	
	public Resultat(String terme, int idf, ArrayList<Text_Struct> resultats) {
		this.terme = terme;
		this.idf = idf;
		this.resultats = resultats;
	}
	public String getTerme() {
		return terme;
	}
	public void setTerme(String terme) {
		this.terme = terme;
	}
	public int getIdf() {
		return idf;
	}
	public void setIdf(int idf) {
		this.idf = idf;
	}
	public ArrayList<Text_Struct> getResultats() {
		return resultats;
	}
	public void setResultats(ArrayList<Text_Struct> resultats) {
		this.resultats = resultats;
	}
	
}
