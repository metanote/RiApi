import java.io.*;
import java.util.*;

public class ReadFile {

	public String[][] spliteFile() {
		String[][] lines = new String[8][8];
		try {
			InputStream flux = new FileInputStream(
					"/Users/moncef/Documents/test.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			String[] temp;

			int i = 0;
			while ((ligne = buff.readLine()) != null) {
				int n = 0;
				int j = 0;
				while (ligne != "</doc>") {
					String docno = "";

					if (ligne.contains("<doc><docno> ")) {
						docno = ligne.replace("<doc><docno> ", "");
						docno = docno.replace("</docno>", "");
						ligne = docno;
					}
					if(ligne.contains(" ")){
					temp = ligne.split(" ");
	
					n = ligne.split(" ").length;
					while (j < n) {
						lines[i][j] = temp[j];
						j++;
					}
					
					j += n ;
					}
					else
					{
						lines[i][j]=ligne;
						j++;
					}
					ligne =buff.readLine();
				}
				i++;

			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		for (int k = 0; k < lines.length; k++) {
			System.out.println();
			for (int j = 0; j < lines.length; j++)
				System.out.print(lines[k][j]+" ");
		}
		return lines;
	}

	// int l=0,c=0;
	// String[][] matrix;
	// ligne = buff.readLine();
	//
	// matrix[l][c]=docno;
	// ligne=buff.readLine();
	//

	// String key = ch.substring(0, ch.indexOf(" "));
	// System.out.println("le key " + key);
	// String nl = ch.replace(key + " ", "");
	// System.out.println("LE REST " + nl);
	// // map.add(key,nl);
	// tab = nl.split(" ");
	//
	// }
	// }
	//
	// else {
	// if (ligne.contains(" "))
	// tab = ligne.split(" ");
	// else {
	// int b = tab.length;
	// System.out.println(ligne);
	//
	// }
	//
	// }
	// for (int k = 0; k < tab.length; k++)
	// System.out.println(tab[k]);
	// }

	public static void readFile(String folder) {
		String contenu = "";
		try {
			InputStream ips = new FileInputStream(folder);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			String fileNo = "";
			Boolean newFile = false;
			// c'est le dossier destination pour mettre les fichiers splitter
			String TargetFolder = "/Users/moncef/Documents/";
			// Vidage du répertoire pour la réutilisation
			File TargetDir = new File(TargetFolder);
			// purgeDirectory(TargetDir);
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
					// CreateFile(TargetFolder + fileNo + ".txt", contenu);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erreur lecture du fichier!");
		}
	}

}
