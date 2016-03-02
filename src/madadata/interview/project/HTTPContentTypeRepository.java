package madadata.interview.project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class HTTPContentTypeRepository {

	public static void main(String [] args) throws IOException {
		FileReader fr = new FileReader("/Users/wangweilin/MetaWeb/MetaWebProject/src/HTTPContentTable");
		BufferedReader br = new BufferedReader(fr);
		String tempLine = br.readLine();
		String [] arr = tempLine.split("s+");
		
		System.out.println(arr[0]);
//		while (tempLine != null) {
//			//System.out.println(tempLine);
//			
//			String [] arr = tempLine.split("s+");
//			
//			System.out.println(arr[0]);
//			
//			tempLine = br.readLine();
//		}
	
	}
}
