import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner; 
public class Read 
{ 
	public static void main(String[] args) throws Exception 
	{ 
		String path=System.getProperty("user.dir");
		System.out.println(path);
		String filename = path+"/InputOutput/Read.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
			String line;
			while((line = reader.readLine()) != null){ 
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try{    
			FileWriter fw=new FileWriter(path+"/InputOutput/Output.txt");    
			fw.write("Welcome to javaTpoint.");    
			fw.close();    
		}catch(Exception e){System.out.println(e);}    
		System.out.println("Success...");    
	}    



} 