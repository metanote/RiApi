package calcul;

public class Token {
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
	
	
}
