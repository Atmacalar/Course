package Course.business.Abstract;

import java.util.List;

import Course.business.request.course.CreateCourseRequest;
import Course.business.request.course.GetByİdCourseRequest;
import Course.business.request.course.UpdateCourseRequest;
import Course.business.responses.GetAllCoursesResponse;
import Course.entities.concretes.Course;


public interface CourseService {
	
	//Business manager'da artık request ve response ile çalışıyorum notlarımda'ki prensibten dolayı

 List<GetAllCoursesResponse> getAll();
 
 void add(CreateCourseRequest createCourserequest) throws Exception;
 
 void delete(int id);
 
 void update(UpdateCourseRequest updateCourseRequest) throws Exception;
 
 GetByİdCourseRequest getById(int id);
	
}
