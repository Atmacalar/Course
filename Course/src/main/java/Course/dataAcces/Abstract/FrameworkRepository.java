package Course.dataAcces.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;

import Course.entities.concretes.Course;
import Course.entities.concretes.FrameWork;

public interface FrameworkRepository extends JpaRepository<FrameWork, Integer> {

}
