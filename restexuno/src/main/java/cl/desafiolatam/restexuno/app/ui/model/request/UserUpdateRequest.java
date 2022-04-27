package cl.desafiolatam.restexuno.app.ui.model.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
	private String firstName;
	private String lastName;
	private String email;
}
