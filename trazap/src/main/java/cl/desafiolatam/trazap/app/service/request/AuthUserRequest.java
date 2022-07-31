package cl.desafiolatam.trazap.app.service.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserRequest {
	private String email;
	private String password;
}
