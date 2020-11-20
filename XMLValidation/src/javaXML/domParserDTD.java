package javaXML;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class domParserDTD {

	public static void main(String[] args) {
		domParserDTD obj = new domParserDTD();
		System.out.println("Validating  FatalDiseases.xml against DTD using DOM model: "+ obj.DTD_Validate("FatalDiseases.xml") );
		if(obj.DTD_Validate("FatalDiseases.xml")== "Validation Success") {
			
		}
	}
	
	public String DTD_Validate(String xmlPath) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		try {
			DocumentBuilder builder= factory.newDocumentBuilder();
			builder.setErrorHandler(new ErrorHandler() {
				@Override
			    public void error(SAXParseException exception) throws SAXException {
			        // do something more useful in each of these handlers
			        exception.printStackTrace();
			    }
			    @Override
			    public void fatalError(SAXParseException exception) throws SAXException {
			        exception.printStackTrace();
			    }

			    @Override
			    public void warning(SAXParseException exception) throws SAXException {
			        exception.printStackTrace();
			    }
			});
			try {
				Document doc = builder.parse(xmlPath);
				try {
					doc.getDocumentElement().normalize(); 
					System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
					NodeList nodeList = doc.getElementsByTagName("disease");								
					for (int i = 1; i <= nodeList.getLength(); i++)   
					{  
						Node node = nodeList.item(i-1);
						String nodeName= node.getNodeName();
						System.out.println("\nNode Name :" + nodeName);
						System.out.println(nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1)+" node's Attribute value: " +  node.getAttributes().item(0).getNodeValue());
						if(node.getNodeType()==Node.ELEMENT_NODE) {
							Element ele = (Element) node;  
							System.out.println("Originated From: "+ ele.getElementsByTagName("origin").item(0).getTextContent());  
							System.out.println("Death Toll: "+ ele.getElementsByTagName("fatality").item(0).getTextContent());  
							System.out.println("Pandemic Start Year: "+ ele.getElementsByTagName("startYear").item(0).getTextContent());  
						}
						
					}
				}catch(Exception e) {
					System.out.println("Error while reading XML document \n");
					e.printStackTrace();
				}							
			} catch (SAXException e) {
				e.printStackTrace();
				return "Validation failed";
			} catch (IOException e) {
				e.printStackTrace();
				return "Validation failed";
			}			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return "Validation failed";
		}
		return "Validation Success";	
	}
}
