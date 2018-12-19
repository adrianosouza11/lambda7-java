package br.com.entitie.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.entities.Employee;

public class EmployeeFileReader {
	private Path path;
	private List<Employee> list = new ArrayList<>();
	
	public EmployeeFileReader(Path path){
		try(BufferedReader br = new BufferedReader(new FileReader(path.toString()))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], 
						fields[1],
						Double.parseDouble(fields[2]))
						);
				
				line = br.readLine();
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void getEmployeeBiggerSalary(Double salary) {
		 list.stream()
		 .filter( p -> p.getSalary() > salary)
		 .map(Employee::getEmail)
		 .sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
		 .collect(Collectors.toList())
		 .forEach(System.out::println);
	}
	
	public double getSumEmployeeChar(char character) {
		return list.stream()
				.filter( p ->  p.getName().charAt(0) == character)
				.mapToDouble(Employee::getSalary)
				.sum();
				
	}
}
