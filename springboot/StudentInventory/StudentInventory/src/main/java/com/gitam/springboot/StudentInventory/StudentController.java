package com.gitam.springboot.StudentInventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@Controller
public class StudentController {
	@RequestMapping(path = "/home")
	public String index() {
		System.out.println("***************succes");
		return "home";
		
	}
	
	@RequestMapping(path="/addVal")              
	  public String addVals(@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("dob") String dob,@RequestParam("aadhar") String aadhar,@RequestParam("mobile") String mobile,@RequestParam("email") String email,@RequestParam("gender") String gender,@RequestParam("year") int year,@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("city") String city){
		LeadDAO.addVals(fname,lname,dob,aadhar,mobile,email,gender,year,country,state,city);
		System.out.println("addval****sucess");
		
	    return "home";  
	  }
	
	@RequestMapping(path="/updateVal")              
	  public String addVals(@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("dob") String dob,@RequestParam("aadhar") String aadhar,@RequestParam("mobile") String mobile,@RequestParam("email") String email,@RequestParam("gender") String gender,@RequestParam("regno") int regno,@RequestParam("year") int year,@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("city") String city){
		LeadDAO.updateVals(fname,lname,dob,aadhar,mobile,email,gender,regno,year,country,state,city);
		System.out.println("updateval****sucess");
		
	    return "home";  
	  }
	
	@RequestMapping(path="/delVal")              
	  public String delVals(@RequestParam("regno") int regno){
		LeadDAO.deleteStudentObject(regno);
		System.out.println("delete+val****sucess");
		
	    return "home";  
	  }
	
	@RequestMapping(path="/fetchVal")              
	  public String fetchVals(@RequestParam("fname") String fname,ModelMap model){
		System.out.println(fname);
		LeadDAO.fetchStudentObjectsByFname(fname);
		StudentBean sb=LeadDAO.fetchFirstStudentObjectByFname();
		model.addAttribute("lobj", sb);
		model.addAttribute("fname", sb.getFname());
		model.addAttribute("lname", sb.getLname());
		model.addAttribute("dob", sb.getDOB());
		model.addAttribute("aadhar", sb.getAadhar());
		model.addAttribute("mobile", sb.getMobile());
		model.addAttribute("email", sb.getEmail());
		model.addAttribute("gender", sb.getGender());
		model.addAttribute("regno", sb.getRegno());
		model.addAttribute("year", sb.getYear());
		model.addAttribute("country", sb.getCountry());
		model.addAttribute("state", sb.getState());
		model.addAttribute("city", sb.getCity());
		System.out.println(sb);
		
	    return "home";  
	  }
	@RequestMapping(path="/fetchNextVal")              
	  public String fetchNextVals(@RequestParam("fname") String fname,ModelMap model){
		System.out.println(fname);
		LeadDAO.fetchStudentObjectsByFname(fname);
		StudentBean sb=LeadDAO.fetchNextStudentObjectByFname();
		model.addAttribute("lobj", sb);
		model.addAttribute("fname", sb.getFname());
		model.addAttribute("lname", sb.getLname());
		model.addAttribute("dob", sb.getDOB());
		model.addAttribute("aadhar", sb.getAadhar());
		model.addAttribute("mobile", sb.getMobile());
		model.addAttribute("email", sb.getEmail());
		model.addAttribute("gender", sb.getGender());
		model.addAttribute("regno", sb.getRegno());
		model.addAttribute("year", sb.getYear());
		model.addAttribute("country", sb.getCountry());
		model.addAttribute("state", sb.getState());
		model.addAttribute("city", sb.getCity());
		System.out.println(sb);
		
	    return "home";  
	  }
	
	@RequestMapping(path="/fetchPrevVal")              
	  public String fetchPrevVals(@RequestParam("fname") String fname,ModelMap model){
		System.out.println(fname);
		LeadDAO.fetchStudentObjectsByFname(fname);
		StudentBean sb=LeadDAO.fetchPrevStudentObjectByFname();
		model.addAttribute("lobj", sb);
		model.addAttribute("fname", sb.getFname());
		model.addAttribute("lname", sb.getLname());
		model.addAttribute("dob", sb.getDOB());
		model.addAttribute("aadhar", sb.getAadhar());
		model.addAttribute("mobile", sb.getMobile());
		model.addAttribute("email", sb.getEmail());
		model.addAttribute("gender", sb.getGender());
		model.addAttribute("regno", sb.getRegno());
		model.addAttribute("year", sb.getYear());
		model.addAttribute("country", sb.getCountry());
		model.addAttribute("state", sb.getState());
		model.addAttribute("city", sb.getCity());
		System.out.println(sb);
		
	    return "home";  
	  }
	
	@RequestMapping(path="/fetchFirstVal")              
	  public String fetchFirstVals(@RequestParam("fname") String fname,ModelMap model){
		System.out.println(fname);
		LeadDAO.fetchStudentObjectsByFname(fname);
		StudentBean sb=LeadDAO.fetchFirstStudentObjectByFname();
		model.addAttribute("lobj", sb);
		model.addAttribute("fname", sb.getFname());
		model.addAttribute("lname", sb.getLname());
		model.addAttribute("dob", sb.getDOB());
		model.addAttribute("aadhar", sb.getAadhar());
		model.addAttribute("mobile", sb.getMobile());
		model.addAttribute("email", sb.getEmail());
		model.addAttribute("gender", sb.getGender());
		model.addAttribute("regno", sb.getRegno());
		model.addAttribute("year", sb.getYear());
		model.addAttribute("country", sb.getCountry());
		model.addAttribute("state", sb.getState());
		model.addAttribute("city", sb.getCity());
		System.out.println(sb);
		
	    return "home";  
	  }
	
	@RequestMapping(path="/fetchLastVal")              
	  public String fetchLastVals(@RequestParam("fname") String fname,ModelMap model){
		System.out.println(fname);
		LeadDAO.fetchStudentObjectsByFname(fname);
		StudentBean sb=LeadDAO.fetchLastStudentObjectByFname();
		model.addAttribute("lobj", sb);
		model.addAttribute("fname", sb.getFname());
		model.addAttribute("lname", sb.getLname());
		model.addAttribute("dob", sb.getDOB());
		model.addAttribute("aadhar", sb.getAadhar());
		model.addAttribute("mobile", sb.getMobile());
		model.addAttribute("email", sb.getEmail());
		model.addAttribute("gender", sb.getGender());
		model.addAttribute("regno", sb.getRegno());
		model.addAttribute("year", sb.getYear());
		model.addAttribute("country", sb.getCountry());
		model.addAttribute("state", sb.getState());
		model.addAttribute("city", sb.getCity());
		System.out.println(sb);
		
	    return "home";  
	  }
	
	@RequestMapping(path="/import-order-excel", method = RequestMethod.POST)
    public String importExcelFile(@RequestParam("studfile") MultipartFile studfile)throws IOException {
        List<StudentBean> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(studfile.getInputStream());
        // Read student data form excel file sheet1.
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                XSSFRow row = worksheet.getRow(index);
                StudentBean student = new StudentBean();
                student.setFname(getCellValue(row, 0));
                student.setLname(getCellValue(row, 1));
                student.setDOB(getCellValue(row, 2));
                student.setAadhar(getCellValue(row, 3));
                student.setMobile(getCellValue(row, 4));
                student.setEmail(getCellValue(row, 5));
                student.setGender(getCellValue(row, 6));
                student.setYear(convertStringToInt(getCellValue(row, 7)));
                student.setCountry(getCellValue(row, 8));
                student.setState(getCellValue(row, 9));
                student.setCity(getCellValue(row, 10));
                students.add(student);
                StudentBean lobj=student;
        		System.out.println(lobj.getFname()+"  "+lobj.getLname()+"  "+lobj.getDOB()+"  "+lobj.getAadhar()+"  "+lobj.getMobile()+"  "+lobj.getEmail()+"  "+lobj.getGender()+"  "+lobj.getRegno()+"  "+lobj.getYear()+"  "+lobj.getCountry()+"  "+lobj.getState()+"  "+lobj.getCity());
                LeadDAO.addVals(student.fname,student.lname,student.DOB,student.Aadhar,student.mobile,student.email,student.gender,student.year,student.country,student.state,student.city);
            }
        }
        System.out.println("******succccc**********");
        return "home";
}
	
	 public String getCellValue(Row row, int cellNo) {
	        DataFormatter formatter = new DataFormatter();
	        org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNo);
	        return formatter.formatCellValue(cell);
	    }
	 
	 private int convertStringToInt(String str) {
	        int result = 0;
	        if (str == null || str.isEmpty() || str.trim().isEmpty()) {
	            return result;
	        }
	        result = Integer.parseInt(str);
	        return result;
	    }
}
