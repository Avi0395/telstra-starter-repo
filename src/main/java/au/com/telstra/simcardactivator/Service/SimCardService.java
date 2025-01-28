package au.com.telstra.simcardactivator.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.model.SimActivationRequest;

@Service
public class SimCardService {

	private final RestTemplate restTemplate = new RestTemplate();
	private final String ACTUATOR_URL = "http://localhost:8444/actuate";

	public boolean activateSim(SimActivationRequest request) {
		try {
			HttpEntity<SimActivationRequest> entity = new HttpEntity<>(request, new HttpHeaders());

			ResponseEntity<String> response = restTemplate.postForEntity(ACTUATOR_URL, entity, String.class);

			return response.getBody() != null && response.getBody().contains("true");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
