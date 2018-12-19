package br.com.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import br.com.entitie.business.EmployeeFileReader;

public class Program {

	public static void main(String[] args) {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter full file path: ");
			Path path =  Paths.get(sc.next());
			EmployeeFileReader employeefr = new EmployeeFileReader(path);
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			employeefr.getEmployeeBiggerSalary(salary);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " 
			+
			employeefr.getSumEmployeeChar('M'));
			
			sc.close();
	}

}
