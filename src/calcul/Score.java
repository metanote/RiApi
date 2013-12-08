package calcul;

public class Score implements Comparable<Score>{
	
	private int id;
	private int score;
	
	public Score(int id, int score) {
		this.id = id;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incremente(int valeur){
		this.score+=valeur;
	}
	


	public int compareTo(Score score2) {
	      int resultat = 0;
	      if (this.score > score2.score)
	         resultat = 1;
	      if (this.score < score2.score)
	         resultat = -1;
	      if (this.score == score2.score)
	         resultat = 0;
	      return resultat;
		
	}





}
