package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.Date;

import com.util.DbUtility;

public class PersonEntryExitDao {
	DbUtility dao;

	public PersonEntryExitDao() {
		dao=new DbUtility();
	}
	public int insertPersonData(int id)
	{
		int i=0;
		try {
		Connection con=dao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into personData(pId,entrytime) values(?,CURRENT_TIMESTAMP)");
		ps.setInt(1, id);
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
	public int insertExitData(int id)
	{
		int i=0;
		try {
		Connection con=dao.getConnection();
		PreparedStatement ps=con.prepareStatement("update  personData set exittime=CURRENT_TIMESTAMP where pid=?");
		ps.setInt(1, id);
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
	
}
