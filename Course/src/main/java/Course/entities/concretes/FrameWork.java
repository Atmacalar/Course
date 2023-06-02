package Course.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="framework")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FrameWork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="frame_id")
	private int id;
	
	@Column(name="frame_name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	

}
