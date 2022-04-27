package cl.desafiolatam.restexuno.app.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRequest {
	@NotNull(message = "Primer nombre No puede Ser Nulo")
	private String firstName;
	@NotNull(message = "Last nombre No puede Ser Nulo")
	private String lastName;
	@NotNull(message = "email nombre No puede Ser Nulo")
	@Email(message="formato de email no es correcto")
	private String email;
	@Size(min = 4,max = 10,message="la password debe tener entre 4 y 10 caracteres")
	
	private String password;
}
