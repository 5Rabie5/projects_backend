package at.nacs.phonbook.communication;

import at.nacs.phonbook.logic.ContactManager;
import at.nacs.phonbook.persistence.domain.Contact;
import at.nacs.phonbook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ContactEndPointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    ContactManager contactManager;
    @MockBean
    ContactRepository contactRepository;

    @Test
    void get() {

        restTemplate.getForObject("/contacts", Contact[].class);
        verify(contactManager).displayAll();
    }

    @Test
    void getByAdress() {

        restTemplate.getForObject("/contacts/address/ddd"  , Contact[].class);
        verify(contactManager).displayAllLikeAddress(Mockito.anyString());
    }

    @Test
    void store() {

        Contact contact = new Contact();
        restTemplate.postForObject("/contacts", contact,Contact.class);
        verify(contactManager).store(contact);
    }
}
