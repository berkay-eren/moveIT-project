package Subclass;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.CalculationsInterface;
import Superclass.Person;

public class Member extends Person{
	
	private double weight;
	private double height;
	private String membershipPlan;
	private double payment;
	private Trainer assignedTrainer;
	private Exercise exercise;
	private static final int YEARLY = 3000;
	private static final int MONTHLY = 500;
	private static final int DAILY = 150;
	
	public Member(int id,String name, int enterYear, double weight, double height, String membershipPlan, double payment, Exercise exercise) {
		
		super(id,name,enterYear);
		this.weight = weight;
		this.height = height;
		this.membershipPlan = membershipPlan;
		this.payment = payment;
		this.exercise=exercise;
		this.assignedTrainer=(Trainer) new Trainer();
	}

	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public String getMembershipPlan() {
		return membershipPlan;
	}
	
	public void setMembershipPlan(String membershipPlan) {
		this.membershipPlan = membershipPlan;
	}
	
	public double getPayment() {
		return payment;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	public double calculatePayment(String plan) {
		
		double payment = 0;
		
		if(plan.equalsIgnoreCase("yearly")) {
			payment = YEARLY;
		}
		else if(plan.equalsIgnoreCase("monthly")) {
			payment = MONTHLY;
		}
		else if(plan.equalsIgnoreCase("daily")) {
			payment = DAILY;
		}
	
		return payment;
	}
	
	public double calculateBMI() {
		if (height <= 0 || weight <= 0) {
	        throw new IllegalArgumentException("Height and Weight must be greater than 0!");
	    }
	    return weight / (height * height);
	}

	

	public double calculateCaloriesBurned() {

	      return        exercise.calculateCaloriesBurned();
	
	}

	public void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		super.getInput();
		
		System.out.println("Enter Member's weight: ");
		weight = scanner.nextDouble();
		
		System.out.println("Enter Member's height: ");
		height = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter Member's membership plan: ");
		membershipPlan = scanner.nextLine();
		
		System.out.println("Enter Member's payment: ");
		payment = scanner.nextDouble();
		scanner.nextLine();
		
	}
	
	public String toString() {
		
		 return super.toString() +
	                " Weight= " + weight +
	                " Height= " + height +
	                " Exercise= " +  exercise+ "Trainer= "+ assignedTrainer.getName() +" Calories burned= " +this.calculateCaloriesBurned()+
	                " Payment=" + payment+"\n";
	}

	@Override
	public String displayRole() {
		return "Role: GymMember";
	}
	
	


	public Trainer getAssignedTrainer() {
		return assignedTrainer;
	}

	public void setAssignedTrainer(Trainer assignedTrainer) {
		this.assignedTrainer = assignedTrainer;
	}


}
