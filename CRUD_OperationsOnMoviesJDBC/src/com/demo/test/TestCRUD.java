package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Movies;
import com.demo.service.MoviesService;
import com.demo.service.MoviesServiceImpl;

public class TestCRUD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MoviesService  mService=new MoviesServiceImpl();
		
		int choice=0;
		
		do {
			System.out.println("Enter your Choice:\n"
					+ "1 : Add New Movie\n"
					+ "2 : Delete by Id\n"
					+ "3 : Display All movies\n"
					+ "4 : Display by ID\n"
					+ "5 : Display by Categories\n"
					+ "6 : Update movies details\n"
					+ "7 : Display in Sorted order\n"
					+ "8 : Exit ");
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				mService.addMovies();
				break;
			case 2:
				int id;
				System.out.println("Enter Movie Id to Delete");
				id = sc.nextInt();
				boolean status = mService.deleteMovieId(id);
				if (status==true) {
					System.out.println("Movie Deleted Succesfully");				
				}else {
					System.out.println("error occured");
				}
				break;
			case 3:
				List<Movies> mlst = mService.displayAll();
				mlst.forEach(System.out::println);
				break;
			case 4:
				int id1;
				System.out.println("Enter ID to Search");
				id=sc.nextInt();
				Movies m = mService.displayById(id);
				if(m!=null) {
					System.out.println(m);
				}else {
					System.out.println("ID not Found");
				}
				break;
			case 5:
				//display by catagory
				break;
			case 6:
				System.out.println("Enter Movies ID to update");
				int mid = sc.nextInt();
				System.out.println("Enter Title to update ");
				String title = sc.next();
				System.out.println("Enter Category to update");
				String catag = sc.next();
				status = mService.modify(mid,title,catag);
				if(status) {
					System.out.println("Updated Succesfully");
				}else {
					System.out.println("Error occured");
				}
				
				break;
			case 7:
				//display in sorted order
				break;
			case 8:
				sc.close();
				mService.breakConn();
				System.out.println("Thank you to visit");
				break;
			}
		} while (choice!=8);
				
	}

}
