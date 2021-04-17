package com.zohar.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class EmailsController implements WebMvcConfigurer {

    private final EmailsService emailsService;

    @Autowired
    public EmailsController(EmailsService emailsService) {
        this.emailsService = emailsService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/failure").setViewName("failure");
    }

    @GetMapping("/")
    public String displayForm(SendEmailForm sendEmailForm) {
        return "form";
    }

    @PostMapping("/api/emails/send")
    public String sendEmail(@Valid SendEmailForm sendEmailForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        try {
            String providerName = emailsService.determineProvider(sendEmailForm.getFrom());
            emailsService.sendEmail(providerName, sendEmailForm);
            return "redirect:/success?providerName=" + providerName;
        } catch (Exception error) {
            return "redirect:/failure";
        }

    }
}
