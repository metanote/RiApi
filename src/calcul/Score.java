package calcul;

public class Score implements Comparable<Score>{
	
	private int id;
	private double score;
	private int compteur;
	
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public Score(int id, double score) {
		this.id = id;
		this.score = score;
		this.compteur=1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incremente(double valeur){
		this.score+=valeur;
		this.compteur+=1;
	}
	

	//Tri la liste des documents, ET Logique d'abord puis OU logique ensuite
	public int compareTo(Score score2) {
	      int resultat = 0;
	      /*if (this.score > score2.score)
	         resultat = 1;
	      if (this.score < score2.score)
	         resultat = -1;
	      if (this.score == score2.score)
	         resultat = 0;*/
	      if(this.compteur > score2.compteur){
		         resultat = 1;
	      }
		  if (this.compteur < score2.compteur){
		         resultat = -1;
		  }
		  if (this.compteur == score2.compteur){
			  if (this.score > score2.score)
			      resultat = 1;
			  if (this.score < score2.score)
			      resultat = -1;
			  if (this.score == score2.score)
				  resultat = 0;
		  }
		         
	      return resultat;
		
	}





}
