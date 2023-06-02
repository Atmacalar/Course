package Course.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Course.business.Abstract.CourseService;
import Course.business.request.course.CreateCourseRequest;
import Course.business.request.course.GetByİdCourseRequest;
import Course.business.request.course.UpdateCourseRequest;
import Course.business.responses.GetAllCoursesResponse;
import Course.dataAcces.Abstract.CourseRepository;
import Course.entities.concretes.Course;

@Service
public class CourseManager implements CourseService {
	
	
	private CourseRepository courseRepository;
	
	
    //manager çağırıldığında bir dataacces classı istiyorum
	public CourseManager(CourseRepository courseRepository) {
		
		this.courseRepository = courseRepository;
	}

	@Override
	public List<GetAllCoursesResponse> getAll() {
	
		List<Course> courses= courseRepository.findAll();
		List<GetAllCoursesResponse> responses = new ArrayList<GetAllCoursesResponse>();
		
	for(Course course1: courses) {
		
		
		GetAllCoursesResponse responseItem = new GetAllCoursesResponse();
		
		
		responseItem.setId(course1.getId());
		responseItem.setName(course1.getName());
		
		responses.add(responseItem);
		
	}
		
		return responses;
		
		//Bir entiti listesi oluşturup findALL metoduyla listeye ekliyorum
		 //birde response listesi oluşturdum. 
		//Göstermek istedğim parametreleri db listesinden response listesine aktardım
		
		
		
	}

	@Override
	public void add(CreateCourseRequest createCourserequest) throws Exception {
		
		if(createCourserequest.getName().isEmpty()) {
			
			throw new Exception("isim boş olamaz");
		}
		
		for(GetAllCoursesResponse getAllResponse : getAll() ) {
			
			if(createCourserequest.getName().equals(getAllResponse.getName())){
				
			     throw new Exception("Kurs zaten mevcut");
			}
					
	}
		
		Course course = new Course();
		
		course.setName(createCourserequest.getName());
		
		courseRepository.save(course);
		
		//entities nesnesi yaratıyorum, nesnenin ismini gelen parametreden alıyorum
		//ve repoya kaydediyorum
            
	
	}

	@Override
	public void delete(int id) {
	
		courseRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateCourseRequest updateCourseRequest) throws Exception {
	
		if(updateCourseRequest.getName().isEmpty()) {
			
			throw new Exception("isim boş olamaz");
			
		}
		
		
		for(GetAllCoursesResponse response:getAll()){
			
			if(updateCourseRequest.getName().equals(response.getName())) {
				
				throw new Exception("Kurs ismi tekrar edemez");
				
			}
		}
		
		Course course= courseRepository.findById(updateCourseRequest.getId()).get();
		
		course.setName(updateCourseRequest.getName());
		
		courseRepository.save(course);
	}

	@Override
	public GetByİdCourseRequest getById(int id) {
	
	GetByİdCourseRequest request= new GetByİdCourseRequest();
		 
		Course course = courseRepository.findById(id).get();
		
	
		request.setName(course.getName());
		return request;

		
		
		
	}

	
	
	

}
