package Course.webApi.contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Course.business.Abstract.CourseService;
import Course.business.request.course.CreateCourseRequest;
import Course.business.request.course.DeleteCourseRequest;
import Course.business.request.course.GetByİdCourseRequest;
import Course.business.request.course.UpdateCourseRequest;
import Course.business.responses.GetAllCoursesResponse;
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
	public List<GetAllCoursesResponse> getAll(){
		
	return  coursesservice.getAll();
		
	}
	
	@PostMapping("/add")
	public void add(CreateCourseRequest Cl) throws Exception{
		coursesservice.add(Cl);
		
		//courseServicede'ki add fonksiyonuna bu parametreyi yolla
	}
	
	@PostMapping("/delete")
	public void delete(int id) {
		coursesservice.delete(id);
	}
	
	@GetMapping("/update")
	public void update(UpdateCourseRequest Cl) throws Exception{
		coursesservice.update(Cl);
	}
	
	@GetMapping("/getbyid")
	public GetByİdCourseRequest getById(int id) {
		return coursesservice.getById(id);
	}
	
	

}
