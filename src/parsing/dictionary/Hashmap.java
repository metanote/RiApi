package parsing.dictionary;

import java.util.ArrayList;
import java.util.HashMap;

import parsing.frontEnd.Resultat;
import parsing.frontEnd.Text_Struct;

public class Hashmap {

public static HashMap <String, Word> dico = new HashMap <String, Word>();


public static boolean add_word (Word word, String docId){
	
	
	if (exists (word)){
		
		incrementWordNewDoc(word);
	
			
	}else {
		
		dico.put(word.getName(),word);
	}
	
	
	
	return false;
}
public static void incrementWordNewDoc (Word word){
	
	dico.get(word.getName()).docs.addAll(word.docs);
	dico.get(word.getName()).idf += word.idf;
}

public static void incrementWord (Word word, Document doc){
	
	dico.get(word.getName()).docs.get(dico.get(word.getName()).docs.size()-1).tf++;
	
}
private static  boolean exists (Word word){
	
	if (dico.containsKey(word.getName()))
		return true;
	else
		return false;
}
@Override
public String toString (){
	String s = "";
	for (Word w : dico.values()){
		s.concat(w.toString());
		s.concat("*****************************************");
	}
	return s;
}

public static Resultat search (String term) {
	Word resultat = dico.get(term);
	ArrayList<Text_Struct> res = new ArrayList<Text_Struct>();
	for(Document d : resultat.docs)
		res.add(new Text_Struct (Integer.parseInt(d.docId),term,d.getTf()));
	return new Resultat(term, resultat.idf,res);
	
	
}
}
