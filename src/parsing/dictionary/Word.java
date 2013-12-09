package parsing.dictionary;

import java.util.LinkedList;

public class Word {
	int idf;
	String name;
	public Word (String name){
		
		this.idf = 1;
		this.name = name;
	}
	
	public LinkedList<Document> docs = new LinkedList<Document>();

	public int getIdf() {
		return idf;
	}
	public void setIdf(int idf) {
		this.idf = idf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
boolean containsDoc (String docId){
	
	for (Document d : docs){
		
		if (d.getDocId().equalsIgnoreCase(docId))
			return true;
	}
	
	return false;
}
@Override
public String toString (){
	
	String s = "\n\n-----------------------------------------\n"+this.getName()+"\n"+this.getIdf();
	
	return s+docs.toString();
}

}
