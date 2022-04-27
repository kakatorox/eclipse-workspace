package cl.desafiolatam.restexuno.app.ui.api.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.restexuno.app.ui.model.request.UserRequest;
import cl.desafiolatam.restexuno.app.ui.model.request.UserUpdateRequest;
import cl.desafiolatam.restexuno.app.ui.model.response.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {
	/*GET, POT, PUT, DELETE*/
	private Map<String, UserResponse> users;
	private List<UserResponse> usersList;
	
//	
//	
//	Con este metodo se hacen las api inmmeriatamnete
//	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserResponse>> getUser() {
		
//		List<UserResponse> userList = new ArrayList<UserResponse>();
//		
//		UserResponse user1= new UserResponse();
//		user1.setUserID("1");
//		user1.setNombre("KAKATO");
//		user1.setLastName("ROX");
//		user1.setEmail("casitaägmail.com");
//		userList.add(user1);
//		UserResponse user2= new UserResponse();
//		user2.setUserID("2");
//		user2.setNombre("igfnacio");
//		user2.setLastName("fOX");
//		user2.setEmail("crestaägmail.com");
//		userList.add(user2);
//		UserResponse user3= new UserResponse();
//		user3.setUserID("3");
//		user3.setNombre("lavida");
//		user3.setLastName("r5uda");
//		user3.setEmail("muereciotaägmail.com");
//		userList.add(user3);
//		
//		HashMap<String, ArrayList<UserResponse>> mapResponse = new HashMap<String, ArrayList<UserResponse>>();
//		
//		mapResponse.put("userList", (ArrayList<UserResponse>)userList);
		
//		return new ResponseEntity<HashMap<String, ArrayList<UserResponse>>>((HashMap<String, ArrayList<UserResponse>>) mapResponse, HttpStatus.OK);
		if (users == null) {
//			return new ResponseEntity<HashMap<String,UserResponse>> (HttpStatus.NO_CONTENT);
			return new ResponseEntity<ArrayList<UserResponse>> (HttpStatus.NO_CONTENT);
		}else {
//			return new ResponseEntity<HashMap<String,UserResponse>> ((HashMap<String, UserResponse>) users,HttpStatus.OK);
			return new ResponseEntity<ArrayList<UserResponse>> ( (ArrayList<UserResponse>) this.usersList,HttpStatus.OK);
		}			
	}
	
	@GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		if (!this.users.containsKey(userId)) {
			return new ResponseEntity<UserResponse> (HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<UserResponse> (this.users.get(userId),HttpStatus.OK);
		}			
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<List<UserResponse>> createUser(@Valid @RequestBody UserRequest userRequest){
		
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setEmail(userRequest.getEmail());
		
		String userId = UUID.randomUUID().toString();
		userResponse.setUserID(userId);
		
		if (this.users == null) {
			this.users = new HashMap<String, UserResponse>();
			this.usersList = new ArrayList<UserResponse>();
		}
		
		users.put(userId, userResponse);
		usersList.add(userResponse);
		 	
		
		return new ResponseEntity<List<UserResponse>>(usersList, HttpStatus.CREATED);
		
	}
	
	@PostMapping(path="/{userId}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<List<UserResponse>> deleteUser(@PathVariable String userId){
		
		
		if (this.users == null) {
			this.users = new HashMap<String, UserResponse>();
			this.usersList = new ArrayList<UserResponse>();
		}
		
		//users.put(userId, userResponse);
		int i = 0;
		for (UserResponse userResponse2 : usersList) {
			if (userId.equals(userResponse2.getUserID())) {
				usersList.remove(i);
				break;
			}
			i++;
		}
		
		
		return new ResponseEntity<List<UserResponse>>(usersList, HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping(path="/update/{userId}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<List<UserResponse>> updateUsers(@PathVariable String userId,@RequestBody UserRequest userRequest){
		
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setEmail(userRequest.getEmail());
		userResponse.setUserID(userId);
		
		if (this.users == null) {
			this.users = new HashMap<String, UserResponse>();
			this.usersList = new ArrayList<UserResponse>();
		}
		
		//users.put(userId, userResponse);
		int i = 0;
		for (UserResponse userResponse2 : usersList) {
			if (userId.equals(userResponse2.getUserID())) {
				usersList.set(i, userResponse);
			}
			i++;
		}
		
		
		return new ResponseEntity<List<UserResponse>>(usersList, HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping(
				path = "{userId}",				
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE
				)
	public UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest userUpdateRequest) {
		
		UserResponse UserResponse = users.get(userId);
		UserResponse.setFirstName(userUpdateRequest.getFirstName());
		UserResponse.setLastName(userUpdateRequest.getLastName());
		UserResponse.setEmail(userUpdateRequest.getEmail());
		
		users.put(userId, UserResponse);
		
		return UserResponse;
	}
	
	@DeleteMapping(path = "{userId}")

	public ResponseEntity<Void> deletUser(@PathVariable String userId){
		usersList.remove(users.get(userId));
		users.remove(userId);
		return ResponseEntity.noContent().build();	
			}
	
}
