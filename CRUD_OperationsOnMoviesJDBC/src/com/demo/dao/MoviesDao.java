package com.demo.dao;

import java.util.List;

import com.demo.beans.Movies;

public interface MoviesDao {

	void save(Movies m);

	boolean removeById(int id);

	void stopConn();

	List<Movies> findAll();

	boolean update(int mid, String title, String catag);

}
