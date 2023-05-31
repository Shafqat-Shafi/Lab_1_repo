package com.lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab1Main {

	static List<String> directory = new ArrayList<String>();
	static Scanner strInput = new Scanner(System.in);

	public static void main(String args[]) {
		// Main method for Lab 1 Assignment
				
		try {
			System.out.println("\n Lab 1 App. Devloper: Shafqat Shafi [15210]");
			
			while(true) {				
				System.out.println("\n 1. Show existing files");
				System.out.println(" 2. More options");
				System.out.println(" 3. exit \n");
								
				String input = strInput.nextLine();

				if(("1").equals(input)) {															
					if(directory.isEmpty()) {
						System.out.println(" The root directory is empty, try More options");
					} else {
						System.out.println("\n Existing files seperated with comma[,] \n");

						Collections.sort(directory);
						
						System.out.println(" " + directory);
					}	
					
				} else if(("2").equals(input)) {
					showMoreOptions();										
				} else if(("3").equals(input)) {
					System.out.println("\n Exiting application \n");
					break;
				} else {
					System.out.println("\n Wrong Input. Please try again \n");
				}
				
			}
					
		} catch (Exception e) {
			System.out.println("\n Exception occured. Please run the application again \n");
		} finally {
			strInput.close();
		}
		
	}
	
	public static void showMoreOptions() {
				
		try {
			System.out.println("\n 1. Add a file");
			System.out.println(" 2. Delete a file");
			System.out.println(" 2. Search for a file");
			System.out.println(" 4. Go back <- \n");
							
			String input = strInput.nextLine();

			if(("1").equals(input)) {				
				while(true) {
					System.out.println("\n Enter file name \n");

					String fileName = strInput.nextLine();
					
					if(fileName instanceof String) {
						directory.add(fileName);
						System.out.println("\n File added successfully \n");
						break;
					} else {
						System.out.println("\n Wrong file name. File name should be a string \n");
						break;
					}					
				}
				showMoreOptions();
				
			} else if(("2").equals(input)) {
				System.out.println("\n Enter file name you want to delete \n");
				
				String fileName = strInput.nextLine();
				
				if(fileName instanceof String) {					
					if(directory.remove(fileName)) {
						System.out.println("\n File deleted successfully \n");
					} else {
						System.out.println("\n File not found, try again \n");
					}
				} else {
					System.out.println("\n Wrong file name. File name should be a string \n");
				}
				showMoreOptions();
				
			} else if(("3").equals(input)) {
				System.out.println("\n Enter a file name \n");
				
				String fileName = strInput.nextLine();
				
				if(fileName instanceof String) {					
					if(directory.contains(fileName)) {
						System.out.println("\n File with name: \"" + fileName + "\" was found successfully \n");
					} else {
						System.out.println("\n File not found, try again \n");
					}
				} else {
					System.out.println("\n Wrong file name. File name should be a string \n");
				}
				showMoreOptions();
				
			} else if(("4").equals(input)) {
				main(new String[1]);
			} else {
				System.out.println("\n Wrong Input. Please try again \n");
				showMoreOptions();
			}
			
		} catch (Exception e) {
			System.out.println("\n Wrong Input. Please try again \n");
			showMoreOptions();
		} finally {
			strInput.close();
		}		

	}

}
