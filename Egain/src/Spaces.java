import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Spaces {
	static int white=0;
	static String stream_set=null;
	static String path=null;

	public static void main(String[] args) throws FileNotFoundException{

		input();
		int count=process(stream_set);
		output(count);		
	}
	private static void input() throws FileNotFoundException {
		path=System.getProperty("user.dir");
		String filename = path+"/InputOutput/input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
			String line;

			while((line = reader.readLine()) != null){ 
				stream_set=line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static int process(String stream_set) {
		int top=-1,length=0,white=0;

		for(int i=0;i<stream_set.length();i++)
		{
			char c=stream_set.charAt(i);
			if(c == 32){
				if(top== -1) {
					continue;
				}else {
					for(int j=length;j>=1;j--){
						length--;
						top--;
					}
					white++;
				}
			}else if(c != 32){
				length++;
				top++;			
			} 
		}
		return white;
	}
	private static void output(int count)
	{
		try
		{    
			FileWriter fw=new FileWriter(path+"/InputOutput/output.txt");
			String New_Count=String.valueOf(count);
			fw.write(New_Count);    
			fw.close();    
		}catch(Exception e){
			System.out.println(e);
		}    
	}

}
