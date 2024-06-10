package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Movies;
import com.demo.dao.MoviesDao;
import com.demo.dao.MoviesDaoImpl;

public class MoviesServiceImpl implements MoviesService {

	private MoviesDao mDao;
	
	public MoviesServiceImpl() {
		mDao= new MoviesDaoImpl();
	}
	
	
	public void breakConn() {
		mDao.stopConn();
	}
	
	Scanner sc = new Scanner(System.in);
	@Override
	public void addMovies() {
		System.out.println("Enter Movies ID");
		int mid = sc.nextInt();
		System.out.println("Enter Movies Title");
		String mname = sc.next();
		System.out.println("Enter Movies Category");
		String catag = sc.next();
		Movies m = new Movies(mid,mname,catag);
		
		mDao.save(m);
		
		
	}
	@Override
	public boolean deleteMovieId(int id) {
		
		return mDao.removeById(id);
	}


	@Override
	public List<Movies> displayAll() {
		return mDao.findAll();
	}


	@Override
	public boolean modify(int mid, String title, String catag) {
		
		return mDao.update(mid,title,catag);
	}


	@Override
	public Movies displayById(int id) {
		return mDao.findById(id);
	}

}
