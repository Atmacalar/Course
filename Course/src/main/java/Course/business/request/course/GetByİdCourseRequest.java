package Course.business.request.course;

import Course.dataAcces.Abstract.CourseRepository;
import Course.entities.concretes.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByİdCourseRequest {
	
	
	private String name;
	
	

}
