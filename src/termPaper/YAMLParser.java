package termPaper;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YAMLParser {

	public static void main(String[] args) throws IOException {
		URL exampleFile = JSONParser.class.getResource("example.json");
		Yaml yaml = new Yaml();

		Map root = (Map) yaml.load(exampleFile.openStream());
		Map billTo = (Map) root.get("bill-to");

		int invoiceNumber = (Integer) root.get("invoice");
		String lname = (String) billTo.get("lname");
		String fname = (String) billTo.get("fname");
		int uniqueItems = ((List) root.get("product")).size();
		double total = (Double) root.get("total");

		System.out.format("Details for invoice # %d\n", invoiceNumber);
		System.out.format("\tOrdered by %s, %s\n", lname, fname);
		System.out.format("\tThey ordered %d unique item(s)\n", uniqueItems);
		System.out.format("\tThey spent a total of $%.2f\n", total);

	}
}
