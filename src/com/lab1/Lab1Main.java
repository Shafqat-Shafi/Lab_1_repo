package com.lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab1Main {

	static List<String> directory = new ArrayList<String>();
	static Scanner intInput = new Scanner(System.in);
	static Scanner strInput = new Scanner(System.in);

	public static void main(String args[]) {
		// Main method for Lab 1 Assignment
				
		try {
			System.out.println("\n Lab 1 App. Devloper: Shafqat Shafi [15210]");
			
			while(true) {				
				System.out.println("\n 1. Show existing files");
				System.out.println(" 2. More options");
				System.out.println(" 3. exit \n");
								
				int input = intInput.nextInt();

				if(input == 1) {															
					if(directory.isEmpty()) {
						System.out.println(" The root directory is empty, try other options");
					} else {
						System.out.println("\n Existing files seperated with comma[,] \n");

						Collections.sort(directory);
						
						System.out.println(directory);
					}	
					
				} else if(input == 2) {
					System.out.println("\n More Options \n");
					showMoreOptions();										
				} else if(input ==3) {
					System.out.println("\n Exiting application \n");
					break;
				} else {
					System.out.println("\n Wrong Input. Please try again \n");
					main(new String[1]);
				}
				
			}
					
		} catch (Exception e) {
			System.out.println("\n Wrong Input. Please try again \n");
			main(new String[1]);
		} finally {
			intInput.close();
			strInput.close();
		}
		
	}
	
	public static void showMoreOptions() {
				
		try {
			System.out.println("\n 1. Add a file");
			System.out.println(" 2. Delete a file");
			System.out.println(" 2. Search for a file");
			System.out.println(" 4. Go back <- \n");
							
			int input = intInput.nextInt();

			if(input == 1) {				
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
				
			} else if(input == 2) {
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
				
			} else if(input ==3) {
				System.out.println("\n Enter a file name \n");
				
				String fileName = strInput.nextLine();
				
				if(fileName instanceof String) {					
					if(directory.contains(fileName)) {
						System.out.println("\n File with name: " + fileName + " was found successfully \n");
					} else {
						System.out.println("\n File not found, try again \n");
					}
				} else {
					System.out.println("\n Wrong file name. File name should be a string \n");
				}
				showMoreOptions();
				
			} else if(input == 4) {
				main(new String[1]);
			} else {
				System.out.println("\n Wrong Input. Please try again \n");
				showMoreOptions();
			}
			
		} catch (Exception e) {
			System.out.println("\n Wrong Input. Please try again \n");
			showMoreOptions();
		} finally {
			intInput.close();
			strInput.close();
		}		

	}

}
