import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

public class ReadFile {

	public static void spliteFile() {
		try {
			InputStream flux = new FileInputStream(
					"/Users/moncef/Documents/fileDocs.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;

			String[] tab = new String[3000];
			while ((ligne = buff.readLine()) != null) {
				String ch = "";
				//HashMap map =new HachMap();
				if (ligne.contains("<doc><docno>")) {
					ch = ligne.replace("<doc><docno>", "");
					ch = ch.replace("</docno>", "");
					String key = ch.substring(0, ch.indexOf(" "));
					System.out.println("le key " + key);

					String nl = ch.replace(key + " ", "");
					System.out.println("LE REST " + nl);
					//map.add(key,nl);
					tab = nl.split(" ");

				}

				else {
					if (ligne.contains(" "))
						tab = ligne.split(" ");
					else {
						int b = tab.length;
						System.out.println(ligne);
						

					}

				}
				for (int k = 0; k < tab.length; k++)
					System.out.println(tab[k]);
			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
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
			// c'est le dossier destination pour mettre les fichiers splitter
			String TargetFolder = "/Users/moncef/Documents/";
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
		//			CreateFile(TargetFolder + fileNo + ".txt", contenu);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erreur lecture du fichier!");
		}
	}

}
