package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Person;
import com.util.DbUtility;

public class PersonDao {
	DbUtility dao;
	public PersonDao() {
		dao=new DbUtility();
	}
	public int InsertPerson(Person person)
	{
		int i=0;
		try {
		Connection con=dao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into person values(?,?,?)");
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setLong(3, person.getSalary());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(i>0)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int updatePerson(Person person)
	{
		int i=0;
		try {
		Connection con=dao.getConnection();
		PreparedStatement  ps=con.prepareStatement("update person set pName=?,pSalary=? where pId=?");
		ps.setInt(3, person.getId());
		ps.setString(1, person.getName());
		ps.setLong(2, person.getSalary());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println();
		}
		if(i>0)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	public int deleteData(int id)
	{
		int i=0;
		try {
		Connection con=dao.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from person where pId=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(i>0)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	public Person readData(int id)
	{
		Person p=new Person();
		try {
		Connection con=dao.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from person where pId=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setSalary(rs.getLong(3));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}
}
