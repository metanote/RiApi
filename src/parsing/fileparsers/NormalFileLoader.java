package parsing.fileparsers;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import parsing.dictionary.Document;
import parsing.dictionary.Hashmap;
import parsing.dictionary.Word;

public class NormalFileLoader {

	public static int N=0;
	String docId = "";
	HashMap <String,Word> miniDico= new HashMap<String,Word>();
	boolean first = true;
        public  void spliteFile() {
                try {
                        InputStream flux = new FileInputStream(
                                        "C:/Users/Jordan/Documents/texte.txt");
                        InputStreamReader lecture = new InputStreamReader(flux);
                        BufferedReader buff = new BufferedReader(lecture);
                        String ligne;
                       
                        StopWords.Read();
                        while ((ligne = buff.readLine()) != null ) {
                                String ch = "";
                                
                                //HashMap map =new HachMap();
                                if (ligne.contains("<docno>")) {
                                	
                                	this.N++;
                                	first = false;
                                        ch = ligne.replace("<doc>", "");
                                        ch = ch.replace("</docno>", "");
                                        ch = ch.replace("<docno>", "");
                                        System.out.println("ch:"+ch);
                                        String key = ch.trim();
                                        System.out.println("le key " + key);
                                        docId = key;
                                        String nl = ch.replace(key , "");
                                        
                                        System.out.println("LE REST " + nl);
                                        
                                        //map.add(key,nl);
                                        String[] s = nl.split("[^a-zA-Z0-9]");
                                        
                                        for (int i=0;i<s.length; i++){
                                        	s[i] = s[i].toLowerCase();
                                        	s[i] = s[i].trim();
                                        	if (s[i].length()>2 && !StopWords.stopWords.contains(s[i])){
                                        	if(!miniDico.containsKey(s[i])){
                                        		Word toAdd = new Word(s[i]);
                                        		toAdd.docs.add(new Document (docId));
                                        		
                                        	miniDico.put(s[i], toAdd);
                                        	System.out.println("**********"+s[i]+"**********");
                                        	}
                                        	else
                                        		miniDico.get(s[i]).docs.get(miniDico.get(s[i]).docs.size()-1).tf++;
                                        		
                                        }
                                        }
                                        addWords();
                                        miniDico.clear();
                                        
                                }

                                else {
                                        if (ligne.matches(".*[^a-zA-Z0-9].*")){
                                              
                                                String[] s =  ligne.split("[^a-zA-Z0-9]");
                                                for (int i=0;i<s.length; i++){
                                                	s[i] = s[i].toLowerCase();
                                                	s[i] = s[i].trim();
                                                	 if (s[i].length()>2 && !StopWords.stopWords.contains(s[i])){
                                                         if(!miniDico.containsKey(s[i].trim())){
                                                     		Word toAdd = new Word(s[i].trim());
                                                     		toAdd.docs.add(new Document (docId));
                                                     	miniDico.put(s[i], toAdd);
                                                     	System.out.println("------------"+s[i]+"-------------");
                                                     	}
                                                     	else
                                                     		miniDico.get(s[i].trim()).docs.get(miniDico.get(s[i].trim()).docs.size()-1).tf++;
                                                         }
                                                }
                                        }
                                        else if (!ligne.trim().equals("")){
                                        	
                                                
                                                ligne = ligne.toLowerCase();
                                                ligne = ligne.trim();
                                                if (ligne.length()>2 && !StopWords.stopWords.contains(ligne)){
                                                if(!miniDico.containsKey(ligne.trim())){
                                            		Word toAdd = new Word(ligne.trim());
                                            		toAdd.docs.add(new Document (docId));
                                            	miniDico.put(ligne.trim(), toAdd);
                                            	System.out.println("+++++++++"+ligne+"++++++++");
                                            	}
                                            	else
                                            		miniDico.get(ligne.trim()).docs.get(miniDico.get(ligne.trim()).docs.size()-1).tf++;
                                                }
                                        }

                                }
                                
                                
                                
                        }
                        addWords();
                        miniDico.clear();
                        buff.close();
                } catch (Exception e) {
                        System.out.println(e.toString());
                        e.printStackTrace();
                }
        }

        public void readFile(String folder) {
                String contenu = "";
                InputStream ips = null;
                try {
                		System.out.println(folder);
                         ips = new FileInputStream(folder);
                
                     
                        
						
						InputStreamReader ipsr = new InputStreamReader(ips);
                        BufferedReader br = new BufferedReader(ipsr);
                        String ligne;
                        String fileNo = "";
                        Boolean newFile = false;
                        // c'est le dossier destination pour mettre les fichiers splitter
                        String TargetFolder = "C:/Users/hamida/work/RI/projet";
                        // Vidage du répertoire pour la réutilisation
                        
                        File TargetDir = new File(TargetFolder);
                        //purgeDirectory(TargetDir);
                        
                        while ((ligne = br.readLine()) != null) {
                        	
                                if (!newFile)
                                        contenu += ligne + "\n";
                                
                                else {
                                        contenu = "";
                                        newFile = false;
                                }
                                // récupperation du docno qui sera nom de fichier
                                if (ligne.toLowerCase().contains("<docno>")) {
                                        fileNo = ligne.replaceAll("<doc><docno>", "");
                                        fileNo = fileNo.replaceAll("</docno>", "");
                                        // System.out.println(fileNo);
                                }
                                // Creation du nouveau Fichier fileNo.txt
                                if (ligne.toLowerCase().contains("</doc>")) {
                                        newFile = true;
                //                        CreateFile(TargetFolder + fileNo + ".txt", contenu);
                                }
                        }
                        br.close();
                } catch (Exception e) {
                	e.printStackTrace();
                        System.out.println("Erreur lecture du fichier!");
                }
        }
public void addWord(ArrayList<String> words, String docID){
	
	for (String s : words){
		
	}
	
	
}
public void addWords(){
	
	for (Word w : miniDico.values())
		Hashmap.add_word(w, docId);
}
}