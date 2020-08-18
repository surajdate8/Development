
public class Negative {
	static int count=0;
	public static void main(String[] args) {
		
		
		int[] numbers= {2,55,3,11,-1};
		
		count=processArray(numbers);
		System.out.println(count);
	}

	private static int processArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]<0) {
				break;
			}
			else if(numbers[i]>10) {
				count++;
			}
		}
		return count;
	}

}
