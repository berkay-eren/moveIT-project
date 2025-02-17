package Subclass;
import java.util.Scanner;

import Superclass.Person;

public class Worker extends Person{
	
	private double salary;
	private String proficiency;
	
	public Worker(int id, String name, int enterYear, double salary, String proficiency) {
		super(id, name, enterYear);
		this.salary = salary;
		this.proficiency = proficiency;
	}

	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getProficiency() {
		return proficiency;
	}
	
	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}
	
	@Override
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		super.getInput();
		
		System.out.println("Enter Worker's salary: ");
		salary = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter Worker's proficiency: ");
		proficiency = scanner.nextLine();
	}
	

	
	@Override
	public String toString() {
		
		return super.toString() +
                " Salary= " + salary +
                " Proficiency= " + proficiency+"\n";
	}

	@Override
	public String displayRole() {
		return "Role: Worker with proficiency in " + proficiency;
	}

}
