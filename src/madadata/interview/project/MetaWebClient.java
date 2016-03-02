package madadata.interview.project;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;


public class MetaWebClient {

	public static void main(String [] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getByName("localhost"), 10000);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("GET /index.html HTTP/1.0"); 
		out.println("Accept: */*");
		out.println("Host: 127.0.0.1:10000"); 
		out.println("Connection: close");
		out.println();
		out.println();
		InputStream in = socket.getInputStream();
		int temp = in.read();
		while (temp != -1) {
			System.out.print((char)temp);
			temp = in.read();
		}
		
//		byte[] buf = new byte[2048];
//		int len = in.read(buf);
//		String str =new String(buf,0,len); 
//		System.out.println(str);
		socket.close();
		
	
	}
}
