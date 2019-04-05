package at.nacs.phonbook.logic;

import at.nacs.phonbook.persistence.domain.Contact;
import at.nacs.phonbook.persistence.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository contactRepository;

    public Contact store(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    public List<Contact> displayAll(){
        return contactRepository.findAll();
    }

    public List<Contact> displayAllLikeAddress(String name){
    //  Address address = Address.builder().name(name).build();
        name = "%" + name + "%";
        return contactRepository.findAllByAddressNameLike(name);
    }
}
