package Course.webApi.contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Course.business.Abstract.CourseService;
import Course.entities.concretes.Course;


@RestController
@RequestMapping("api/course")
public class CourseContraller {
	
	
	private CourseService coursesservice;

	@Autowired
	public CourseContraller(CourseService coursesservice) {
		this.coursesservice=coursesservice;
	}
	
	
	@GetMapping("/getAll")
	public List<Course> getAll(){
		
	return  coursesservice.getAll();
		
	}
	
	@GetMapping("/add")
	public void add(Course Cl) throws Exception{
		coursesservice.add(Cl);
	}
	
	@GetMapping("/delete")
	public void delete(Course Cl) {
		coursesservice.delete(Cl);
	}
	
	@GetMapping("/update")
	public void update(Course Cl, Course CNEW) throws Exception{
		coursesservice.update(Cl, CNEW);
	}
	
	@GetMapping("/getbyid")
	public Course getById(int id) {
		return coursesservice.getById(id);
	}
	
	

}
