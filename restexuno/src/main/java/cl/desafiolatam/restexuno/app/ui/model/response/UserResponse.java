package cl.desafiolatam.restexuno.app.ui.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserResponse {
	private String userID;
	private String firstName;
	private String lastName;
	private String email;

}
