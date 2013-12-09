/*package calcul;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*public class Tokenization {
	
	public static ArrayList<Token> tokenization(String requete){
		ArrayList<Token> tokens = new ArrayList<Token>();
		return tokens;
	}
}*/

package calcul;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Tokenization {

	public String request = null;

	public Tokenization(String prequest) {
		this.request = prequest;	

	}



	/*
	 Création de la liste d'objet token
	 Les token sont récupérer sans enlever les doublons et sans incrémenter les tf
	 */

	public ArrayList<Token> getListToken(String prequest) {
		StringTokenizer st = new StringTokenizer(prequest);
		ArrayList<Token> list = new ArrayList<Token>();
		String terme = null;
		int tf = 0;
		Token tk = new Token( terme , tf);
		while (st.hasMoreTokens()){			
			terme = st.nextToken();
			tk.setTerme(terme);
			tk.setTf(tf);
			list.add(new Token(terme,tf));
		}
		return list;

	}
	
	/*
	 Récupération des String de l'objet Token pour faciliter le traitement de doublons
	 */
	public  ArrayList<String> getListTerme(ArrayList<Token> list){	
		ArrayList<String> listTerme = new ArrayList<String>();
		for (int k=0; k<list.size(); k++){
			listTerme.add(list.get(k).getTerme());
		}
		return listTerme;		
	}	
	
	/*
	 Récupération des tf et des termes
	 */
	public ArrayList<Token> getFrequencyWithoutDuplicated(ArrayList<String> list) {
		Set<String> uniqueSet = new HashSet<String>(list);
		ArrayList<Token> listToken = new ArrayList<Token>();
		String terme= null;
		int tf = 0;
		Token tk = new Token(terme, tf);
		for (String temp : uniqueSet) {
			int freq = Collections.frequency(list, temp);
			terme = temp;
			tf =  freq;
			listToken.add(new Token(terme,tf));
		}
		return listToken;
	}
}