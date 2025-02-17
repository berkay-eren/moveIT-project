package Superclass;

import java.util.Objects;
import java.util.Scanner;

import Subclass.Trainer;

public abstract class Person implements Comparable<Person>{
	
	protected int id;
	protected String name;
	protected int enterYear;
	
	public Person(int id, String name, int enterYear) {
		this.id = id;
		this.name = name;
		this.enterYear = enterYear;
	}

	public Person() {
		// TODO Auto-generated constructor stub
		this.name="Not assigned";
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEnterYear() {
		return enterYear;
	}
	
	public void setEnterYear(int year) {
		this.enterYear=year;
	}
	
	public int calculateDuration() {
		int currentYear = java.time.Year.now().getValue();
		return currentYear - enterYear;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(id, name, enterYear);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Person other = (Person) obj;
	    return id == other.id && Objects.equals(name, other.name) && enterYear == other.enterYear;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Enter Name: ");
        name = scanner.nextLine();
        
        System.out.println("Enter ID: ");
        id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Registeration Year: ");
        enterYear = scanner.nextInt();
        scanner.nextLine();
    }

	public String toString() {
        return "Name= " + name + 
        	   " ID= " + id + 
        	   " Enter Year= " + enterYear;
    }
	
	public abstract String displayRole();

	public int compareTo(Person o2) {
		
		return this.id-o2.id;
	}
	
	
	

}
