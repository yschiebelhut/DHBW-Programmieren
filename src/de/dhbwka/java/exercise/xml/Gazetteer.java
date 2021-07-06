package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Yannik Schiebelhut
 */
public class Gazetteer {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder parser = null;
		try {
			parser = factory.newDocumentBuilder();
			Document doc = parser.parse(new File("src/de/dhbwka/java/exercise/xml/data.xml"));

			Element geocodeResponse = doc.getDocumentElement();
			Element result = (Element) geocodeResponse.getElementsByTagName("result").item(0);
			Node formatted_address = result.getElementsByTagName("formatted_address").item(0);
			System.out.printf("Adresse: %s\n", formatted_address.getTextContent());

			NodeList elements = result.getElementsByTagName("address_component");
			String long_name = "";
			for(int i = 0; i<elements.getLength();i++) {
				Node type = ((Element) elements.item(i)).getElementsByTagName("type").item(0);
				if (type.getTextContent().equals("locality")) {
					long_name = ((Element) elements.item(i)).getElementsByTagName("long_name").item(0).getTextContent();
					break;
				}
			}
			System.out.printf("Long Name: %s\n", long_name);

			Element geometry = (Element) result.getElementsByTagName("geometry").item(0);
			{
				Element location = (Element) geometry.getElementsByTagName("location").item(0);
				String lat = location.getElementsByTagName("lat").item(0).getTextContent();
				String lng = location.getElementsByTagName("lng").item(0).getTextContent();
				System.out.printf("Location: (latitude=%s, longitude=%s)\n", lat, lng);
			}
			Element bounds = (Element) geometry.getElementsByTagName("bounds").item(0);
			{
				Element location = (Element) bounds.getElementsByTagName("northeast").item(0);
				String lat = location.getElementsByTagName("lat").item(0).getTextContent();
				String lng = location.getElementsByTagName("lng").item(0).getTextContent();
				System.out.printf("Bounds: (east=%s, north=%s", lng, lat);
			}
			{
				Element location = (Element) bounds.getElementsByTagName("southwest").item(0);
				String lat = location.getElementsByTagName("lat").item(0).getTextContent();
				String lng = location.getElementsByTagName("lng").item(0).getTextContent();
				System.out.printf(", west=%s, south=%s)\n", lng, lat);
			}
		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}
	}
}
