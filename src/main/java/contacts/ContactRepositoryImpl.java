package contacts;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactRepositoryImpl implements ContactRepository {
    private List<Contact> contacts = new ArrayList<Contact>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public void save(Contact contact) {
        contacts.add(contact);
    }
}
