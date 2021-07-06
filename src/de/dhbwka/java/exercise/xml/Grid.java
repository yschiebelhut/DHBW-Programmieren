package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.logging.StreamHandler;

/**
 * @author Yannik Schiebelhut
 */
public class Grid {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.newDocument();
			Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
			Element document = doc.createElement("Document");

			double startX = 49.024897;
			double startY = 8.385401;
			double distance = 0.05;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					Element placemark = doc.createElement("Placemark");
					Element name = doc.createElement("name");
					name.setTextContent(String.format("Point (%d,%d)", i, j));
					placemark.appendChild(name);

					Element des = doc.createElement("description");
					des.setTextContent(String.format("Point (%d,%d)", i, j));
					placemark.appendChild(des);

					Element point = doc.createElement("Point");
					Element coords = doc.createElement("coordinates");
					coords.setTextContent(String.format("%f,%f", startY + distance * i, startX + distance * j));
					point.appendChild(coords);
					placemark.appendChild(point);

					document.appendChild(placemark);
				}
			}

			kml.appendChild(document);
			doc.appendChild(kml);

			TransformerFactory tFactory = TransformerFactory.newInstance();
			tFactory.setAttribute("indent-number", 4);

			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File("src/de/dhbwka/java/exercise/xml/foo.kml"));
			transformer.transform(source, result);
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}
