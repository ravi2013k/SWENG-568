package termPaper;

import java.io.IOException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONParser {

	public static void main(String[] args) throws IOException, JSONException {

		URL exampleFile = JSONParser.class.getResource("example.json");
		JSONTokener tokener = new JSONTokener(exampleFile.openStream());
		JSONObject root = new JSONObject(tokener);
		JSONObject billTo = (JSONObject) root.getJSONObject("bill-to");

		int invoiceNumber = root.getInt("invoice");
		String lname = billTo.getString("lname");
		String fname = billTo.getString("fname");
		int uniqueItems = root.getJSONArray("product").length();
		double total = root.getDouble("total");
		
		System.out.format("Details for invoice # %d\n", invoiceNumber);
		System.out.format("\tOrdered by %s, %s\n",lname, fname);
		System.out.format("\tThey ordered %d unique item(s)\n",uniqueItems);
		System.out.format("\tThey spent a total of $%.2f\n",total);
		
	}
}

