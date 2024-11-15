package SpringBootProjectTest.SpringBootTest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="InternationalCurrency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternationalCurrency {

	@Id
	private String Code;
	private String Symbol;
	private String Name;
}
