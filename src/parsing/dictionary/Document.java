package parsing.dictionary;

public class Document {


String docId;
public int tf;

public Document (String docId){
	this.tf = 1;
	this.docId = docId;
}

public String getDocId() {
	return docId;
}
public void setDocId(String docId) {
	this.docId = docId;
}
public int getTf() {
	return tf;
}
public void setTf(int tf) {
	this.tf = tf;
}

public String toString (){
	return "\nDocument : "+this.docId+"/"+this.tf+"\n";
}
}
