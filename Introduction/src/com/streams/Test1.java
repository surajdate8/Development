package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	//@Test
	public void regular() {
		List<String> name=new ArrayList<String>();
		name.add("Abhijit");
		name.add("Don");
		name.add("Aish");
		name.add("Farhan");
		name.add("Zukerberg");

		int count=0;

		for(int i=0;i<name.size();i++) {
			String str=name.get(i);
			if(str.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);
	}
	//@Test
	public void streamFilter() {
		List<String> name=new ArrayList<String>();
		name.add("Abhijit");
		name.add("Don");
		name.add("Aish");
		name.add("Farhan");
		name.add("Zukerberg");

		long c=name.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);

		long t=Stream.of("Aabcd","Aaaa","Baa","Caaaaaaa","D").
		filter(s->
		{
			s.startsWith("B");
			return true;
		}).count();
		System.out.println(t);
		
		//name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		name.stream().filter(s->s.length()>4.).limit(1).forEach(s->System.out.println(s));
		
	}

	@Test
	public void streamMap() {
		
		List<String> name=new ArrayList<String>();
		name.add("Aish");
		name.add("Farhan");
		name.add("Suraj");
		name.add("Dhiraj");
		
		Stream.of("Abhijit","Don","Aditya","Aditi","Zuke")
		.filter(s->s.endsWith("e"))
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));

		System.out.println();
		
		List<String> names=Arrays.asList("Abhijit","Don","Aditya","Aditi","Zuke");
		names.stream().filter(s->s.startsWith("A"))
		.sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		Stream<String> str=Stream.concat(name.stream(), names.stream());
//		str.sorted()
//		.forEach(s->System.out.println(s));
//	
		System.out.println("Boolean res");
		boolean res=str.anyMatch(s->s.equalsIgnoreCase("Abhijit"));
		Assert.assertTrue(res);
	}
	
}
