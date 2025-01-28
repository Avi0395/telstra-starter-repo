package au.com.telstra.simcardactivator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.Service.SimCardService;
import au.com.telstra.simcardactivator.model.SimActivationRequest;

@RestController
@RequestMapping("/sim")
public class SimCardController {
	@Autowired
	private SimCardService simCardService;

	@PostMapping("/activate")
	public ResponseEntity<String> activateSim(@RequestBody SimActivationRequest request) {
		boolean isActivated = simCardService.activateSim(request);
		if (isActivated) {
			return ResponseEntity.ok("SIM activated successfully!");
		} else {
			return ResponseEntity.status(500).body("SIM activation failed.");
		}
	}
}
