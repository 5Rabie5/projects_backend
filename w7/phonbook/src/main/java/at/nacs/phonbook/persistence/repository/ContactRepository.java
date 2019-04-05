package at.nacs.phonbook.persistence.repository;

import at.nacs.phonbook.persistence.domain.Address;
import at.nacs.phonbook.persistence.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findAllByAddressNameLike(String address);
}
