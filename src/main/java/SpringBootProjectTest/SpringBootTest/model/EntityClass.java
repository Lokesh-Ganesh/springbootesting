package SpringBootProjectTest.SpringBootTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityClass {

	@Id
	@Column(name="Id")
	private int Id;
	@Column(name="Code")
	private String Code;
	@Column(name="Name")
	private String Name;
}
