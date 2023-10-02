package com.gitam.springboot.StudentInventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;


@Service
public class LeadDAO {
	
	@Autowired
	public static JdbcTemplate jdbctemplate;
	public static List<StudentBean> studentList;
	public static int listIndex;
	
	private ResultSet rs;
	
	public LeadDAO(JdbcTemplate jdbcTemplate) {
		this.jdbctemplate = jdbcTemplate;
	}
	
	public static void addVals(String fname,String lname,String dob,String aadhar,String mobile,String email,String gender,int year,String country,String state,String city) {
//		try {
			String query=String.format("insert into studentdetails(fname,lname,dob,aadhar,mobile,email,gender,year,country,state,city) values('%s','%s','%s','%s','%s','%s','%s',%d,'%s','%s','%s')",fname,lname,dob,aadhar,mobile,email,gender,year,country,state,city);
			jdbctemplate.update(query);
			System.out.println(query);
//		}
//		catch(Exception ex){
//			ErrorBean eb=new ErrorBean();
//			eb.setErMes(ex.getMessage());
//		}
	}
	public static void updateVals(String fname,String lname,String dob,String aadhar,String mobile,String email,String gender,int regno,int year,String country,String state,String city) {
		String query=String.format("update studentdetails set fname='%s',lname='%s',dob='%s',aadhar='%s',mobile='%s',email='%s',gender='%s',year=%d,country='%s',state='%s',city='%s' where regno=%d",fname,lname,dob,aadhar,mobile,email,gender,year,country,state,city,regno);
		System.out.println(query);
		jdbctemplate.update(query);
	}
//	public static void fetchDetails(String fname) {
//		String query=String.format("select * from studentdetails where fname='%s'",fname);
//		
//	}
	public static List<StudentBean> fetchStudentObjects() {
		
		 return jdbctemplate.query("select * from studentdetails",new ResultSetExtractor<List<StudentBean>>(){  
		    @Override  
		     public List<StudentBean> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<StudentBean> list=new ArrayList<StudentBean>();  
		        while(rs.next()){  
			        StudentBean e=new StudentBean();  
				        e.setFname(rs.getString(1)); 
				        e.setLname(rs.getString(2));
				        e.setDOB(rs.getString(3));
				        e.setAadhar(rs.getString(4));
				        e.setMobile(rs.getString(5));
				        e.setEmail(rs.getString(6));
				        e.setGender(rs.getString(7));
				        e.setRegno(rs.getInt(8));
				        e.setYear(rs.getInt(9));
				        e.setCountry(rs.getString(10));
				        e.setState(rs.getString(11));
				        e.setCity(rs.getString(12));
				        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
	
		}
	public static void printStudentObjects() {
		List<StudentBean> list=LeadDAO.fetchStudentObjects();
		java.util.Iterator<StudentBean> leadObjectIterator = list.iterator();
		
		while(leadObjectIterator.hasNext()) {
			StudentBean lobj=leadObjectIterator.next();
			System.out.println(lobj.getFname()+"  "+lobj.getLname()+"  "+lobj.getDOB()+"  "+lobj.getAadhar()+"  "+lobj.getMobile()+"  "+lobj.getEmail()+"  "+lobj.getGender()+"  "+lobj.getRegno()+"  "+lobj.getYear()+"  "+lobj.getCountry()+"  "+lobj.getState()+"  "+lobj.getCity());
			System.out.println();
		}
	}
	
	public static void deleteStudentObject(int regno) {
		String query="delete from studentdetails where regno="+regno;
		jdbctemplate.update(query);
	}
	
	public static List<StudentBean> fetchStudentObjectsByFname(String fname) {
		String query="select * from studentdetails where fname like '"+fname+"%'";
		 return jdbctemplate.query(query,new ResultSetExtractor<List<StudentBean>>(){  
		    @Override  
		     public List<StudentBean> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<StudentBean> list=new ArrayList<StudentBean>();  
		        while(rs.next()){  
			        StudentBean e=new StudentBean();  
				        e.setFname(rs.getString(1)); 
				        e.setLname(rs.getString(2));
				        e.setDOB(rs.getString(3));
				        e.setAadhar(rs.getString(4));
				        e.setMobile(rs.getString(5));
				        e.setEmail(rs.getString(6));
				        e.setGender(rs.getString(7));
				        e.setRegno(rs.getInt(8));
				        e.setYear(rs.getInt(9));
				        e.setCountry(rs.getString(10));
				        e.setState(rs.getString(11));
				        e.setCity(rs.getString(12));
				        list.add(e);  
		        }
		        listIndex=0;
		        studentList=list;
		        return list;  
		        }  
		    });  
	
		}
	public static void printStudentObjectsByFname(String fname) {
		List<StudentBean> list=LeadDAO.fetchStudentObjectsByFname(fname);
		java.util.Iterator<StudentBean> leadObjectIterator = list.iterator();
		
		while(leadObjectIterator.hasNext()) {
			StudentBean lobj=leadObjectIterator.next();
			System.out.println(lobj.getFname()+"  "+lobj.getLname()+"  "+lobj.getDOB()+"  "+lobj.getAadhar()+"  "+lobj.getMobile()+"  "+lobj.getEmail()+"  "+lobj.getGender()+"  "+lobj.getRegno()+"  "+lobj.getYear()+"  "+lobj.getCountry()+"  "+lobj.getState()+"  "+lobj.getCity());
			System.out.println();
		}
	}
	public static StudentBean fetchFirstStudentObjectByFname() {
		StudentBean lobj=studentList.get(0);
		listIndex=0;
		return lobj;
	}
	public static StudentBean fetchLastStudentObjectByFname() {
		StudentBean lobj=studentList.get(studentList.size() - 1);
		listIndex=studentList.size() - 1;
		return lobj;
	}
	public static StudentBean fetchNextStudentObjectByFname() {
//		if(listIndex<studentList.size() - 1) {
//			listIndex=listIndex+1;
//		}
		listIndex=(listIndex+1)%(studentList.size());
		return studentList.get(listIndex);
	}
	public static StudentBean fetchPrevStudentObjectByFname() { 
//		if(listIndex>0) {
//			listIndex=listIndex-1;
//		}
		listIndex=(studentList.size()-(listIndex+1))%(studentList.size());
		return studentList.get(listIndex);
	}
	public static void printStudentObject(StudentBean lobj){
		System.out.println(lobj.getFname()+"  "+lobj.getLname()+"  "+lobj.getDOB()+"  "+lobj.getAadhar()+"  "+lobj.getMobile()+"  "+lobj.getEmail()+"  "+lobj.getGender()+"  "+lobj.getRegno()+"  "+lobj.getYear()+"  "+lobj.getCountry()+"  "+lobj.getState()+"  "+lobj.getCity());
	}
	
	
}
