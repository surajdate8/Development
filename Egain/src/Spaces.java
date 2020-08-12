import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Spaces {
	static String stream_set="Hey , r u free              now?";
	static String path=null;

	public static void main(String[] args) throws FileNotFoundException{
		int count=process(stream_set);
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
}
