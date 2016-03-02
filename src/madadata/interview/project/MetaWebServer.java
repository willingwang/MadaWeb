package madadata.interview.project;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MetaWebServer {

	private static final String WEBROOT = System.getProperty("user.dir")+System.getProperty("file.separator")+"Webcontent";
	private static HashMap<String, String> contentType = new HashMap<String, String>();

	
	public static void main(String [] args) throws IOException {
//		System.out.println(WEBROOT);
//		System.out.println(System.getProperty("user.dir"));
		setContentType();
		ServerSocket serverSocket = new ServerSocket(10002);
		System.out.println("MetaWebServer is running on port: " + serverSocket.getLocalPort());
		while(true) {
			Socket socket = serverSocket.accept();
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			Request request = new Request(input);	
			request.parse();
			Response response = new Response(request, output);
			ExecutorService es = Executors.newCachedThreadPool();
			es.submit(new RequestHandler(request,response));
		}
	}

	public static String getWebroot() {
		return WEBROOT;
	}
	
	public static HashMap<String, String> getContentType() {
		return contentType;
	}

	public static void setContentType() {
		contentType.put(".jpg", "Content-type:image/jpeg");
		contentType.put(".*", "Content-type:application/octet-stream");
		
	}
}
