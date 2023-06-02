package Course.business.request.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFrameworkResponse {

	
	private int id;
	private String name;
	private int courseid;
}
