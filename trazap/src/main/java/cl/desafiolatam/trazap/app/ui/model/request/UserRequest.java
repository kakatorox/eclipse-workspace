package cl.desafiolatam.trazap.app.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private int idUsers;
	private String email;
	private int rolsId;
	private String password;
}
