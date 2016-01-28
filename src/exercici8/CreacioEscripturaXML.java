package exercici8;



import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * Classe que crea i escriu un document XML mitjançant JAXP i API DOM
 * @author sergi grau
 * @version 1.0 11/02/2014
 * 
 * 8.Desenvolupa un programa que escrigui un document XML a partir dels diferents
tipus d'ingredients d'una recepta continguda en un altre document XML. També
ha de mostrar el nombre  d'unitats de cadascun d'ells. El DTD que  descriu una
recepta   és   el   següent.   Ha   d'utilitzar   l'API   JAXP,   mitjançant   el   model   de
tractament XML DOM
 * 
 * 
 * 
 */ 
public class CreacioEscripturaXML {
 
	public static void main(String argv[]) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		Document nodeDocument = docBuilder.newDocument();
		Element elementArrel = nodeDocument.createElement("empresa");
		nodeDocument.appendChild(elementArrel);
 
		Element treballador = nodeDocument.createElement("treballador");
		elementArrel.appendChild(treballador);
 
		treballador.setAttribute("id", "1");
 
		Element nom = nodeDocument.createElement("nom");
		nom.appendChild(nodeDocument.createTextNode("sergi"));
		treballador.appendChild(nom);
 
		Element cognom = nodeDocument.createElement("cognom");
		cognom.appendChild(nodeDocument.createTextNode("grau"));
		treballador.appendChild(cognom);
 
	
 
		Element sou = nodeDocument.createElement("salari");
		sou.appendChild(nodeDocument.createTextNode("100000"));
		treballador.appendChild(sou);
 
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource origen = new DOMSource(nodeDocument);
		StreamResult sortidaXML = new StreamResult(new File("empresa.xml"));
 
		
		transformer.transform(origen, sortidaXML);
 
		System.out.println("Desat!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}