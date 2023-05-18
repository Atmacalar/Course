package Course.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Course.business.Abstract.CourseService;
import Course.dataAcces.Abstract.CourseRepository;
import Course.entities.concretes.Course;

@Service
public class CourseManager implements CourseService {

	// diğer katmanlarda her zaman İnterfaceler türetilir, Classlar değil;
	
       private	CourseRepository courses;
       
       
       
       
       
       @Autowired
	public CourseManager(CourseRepository courses) {
		
		//CourseManager newlendiğinde parametre 
       //olarak bir CourseRepository çeşidi ister(jdbc,hibernate vs..)
		
		this.courses = courses;
	}






	@Override
	public List<Course> getAll() {
		
		return courses.getAll();
	}






	@Override
	public void add(Course C1) throws Exception {
		if(C1.getName().isEmpty()) 
			throw new Exception("İsim boş olamaz");
		
		else  if(courses.getAll().contains(C1))
		throw new Exception("Kurs zaten mevcut");
	        	
		
		else courses.add(C1);
	
		}
		
	






	@Override
	public void delete(Course C1) {
		courses.delete(C1);
		
	}






	@Override
	public void update(Course C1, Course CNEW) throws Exception {
		if(courses.getAll().contains(CNEW)) {
			throw new Exception("This programming language is already exist.");
		}else {
			courses.update(C1,CNEW);
		}
		
	}






	@Override
	public Course getById(int id) {
		
	return courses.getById(id);
		
	}
	
	

}
