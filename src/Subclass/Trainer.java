package Subclass;
import java.util.Scanner;

import Superclass.Person;

public class Trainer extends Person {
	
	private String specialization;
	private double salary;
	private Member assignedMember;
	
	public Trainer() {
		super();
		
	}
	
	public Trainer(int id, String name, int enterYear, String specialization, double salary) {
		super(id, name, enterYear);
		this.specialization = specialization;
		this.salary = salary;
	}



	public String getSpecilization() {
		return specialization;
	}
	
	public void setSpecilization(String specialization) {
		this.specialization = specialization;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		super.getInput();
		
		System.out.println("Enter Trainer's salary: ");
		salary = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter Trainer's specilization: ");
		specialization = scanner.nextLine();
		
	}
	
	@Override
	public String toString() {
		
		 return super.toString() + 
	                " Salary= " + salary +
	                " Specialization= " + specialization+"\n";
	}


	@Override
	public String displayRole() {
		return "Role: Gym Trainer specializing in " + specialization;
	}

	public Member getAssignedMember() {
		return assignedMember;
	}

	public void setAssignedMember(Member assignedMember) {
		this.assignedMember = assignedMember;
	}


	
}
