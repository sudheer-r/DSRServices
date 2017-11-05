package com.bus.service.validators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bus.service.beans.Ticket;

@Component("ticketValidator")
public class BookTicketValidator implements Validator {
	private static final Logger logger = Logger.getLogger(BookTicketValidator.class);
	private static final String TICKET_DATE_PATTERN = "yyyy-MM-dd";

	@Override
	public boolean supports(Class<?> clazz) {
		return Ticket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object ticket, Errors errors) {
		logger.info("validating Ticket form object...!");
		if (!(getCurrentDate().equals(((Ticket) ticket).getDate1()))) {
			logger.info("Invalid date for ticket ..."+((Ticket) ticket).getDate1());
			errors.rejectValue("date1", "book.ticket.date.invalid");

		}
	}

	private String getCurrentDate() {
		DateFormat format = new SimpleDateFormat(TICKET_DATE_PATTERN);
		return format.format(new Date());
	}

}
