/**
 * Created on Dec 23, 2011
 */
package info.halo9pan.examples.prospring3.ch17.web.controller;

import info.halo9pan.examples.prospring3.ch17.web.form.Message;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Clarence
 *
 */
@RequestMapping("/security")
@Controller
public class SecurityController {

	final Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel, Locale locale) {
		logger.info("Login failed detected");
		uiModel.addAttribute("message", new Message("error", messageSource
				.getMessage("message_login_fail", new Object[] {}, locale)));
		return "contacts/list";
	}

}
