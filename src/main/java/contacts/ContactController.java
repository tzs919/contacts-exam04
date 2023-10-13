package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class ContactController {

    private ContactRepository contactRepo;

    @Autowired
    public ContactController(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @ModelAttribute(name = "contact")
    public Contact contact() {
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public Iterable<Contact> contacts() {
        Iterable<Contact> contacts = contactRepo.findAll();
        return contacts;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@Valid Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            return "home";
        } else {
            contactRepo.save(contact);
            return "redirect:/add";
        }
    }
}