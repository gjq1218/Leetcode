package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Groupon {
	class Person{
		String name;
		String age;
		
		public Person(String name, String age){
			this.name = name;
			this.age = age;
		}
	}
	
	class People{

		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<Person> list = new ArrayList<Person>();
		
		public People(ArrayList<Person> list){			
			for(Person aa: list){
				map.put(aa.name, aa.age);
			}
		}
		
		public String queryAge(String name){
			
			if(map.containsKey(name)){
				return map.get(name);
			}
			return null;		
		} 		
	}
	
	static class People1 implements Iterable<Person>{
		ArrayList<Person> list1 = new ArrayList<Person>();
		ArrayList<Person> list2 = new ArrayList<Person>();
		Myiterator<Person> myiterator = new Myiterator<Person>(list1, list2);

		public People1(ArrayList<Person> list1, ArrayList<Person> list2)
		{
			this.list1 = list1;
			this.list2 = list2;
		}
		@Override
		public Myiterator<Person> iterator() {
			return myiterator;
		}
		
	}
	static class Myiterator<Person> implements Iterator<Person>
	{
		ArrayList<Person> list1 = new ArrayList<Person>();
		ArrayList<Person> list2 = new ArrayList<Person>();

		
		public Myiterator(ArrayList<Person> list1, ArrayList<Person> list2)
		{
			this.list1 = list1;
			this.list2 = list2;
		}


		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public Person next() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	//static HashMap<String, String> map = new HashMap<String, String>();
	

	public static void main(String args[]){
		Groupon test = new Groupon();
		
		Person a = test.new Person("Mike", "15");
		Person b = test.new Person("Role", "13");
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(a);
		list.add(b);
		
		ArrayList<Person> list1 = new ArrayList<Person>();

		ArrayList<Person> list2 = new ArrayList<Person>();

		
		People people = test.new People(list);
		people.queryAge("Mike");
		
		People1 p1 = new People1(list1, list2);
		Iterator<Person> my = p1.iterator();
		while(my.hasNext())
		{
			System.out.println(my.next());
		}
		
	
	}
}
