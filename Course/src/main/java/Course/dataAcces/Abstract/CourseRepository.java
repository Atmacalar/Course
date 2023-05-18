package Course.dataAcces.Abstract;

import java.util.List;

import Course.entities.concretes.Course;

public interface CourseRepository {
	
	List<Course> getAll();
	
	
	void add(Course C1) throws Exception;
	void delete(Course C1);
	void update(Course 	C1, Course CNEW);
	Course getById(int id);
	
	
	

}
