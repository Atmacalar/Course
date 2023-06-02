package Course.business.responses;

import Course.entities.concretes.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFrameworkResponse {
	
	private int id;
	
	private String name;
	
	private Course Course;

}
