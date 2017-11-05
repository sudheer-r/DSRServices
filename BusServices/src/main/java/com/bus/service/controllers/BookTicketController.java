package com.bus.service.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bus.service.beans.Ticket;
import com.bus.service.validators.BookTicketValidator;

@Controller
public class BookTicketController {
	private final static Logger L_LOGGER=Logger.getLogger(BookTicketController.class);
	
	@Autowired
	@Qualifier("ticketValidator")
	public BookTicketValidator ticketValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(ticketValidator);
	}

	@GetMapping("/book")
	public String viewBookingPage(Model model) {
		L_LOGGER.info("Get request for /book ");
		List<String> sources = new ArrayList<>();
		List<String> destinations = new ArrayList<>();
		List<String> travelsList = new ArrayList<>();

		sources.add("Anantapur");
		sources.add("Kurnool");
		sources.add("Tirupati");
		sources.add("Kadapa");
		sources.add("Hyderabad");

		destinations.add("Anantapur");
		destinations.add("Kurnool");
		destinations.add("Tirupati");
		destinations.add("Kadapa");
		destinations.add("Hyderabad");

		travelsList.add("Jabbar");
		travelsList.add("SRS");
		travelsList.add("Orange");
		travelsList.add("Diwakar");
		travelsList.add("PVK");
		model.addAttribute("sources", sources);
		model.addAttribute("destinations", destinations);
		model.addAttribute("travelsList", travelsList);
		model.addAttribute("ticket", new Ticket());
		return "Book";
	}

	@PostMapping("/book")
	public String bookTicket(@Valid @ModelAttribute("ticket") Ticket ticket, Model model) {
		L_LOGGER.info("Post request for /book");
		model.addAttribute("ticket", ticket);
		return "Ticket";
	}

}
