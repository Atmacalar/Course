package Course.dataAcces.Abstract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Course.entities.concretes.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	
	
	
	

}
