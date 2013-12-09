package calcul;

/*public class Token {
	private String terme;
	private int tf;
	
	
	
	public Token(String terme, int tf) {
		this.terme = terme;
		this.tf = tf;
	}
	public String getTerme() {
		return terme;
	}
	public void setTerme(String terme) {
		this.terme = terme;
	}
	public int getTf() {
		return tf;
	}
	public void setTf(int tf) {
		this.tf = tf;
	}
	
	
}*/


public class Token {

	//Terme = un mot de la requete
	// tf = terme frequency
	
	
	public Token(String terme, int tf) {
		
		this.Terme = terme;
		this.tf = tf;
	}

	public String Terme=null;
	public int tf=0;

	public String getTerme() {
		return Terme;
	}

	public void setTerme(String terme) {
		Terme = terme;
	}

	public int getTf() {
		return tf;
	}

	public void setTf(int tf) {
		this.tf = tf;
	}


}


