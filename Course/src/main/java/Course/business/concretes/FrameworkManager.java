package Course.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Course.business.Abstract.FrameworkService;
import Course.business.request.framework.CreateFrameworkRequest;
import Course.business.request.framework.GetByIdFramework;
import Course.business.request.framework.UpdateFrameworkResponse;
import Course.business.responses.GetAllFrameworkResponse;
import Course.dataAcces.Abstract.CourseRepository;
import Course.dataAcces.Abstract.FrameworkRepository;
import Course.entities.concretes.Course;
import Course.entities.concretes.FrameWork;

@Service
public class FrameworkManager implements FrameworkService {
	
	private FrameworkRepository frameworkrepo;
	private CourseRepository courserepo;
	
    //framework işlemlerinde ait olduğu dili  courserepo'dan çekiyoruz


	
	public FrameworkManager(FrameworkRepository frameworkrepo, CourseRepository courserepo) {
		
		this.frameworkrepo = frameworkrepo;
		this.courserepo = courserepo;
	}

	@Override
	public List<GetAllFrameworkResponse>getAll() {
		
		List<FrameWork> framework= frameworkrepo.findAll();
		List<GetAllFrameworkResponse> responses = new ArrayList<GetAllFrameworkResponse>();
		
		for(FrameWork frame:framework) {
			
			GetAllFrameworkResponse responseItem = new GetAllFrameworkResponse();
			
			responseItem.setId(frame.getId());
			responseItem.setName(frame.getName());
			responseItem.setCourse(frame.getCourse());
			
			responses.add(responseItem);
			
		}
		
		
		return responses;
		
	}

	@Override
	public void add(CreateFrameworkRequest createFrameworkRequest) throws Exception {
	
		if(createFrameworkRequest.getName().isEmpty()) {
			
			throw new Exception("İsim boş olamaz");
		}
		
		for(GetAllFrameworkResponse getAllResponse:getAll()) {
			
			if(createFrameworkRequest.getName().equals(getAllResponse.getName())) {
				
				throw new Exception("Dil zaten Mevcut");
			}
		}         
		
		FrameWork framework= new FrameWork();
		
		
		framework.setName(createFrameworkRequest.getName());
	    framework.setCourse(courserepo.findById(createFrameworkRequest.getCourseid()).get());
	    
	    frameworkrepo.save(framework);
	    
	    
	  //parametredeki id ile courserepo içerisinde arama yapıp bulduğun dilin id'sini 
	  		//framework.course'ye atıp ait olduğu dili belirtiyorsun
	
	}

	@Override
	public void delete(int id) {
	
		frameworkrepo.deleteById(id);
		
	}

	@Override
	public void update(UpdateFrameworkResponse updateframeworkreesponse) {
		
		FrameWork framework = frameworkrepo.findById(updateframeworkreesponse.getCourseid()).get();
		framework.setName(updateframeworkreesponse.getName());
		framework.setCourse(courserepo.findById(updateframeworkreesponse.getCourseid()).get());
		
		frameworkrepo.save(framework);
		
		
		//parametredeki id ile courserepo içerisinde arama yapıp bulduğun dilin id'sini 
		//framework.course'ye atıp ait olduğu dili belirtiyorsun
	}

	@Override
	public GetByIdFramework getById(int id) {
		
	FrameWork framework = frameworkrepo.findById(id).get();
	
	GetByIdFramework request = new GetByIdFramework();
	
	request.setName(framework.getName());
	request.setCourse(framework.getCourse());
	
		return request;
	}

}
