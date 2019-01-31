package Selenium.Learning;
import java.util.Scanner;



public class Student {
	int sid;
	static int j=10;
	int m1,m2,total,avg;
	String studentName;
	Scanner sc=new Scanner (System.in);
	
	
	public void readDetails(){
		System.out.println("Enter Stident SID");
		sid=sc.nextInt();
		System.out.println("Enter Student name");
		studentName=sc.next();	
	}
	
	public void readMarks() {
		System.out.println("Enter student marks");
		m1=sc.nextInt();
		m2=sc.nextInt();
	}
	public void calculateMarks() {
		total=m1+m2;
		avg=(m1+m2)/2;
	}
	public void printDetails() {
		System.out.println("Student SID is"+ " " +  sid);
		System.out.println("Student name is" + " " + studentName);
		System.out.println("Student total marks is" + " " + total);
		System.out.println("Student Average is" + " " + avg);
	}	
	
	
		
	public static void main(String[] args) {
	
		Student[] St= new Student[100];
		
		for (int i=0; i<3; i++) {
			St[i] = new Student();
			St[i].readDetails();
			St[i].readMarks();
			St[i].printDetails();

		}
	}
	

	
	}
