package at.nacs.phonbook.logic;

import at.nacs.phonbook.persistence.domain.Address;
import at.nacs.phonbook.persistence.domain.Contact;
import at.nacs.phonbook.persistence.repository.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class ContactManagerTest {

    @Autowired
    ContactManager contactManager;

    @Autowired
    ContactRepository contactRepository;
    Address address1 = Address.builder().name("ste_la").build();
    Contact contact = Contact.builder().name("rabie").address(address1).build();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        contactRepository.deleteAll();
        contactRepository.save(contact);
    }

    @Test
    void store() {
        contactManager.store(contact);
        assertThat(contact.getId()).isNotNull();
    }

    @Test
    void displayAll() {
        assertThat(contactManager.displayAll().size()).isEqualTo(1);
    }

    @Test
    void displayAllLikeAddress() {
        assertThat(contactManager.displayAllLikeAddress("ste_la")).isNotEmpty();
    }
}