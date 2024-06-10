package com.demo.service;

import java.util.List;

import com.demo.beans.Movies;

public interface MoviesService {

	void addMovies();

	boolean deleteMovieId(int id);

	List<Movies> displayAll();

	boolean modify(int mid, String title, String catag);

	void breakConn();

	Movies displayById(int id);

}
