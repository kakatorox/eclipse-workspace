package cl.desafiolatam.trazap.app.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private int idUser;
	private String email;
	private int rolsId;
}
