package Course.webApi.contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Course.business.Abstract.FrameworkService;
import Course.business.request.framework.CreateFrameworkRequest;
import Course.business.request.framework.GetByIdFramework;
import Course.business.request.framework.UpdateFrameworkResponse;
import Course.business.responses.GetAllFrameworkResponse;

@RestController
@RequestMapping("/api/framework")
public class FrameworkController {
	
	private FrameworkService frameworkservice;
    
	@Autowired
	public FrameworkController(FrameworkService frameworkservice) {
		
		this.frameworkservice = frameworkservice;
	}
	
	@GetMapping("/getall")
	public List<GetAllFrameworkResponse> getAll(){
		
		
		
		return frameworkservice.getAll();
		
  }
	
  @PostMapping("/add")
  public void add(@RequestBody CreateFrameworkRequest createFrameworkRequest) throws Exception{
		
		frameworkservice.add(createFrameworkRequest);
	}
  
  @PostMapping("/delete")
  public void delete (int id) {
	  
	  frameworkservice.delete(id);
  }
	
  @PostMapping("/update")
	public void update(@RequestBody UpdateFrameworkResponse updateFrameworkResponse) {
		
		frameworkservice.update(updateFrameworkResponse);
		
	}
  
  @GetMapping("/getbyid")
  public GetByIdFramework getById(int id) {
	  
	return frameworkservice.getById(id);
	  
	  
	  
  }
  
  
}
