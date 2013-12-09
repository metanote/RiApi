package calcul;

import parsing.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import parsing.dictionary.Hashmap;
import parsing.fileparsers.NormalFileLoader;
import parsing.frontEnd.Resultat;
import parsing.frontEnd.Text_Struct;

public class Indexation {

	/*public static void main(String[] args) {
		 NormalFileLoader rf=new NormalFileLoader();
	        rf.spliteFile();
	        
	        //rf.readFile("C:/Users/hamida/work/RI/projet/fileDocs.txt");
	        
	        while (true){
	        	
	        	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    	    
	        	System.out.println("hello");
	        	System.out.println();
	        	try {
					String s = bufferRead.readLine();
					System.out.println(Hashmap.dico.size());
					try{
					System.out.println(Hashmap.search(s).toString());
					
					
					}catch(Exception ex){}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		
		
		
		//requete utilisé
		String request = "voiture bleu bleu voiture bleu";
		Tokenization tok = new Tokenization(request);	
		
		ArrayList<Token> listToken = tok.getListToken(request);
		ArrayList<String> listTerme = tok.getListTerme(listToken);
		ArrayList<Token> listTokenCount = tok.getFrequencyWithoutDuplicated(listTerme);
		
				
		for(int i = 0; i < listTokenCount.size(); i++){
			System.out.println("Test Java dans arraylist");
			System.out.println(listTokenCount.get(i).getTf()+" " + " " + listTokenCount.get(i).getTerme());
			
		}
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
		
		//ArrayList<Token> tokens= Tokenization.tokenization("voiture bleu chat");
		

	/*	
		ArrayList<Resultat> liste_resultats= new ArrayList<Resultat>();
		ArrayList<Integer> liste_tf_tokens= new ArrayList<Integer>();
		HashMap<Integer,Score> hm= new HashMap<Integer,Score>();
		*/ 
		/********ajout des données de test********
		liste_resultats.add(r1);
		liste_resultats.add(r2);
		liste_resultats.add(r3);
		 * @throws IOException 
		*********************/
	/*	for (int i = 0; i < listToken.size(); i++) {
			Token s = listToken.get(i);
			//liste_resultats.add(Search(s.getTerme()));
			//s.setTf(1);
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
		Collections.reverse(tab_score);
		System.out.println("RUN de la requête: " +request);
		for(Score score : tab_score){
			System.out.println(score.getId()+" avec un score de "+score.getScore());
		}
		
	}
	
	



}*/public static void main(String[] args){
	
    NormalFileLoader rf=new NormalFileLoader();
    rf.spliteFile();
    
    //rf.readFile("C:/Users/hamida/work/RI/projet/fileDocs.txt");
    
    while (true){
    	
    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    
    	System.out.println("hello");
    	
    	try {
			String request = bufferRead.readLine();
			System.out.println("On traite la requête: "+request);
			Tokenization tok = new Tokenization(request);	
			
			ArrayList<Token> listToken = tok.getListToken(request);
			ArrayList<String> listTerme = tok.getListTerme(listToken);
			ArrayList<Token> listTokenCount = tok.getFrequencyWithoutDuplicated(listTerme);
			
			System.out.println("Nos tokens sont les suivants:");
			for(int i = 0; i < listTokenCount.size(); i++){
				System.out.println("terme: "+listTokenCount.get(i).getTerme()+" tf:" + listTokenCount.get(i).getTf());
			}
			
			ArrayList<Resultat> liste_resultats= new ArrayList<Resultat>();
			ArrayList<Integer> liste_tf_tokens= new ArrayList<Integer>();
			HashMap<Integer,Score> hm= new HashMap<Integer,Score>();
			
			for (int i = 0; i < listTokenCount.size(); i++) {
				Token s = listTokenCount.get(i);
				System.out.println("beug: "+s.getTerme());
				liste_resultats.add(Hashmap.search(s.getTerme()));
				System.out.println("Resultat pour le token " + s.getTerme()+" : "+Hashmap.search(s.getTerme()).getTerme()+"de df: "+Hashmap.search(s.getTerme()).getIdf());
				System.out.println("La liste des docs associé est: ");
				for(int j=0; j < Hashmap.search(s.getTerme()).getResultats().size();j++){
					System.out.println("id : "+Hashmap.search(s.getTerme()).getResultats().get(j).getId()+" terme: "+ Hashmap.search(s.getTerme()).getResultats().get(j).getTerme()+" frequence: "+Hashmap.search(s.getTerme()).getResultats().get(j).getTf());
				}
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
					double smart_tf=0.0;
					if(t.getTf()==0){
						smart_tf=0.0;
					}
					else{
						smart_tf=1+ Math.log(NormalFileLoader.N/t.getTf());
					}
					if(hm.containsKey(id)){
						hm.get(id).incremente((Math.log(NormalFileLoader.N/r.getIdf()))*smart_tf*tf_token);
					}
					else{
						hm.put(id, new Score(id,(Math.log(NormalFileLoader.N/r.getIdf()))*smart_tf*tf_token));
					}
				}
			}

			Set<Integer> cles = hm.keySet();
			ArrayList<Score> tab_score=new ArrayList<Score>();
			for(Integer cle : cles){
				tab_score.add(hm.get(cle));
			}
			Collections.sort(tab_score);
			Collections.reverse(tab_score);
			System.out.println("RUN de la requête: " +request);
			int compteur=0;
			for(Score score : tab_score){
				compteur++;
				if(compteur==1501){
					break;
				}
				ecrire("C:/Users/Jordan/Desktop/Doc_aprentissage/Jordan/run.txt", "numero Q0 "+ score.getId()+" " +compteur+" " +score.getScore()+" BenLheJaaCha "+"/article[1]\n");
				System.out.println("numero Q0 "+ score.getId()+" " +compteur+" " +score.getScore()+" BenLheJaaCha "+"/article[1]");
			}
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

public static void ecrire(String nomFic, String texte)
{
	//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
	String adressedufichier = nomFic;

	//on met try si jamais il y a une exception
	try
	{
		/**
		 * BufferedWriter a besoin d un FileWriter, 
		 * les 2 vont ensemble, on donne comme argument le nom du fichier
		 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
		 
		 */
		FileWriter fw = new FileWriter(adressedufichier, true);
		
		// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
		BufferedWriter output = new BufferedWriter(fw);
		
		//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
		output.write(texte);
		//on peut utiliser plusieurs fois methode write
		
		output.flush();
		//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
		
		output.close();
		//et on le ferme
		System.out.println("fichier créé");
	}
	catch(IOException ioe){
		System.out.print("Erreur : ");
		ioe.printStackTrace();
		}

}
}

