package parsing;

public class Text_Struct {
	private int id;
	private String terme;
	private int tf;
	
	
	public Text_Struct(int id, String terme, int tf) {
		this.id = id;
		this.terme = terme;
		this.tf = tf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
