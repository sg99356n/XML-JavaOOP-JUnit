package javaXML;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domParserSchema {

	public static String validateSchemaDOM(String schemaPath, String xmlPath) {
		try {

			// Create SchemaFactory and parse xsd file to the schema object
			SchemaFactory sch_factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema= sch_factory.newSchema(new File(schemaPath));
			
			//Validate schema and xml files
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));				
		}
		//Return Success message if validation is successfull, else return failure message
		catch(Exception e) {	
			e.printStackTrace();
			return "Validation Fail";
		}
		
		try {
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder builder = factory.newDocumentBuilder();
			 Document doc = builder.parse(xmlPath);
			
				doc.getDocumentElement().normalize(); 
				System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
				NodeList nodeList = doc.getElementsByTagName("tns:disease");								
				for (int i = 1; i <= nodeList.getLength(); i++)   
				{  
					Node node = nodeList.item(i-1);
					String nodeName= node.getNodeName();
					System.out.println("\nNode Name :" + nodeName);
					System.out.println(nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1)+" node's Attribute value: " +  node.getAttributes().item(0).getNodeValue());
					if(node.getNodeType()==Node.ELEMENT_NODE) {
						Element ele = (Element) node;  
						System.out.println("Originated From: "+ ele.getElementsByTagName("tns:origin").item(0).getTextContent());  
						System.out.println("Death Toll: "+ ele.getElementsByTagName("tns:fatality").item(0).getTextContent());  
						System.out.println("Pandemic Start Year: "+ ele.getElementsByTagName("tns:startYear").item(0).getTextContent());  
					}
					
				}
			}catch(Exception e) {
				System.out.println("Error while reading XML document \n");
				e.printStackTrace();
			}
		
		return "Validation Success";
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Validating FatalDiseasesSchema.xsd with FatalDiseasesSchema.xml using DOM model: "+ validateSchemaDOM("FatalDiseaseSchema.xsd", "FatalDiseasesSchema.xml") );
	}

	
}
