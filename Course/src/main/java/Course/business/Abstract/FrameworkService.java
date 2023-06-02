package Course.business.Abstract;

import java.util.List;

import Course.business.request.framework.CreateFrameworkRequest;
import Course.business.request.framework.GetByIdFramework;
import Course.business.request.framework.UpdateFrameworkResponse;
import Course.business.responses.GetAllFrameworkResponse;

public interface FrameworkService  {

	
	List<GetAllFrameworkResponse> getAll();
	 
	 void add(CreateFrameworkRequest createFrameworkRequest) throws Exception;
	 
	 void delete(int id);
	 
	 void update(UpdateFrameworkResponse updateframeworkreesponse);
	 
	 GetByIdFramework getById(int id);
	
	
}
