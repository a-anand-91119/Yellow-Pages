package com.anand.yellowpages.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anand.yellowpages.domain.Contact;
import com.anand.yellowpages.services.ContactService;
import com.anand.yellowpages.utilities.Constants;

/**
 * 
 * @author A Anand
 *
 */
@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = Constants.URL_CONTACT_FORM)
	public String contactForm(Model model) {
		model.addAttribute("saveContactCommand", new Contact());
		return "contactForm";
	}
	
	@RequestMapping(value = Constants.URL_CONTACT_SAVE, method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("saveContactCommand") Contact contact, Model model, HttpSession httpSession) {
		try {
			contact.setContactUserId((Long) httpSession.getAttribute("loggedInUserId"));
			contactService.saveContact(contact);
			return "redirect:contactList?action=save";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Failed to Create Contact!");
			return "contactForm";
		}
	}
	
	@RequestMapping(value = Constants.URL_CONTACT_LIST)
	public String contactList(Model model, HttpSession httpSession) {
		Long userId = (Long) httpSession.getAttribute("loggedInUserId");
		model.addAttribute("contactList", contactService.findUserContact(userId));
		return "contactList";
	}
	
	@RequestMapping(value = Constants.URL_CONTACT_DELETE)
	public String contactList(@RequestParam("contactId") Long contactId) {
		contactService.deleteSingleContact(contactId);
		return "redirect:contactList?action=delete";
	}
}
