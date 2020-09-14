package Generics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stacks {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("DS started...");

		int[] stack = null;
		int top=-1,length=0;
		boolean flag=false,InsertionIndicator=false;
		String choice;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String condition;
		do {
			System.out.print("1.Create statck \t2.Enter Element \n3.Delete Element");
			System.out.print("\t4.Top Element \t5.print Stack \t6.Exit");
			System.out.println("\nEnter your choice : ");
			choice=br.readLine();

			switch (choice) {
			case "1":
				if(flag) {
					System.out.println("Stack already created");
				}else {
					stack=new int[10];
					flag=true;	
					System.out.print("Stack Created\n");
				}
				break;
			case "2":
				if(flag) {
					InsertionIndicator=true;
					System.out.println("Enter element: ");
					int element=Integer.parseInt(br.readLine());
					stack[length]=element;
					length++;
					top++;	
					Thread.sleep(1000);
					System.out.println("Pushed");				
				}else {
					System.out.println("Create stack first using option 1.");
				}
				break;
			case "3":
				if (flag) {
					if(InsertionIndicator) {
						length--;
						top--;
						Thread.sleep(1000);
						System.out.println("Popped");
						if (top==-1 && length==0) {
							InsertionIndicator=false;
						}

					}else if(top==-1 && length==0) {
						System.out.println("Underflow");
					}
					else {
						System.out.println("Underflow");
					}	
				}else {
					System.out.println("Create stack first using option 1.");
				}				
				break;
			case "4":
				if(top==-1) {
					System.out.println("Stack is empty");
				}else {
					System.out.println("Top Element : "+stack[length-1]);	
				}			
				break;
			case "5":
				if(flag) {
					if(top==-1 || length==0){
						System.out.println("Stack is empty");
					}else {
						System.out.println("Elements in stack : ");
						for(int i=length-1;i>-1;i--) {	

							System.out.print(stack[i]+"\t");
						}
						System.out.println();
					}
				}else if(top==-1 || length==0){
					System.out.println("Stack is empty");
				}else {
					System.out.println("Stack is empty");

				}			
				break;
			case "6":
				System.exit(0);
				break;
			default:
				System.out.println("Irrelevent");				
				break;
			}
			System.out.println("Do you want to continue ...1.Yes\t2.No");
			condition=br.readLine();	
			System.out.println();
		} while (condition.contains("1"));
	}
}