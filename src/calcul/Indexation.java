package calcul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import parsing.Resultat;
import parsing.Text_Struct;

public class Indexation {

	public static void main(String[] args) {
		/****Jeu de test*****
		
		ArrayList<Text_Struct> struct=new ArrayList<Text_Struct>();
		struct.add(new Text_Struct(5,"voiture",2));
		Resultat r1=new Resultat("voiture",2,struct);
		
		ArrayList<Text_Struct> struct2=new ArrayList<Text_Struct>();
		struct2.add(new Text_Struct(5,"chat",3));
		Resultat r2=new Resultat("chat",2,struct2);
		
		ArrayList<Text_Struct> struct3=new ArrayList<Text_Struct>();
		struct3.add(new Text_Struct(1,"bleu",4));
		Resultat r3=new Resultat("bleu",2,struct3);
		
		*************************/
		
		
		/**********Token de test************
		//ArrayList<Token> tokens=new ArrayList<Token>();
		tokens.add(new Token("voiture",10));
		tokens.add(new Token("chat",1));
		tokens.add(new Token("bleu",1));
		*********************/
		
		ArrayList<Token> tokens= Tokenization.tokenization("voiture bleu chat");
		

		
		ArrayList<Resultat> liste_resultats= new ArrayList<Resultat>();
		ArrayList<Integer> liste_tf_tokens= new ArrayList<Integer>();
		HashMap<Integer,Score> hm= new HashMap<Integer,Score>();
		 
		/********ajout des données de test********
		liste_resultats.add(r1);
		liste_resultats.add(r2);
		liste_resultats.add(r3);
		*********************/
		for (int i = 0; i < tokens.size(); i++) {
			Token s = tokens.get(i);
		//	liste_resultats.add(Search(s.getTerme())); problem with search method 
			liste_tf_tokens.add(s.getTf());
		}
		
		for (int i = 0; i < liste_resultats.size(); i++) {
			Resultat r = liste_resultats.get(i);
			int tf_token=liste_tf_tokens.get(i);
			ArrayList<Text_Struct> liste_doc = r.getResultats();
			for (int j = 0; j < liste_doc.size(); j++) {
				Text_Struct t = liste_doc.get(j);
				int tf=t.getTf();
				int id=t.getId();
				if(hm.containsKey(id)){
					hm.get(id).incremente(r.getIdf()*t.getTf()*tf_token);
				}
				else{
					hm.put(id, new Score(id,r.getIdf()*t.getTf()*tf_token));
				}
			}
		}

		Set<Integer> cles = hm.keySet();
		ArrayList<Score> tab_score=new ArrayList<Score>();
		for(Integer cle : cles){
			tab_score.add(hm.get(cle));
		}
		Collections.sort(tab_score);
		
		for(Score score : tab_score){
			System.out.println(score.getId()+" avec un score de "+score.getScore());
		}
		
	}
	
	



}
