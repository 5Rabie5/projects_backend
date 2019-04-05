package at.nacs.phonbook.communication;

import at.nacs.phonbook.logic.ContactManager;
import at.nacs.phonbook.persistence.domain.Address;
import at.nacs.phonbook.persistence.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
@RequiredArgsConstructor
public class ContactEndPoint {

    private final ContactManager contactManager;

    @GetMapping
    List<Contact> get() {
        return contactManager.displayAll();
    }

    @GetMapping("/address/{address}")
    List<Contact> getByAdress(@PathVariable String address) {
        return contactManager.displayAllLikeAddress(address);
    }

    @PostMapping
    Contact store(@RequestBody Contact contact) {
         contactManager.store(contact);
        return contact;
    }

}
