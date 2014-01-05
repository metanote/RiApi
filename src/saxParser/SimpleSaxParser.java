package saxParser;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SimpleSaxParser {

        /**
         * Contructeur.
         * @throws SAXException 
         * @throws IOException 
         */
     //   public SimpleSaxParser(String uri) throws SAXException, IOException {
        	  public static void main(String[] args) throws SAXException, IOException {
                        
        	XMLReader saxReader = XMLReaderFactory.createXMLReader();
                        saxReader.setContentHandler(new SimpleContentHandler());
                        saxReader.parse("/Users/moncef/Documents/test.xml");
        
        	  }
}