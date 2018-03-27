package passenger;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import restExample.Bean.Passenger;
@Controller
public class PassengerApp {

	
static String URL = "http://localhost:8089/ImcsRest";
	
	
@RequestMapping(value="deletePassenger")
	private static void deletePerson(@PathVariable("id") int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + "/" + id);
	}

@RequestMapping(value="updatePassenger")
private static void updatePeson(@ModelAttribute Passenger passenger) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Passenger> entity = new HttpEntity<Passenger>(passenger);
//		restTemplate.postForObject(url, newPerson, String.class);
		ResponseEntity<Passenger> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, entity, Passenger.class);
		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			System.out.println("Person data created successfully");
		} else {
			System.out.println("Person data creation failed");
		}
	}


	private static void getPerson(int personId) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		Person person = restTemplate.getForObject(url, Person.class);
		ResponseEntity<Passenger> responseEntity = restTemplate.exchange(URL + "/" + personId, HttpMethod.GET, entity, Passenger.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());

	}
	
	
	@RequestMapping(value = "create")
	public ModelAndView user() {
		System.out.println("controller called");
		ModelAndView mv = new ModelAndView("createPassenger", "passenger", new Passenger());
		return mv;
	}
	
	@RequestMapping(value="createPassenger")
	private static Passenger createPerson(@ModelAttribute Passenger passenger) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Passenger> entity = new HttpEntity<Passenger>(passenger);
//		restTemplate.postForObject("http://localhost:8080/MySpringRest/person", newPerson, String.class);
		ResponseEntity<Passenger> responseEntity = restTemplate.exchange(URL+"addPassenger", HttpMethod.POST, entity, Passenger.class);
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("Passenger data created successfully, id: " + responseEntity.getBody().getProfileId());
			return responseEntity.getBody();
		} else {
			System.out.println("Passenger data creation failed");
			System.exit(1);
			return null;
		}
	}
}
