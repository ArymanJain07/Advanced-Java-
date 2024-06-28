package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Product p) {
		int n = jdbcTemplate.update("insert into product values (?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		System.out.println(n +" Rows Affected");
		System.out.println("Data Added Successfully");
		
	}
	public boolean removeById(int pid) {
		int n = jdbcTemplate.update("delete from product where pid=?",new Object[] {pid});		
		return n>0;
	}
	@Override
	public List<Product> findAll() {
		
		RowMapper rm =(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getInt(4));
			return p;
		};
		
		List<Product> pList = jdbcTemplate.query("select * from product",rm);
		return pList;
	}
	@Override
	public Product searchById(int pid) {
		@SuppressWarnings("deprecation")
		Product p=jdbcTemplate.queryForObject("select * from product where pid=?",
				new Object[] {pid},
				BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}
	@Override
	public boolean updateProduct(int pid, String pname, int qty, int price) {
		int n = jdbcTemplate.update("update product set pname=?,qty=?,price=? where pid=?",new Object[] {pname,qty,price,pid});
		return n>0;
	}
	@Override
	public List<Product> searchByQty(int qty) {
		RowMapper rm =(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getInt(4));
			return p;
		};
		
		List<Product> pList = jdbcTemplate.query("select * from product where qty > ?",new Object[] {qty} ,rm);
		return pList;
	}
	@Override
	public List<Product> sortbyid() {
		RowMapper rm=(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getInt(3));
			return p;
			
		};
		List<Product> plist=jdbcTemplate.query("select * from product order by pid desc",rm);
		return plist;
	
		
	}
	
	
	
}
