import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileWriter {

	public static void writePersonsToXML(Person[] personData) throws FileNotFoundException {
		XStream xstream = new XStream(new DomDriver());
		PrintWriter printWriter = new PrintWriter("data/Persons.xml");
		printWriter.println("<persons>");
		for (int i = 0; i < personData.length; i++) {
			String xml = xstream.toXML(personData[i]);
			printWriter.println(xml);
		}
		printWriter.println("</persons>");
		printWriter.close();
	}

	public static void writeAccountsToXML(Account[] accountData) throws FileNotFoundException {
		XStream xstream = new XStream(new DomDriver());
		PrintWriter printWriter = new PrintWriter("data/Assets.xml");
		printWriter.println("<assets>");
		for (int i = 0; i < accountData.length; i++) {
			String xml = xstream.toXML(accountData[i]);
			printWriter.println(xml);
		}
		printWriter.println("</assets>");
		printWriter.close();
	}
	
	public static void writePersonsToJson(Person[] personData) throws FileNotFoundException {

        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		PrintWriter printWriter = new PrintWriter("data/Persons.json");
		for (int i = 0; i < personData.length; i++) {
			String json = xstream.toXML(personData[i]);
			printWriter.println(json);
		}
		printWriter.close();
	}
	
	public static void writeAccountsToJson(Account[] accountData) throws FileNotFoundException {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		PrintWriter printWriter = new PrintWriter("data/Assets.json");
		for (int i = 0; i < accountData.length; i++) {
			String json = xstream.toXML(accountData[i]);
			printWriter.println(json);
		}
		printWriter.close();
	}

}
