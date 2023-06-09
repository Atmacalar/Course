package Course.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Language")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int id;
	
	@Column(name="language_name")
	private String name;
	
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FrameWork> framework;
	
	
	


}
