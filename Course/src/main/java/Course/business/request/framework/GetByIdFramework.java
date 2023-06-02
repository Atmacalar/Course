package Course.business.request.framework;

import Course.entities.concretes.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFramework {

	
	
	private String name;
	
	private Course course;
}
