package Course.dataAcces.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Course.dataAcces.Abstract.CourseRepository;
import Course.entities.concretes.Course;


@Repository
public class InMemoryCourseRepository implements CourseRepository {
	
	
	//Course türünde courses nesnesi yarattım
	List<Course> courses;
	
	
	
	
	

	public InMemoryCourseRepository() { 
		            
		// Nesne her yaratıldığında otomatik şekilde arraylist oluşturuyorum
	    
		
		courses = new ArrayList<Course>();   
		courses.add(new Course(1,"Java"));
		courses.add(new Course(2,"Pyhton"));
		courses.add(new Course(3,"C#"));
		courses.add(new Course(4,"PHP"));
		
	}






	@Override
	public List<Course> getAll() {
		
		return courses;
	}






	@Override
	public void add(Course C1) throws Exception {
	
		
		courses.add(C1);
	}






	@Override
	public void delete(Course C1) {
		courses.remove(C1);
		
	}






	@Override
	public void update(Course C1, Course CNEW) {
	courses.set(courses.indexOf(C1),CNEW);
		
	}






	@Override
	public Course getById(int id) {
		
		return courses.get(id);
	}

}
