package lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.mail.MessagingException;
import lms.dto.RequestEnddatedto;
import lms.services.RequestEndDateService;

@RestController
public class RequestEnddateController {

	@Autowired
	private RequestEndDateService requestEndDateService;

	@GetMapping("/getenddateextensions")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<RequestEnddatedto> getbookextensions() {
		return requestEndDateService.getbookextensions();
	}

	@PostMapping("/accandrejectextension/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String acceptandreject(@RequestParam("value") int value, @PathVariable("id") long id)
			throws MessagingException {
		return requestEndDateService.acceptandreject(id, value);
	}

	@GetMapping("/addextension/{issueId}")
	public String acceptandreject(@PathVariable("issueId") long issueId) {
		return requestEndDateService.addRequestEndExtension(issueId);
	}

}