import java.io.*;
import java.util.*;

public class ReadFile {

	public String[] spliteFile() {
		String[] rlt = new String[90];
		try {
			InputStream flux = new FileInputStream(
					"/Users/moncef/Documents/fileDos.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			String[] temp;
			
			int n = 0;
			int j = 0;
			String docno;
			while ((ligne = buff.readLine()) != null) {
				 if (ligne.trim().equals("")) {
			           ligne=buff.readLine(); 
			        }
				else{
				if (ligne.contains("<doc><docno>")) {
					docno = ligne.replace("<docno>", "");
					docno = docno.replace("</docno>", "");
					ligne = docno;
				}

				if (ligne.contains(" ")) {
					temp = ligne.split(" ");

					n = temp.length;
					System.out.println("Number of splits  " + n);

					int i = 0;
					while (i < n) {
						rlt[j] = temp[i];
						System.out.println("in if " + rlt[j]);
						i++;
						j++;
					}
				} else {
					rlt[j] = ligne;
					System.out.println("in else " + rlt[j]);
					j++;
				}
			}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return rlt;
	}

	public static void readFile(String folder) {
		String contenu = "";
		try {
			InputStream ips = new FileInputStream(folder);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			String fileNo = "";
			Boolean newFile = false;
			while ((ligne = br.readLine()) != null) {
				if (!newFile)
					contenu += ligne + "\n";

				else {
					contenu = "";
					newFile = false;
				}

			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erreur lecture du fichier!");
		}
	}

}
