package madadata.interview.project;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;


public class Request {

	InputStream input;
	private HashMap <String, String> header = new HashMap<String, String>();
	
	
	public Request(InputStream input) {
		// TODO Auto-generated constructor stub
		this.input = input;
	}
	
	private String parseMethod() {
		return header.get("Method");
	}
	
	public boolean isGetMethod() {
		return "GET".equals(parseMethod());
	}
	
	
	public String getResourceUri() {
		return header.get("URI");
	}
	
	public void parse() {
		Scanner scanner = new Scanner(input);
		String tempHeaderLine = scanner.nextLine();
		parseRequestLine(tempHeaderLine);
		String [] temp = null;
		while (!"".equals(tempHeaderLine = scanner.nextLine())) {
			temp = tempHeaderLine.split(":");
			header.put(temp[0].trim(), temp[1].trim());
//			System.out.println(temp[0].trim());
//			System.out.println(temp[1].trim());
		}
		System.out.println("Request parsed success!");
//		scanner.close();
	}

	private void parseRequestLine(String requestLine) {

//		System.out.println(requestLine);
		String[] temp = requestLine.split(" ");
		header.put("Method", temp[0].trim());
		header.put("URI", temp[1].trim());
		header.put("Protocal", temp[2].trim());
//		System.out.println(header.get("URI"));
//		System.out.println(header.get("Method"));
//		System.out.println(header.get("Protocal"));
	}

}
