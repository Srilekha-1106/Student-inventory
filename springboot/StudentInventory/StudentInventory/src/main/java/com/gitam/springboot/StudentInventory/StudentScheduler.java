package com.gitam.springboot.StudentInventory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentScheduler {
	@Scheduled(cron="0/10 * * ? * *")
	public void leadReport() {
//		LeadDAO.updateVals("deepak","manu","2001-05-19","234567898732","123456789","deepu@gmail.com","male",420,3,"india","andhra","vizag");
//		LeadDAO.printStudentObjects();
//		LeadDAO.deleteStudentObject(420);
//		LeadDAO.addVals("deepak","manu","2001-05-19","234567898732","123456789","deepu@gmail.com","male",69,3,"india","andhra","vizag");
//		LeadDAO.addVals("deepak","chahar","2001-05-19","846435434","123456789","deepak@gmail.com","gay",96,9,"india","andhra","vizag");
//		LeadDAO.printStudentObjectsByFname("dee");
//		LeadDAO.printStudentObjectsByFname("deep");
//		LeadDAO.printStudentObject(LeadDAO.fetchNextStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchNextStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchPrevStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchPrevStudentObjectByFname());
//		LeadDAO.deleteStudentObject(890);
		
//		LeadDAO.fetchStudentObjectsByFname("ra");
//		LeadDAO.printStudentObject(LeadDAO.fetchFirstStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchNextStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchNextStudentObjectByFname());
//		LeadDAO.printStudentObject(LeadDAO.fetchNextStudentObjectByFname());
	}
}
