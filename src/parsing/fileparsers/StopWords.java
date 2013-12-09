package parsing.fileparsers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class StopWords {
public static LinkedList <String> stopWords = new LinkedList<String>();
private static BufferedReader buff;
public static void Read(){
	InputStream flux;
	try {
		flux = new FileInputStream("C:/Users/Jordan/Documents/stop.txt");
		InputStreamReader lecture = new InputStreamReader(flux);
		buff = new BufferedReader(lecture);
		String ligne;
		 while ((ligne = buff.readLine()) != null ) {
			 stopWords.add(ligne.trim());
			 
		 }
		 
		 buff.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

}
