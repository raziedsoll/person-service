package liga.medical.medicalperson.core.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addressSet;

    @OneToOne(mappedBy = "contactId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonData personData;

    public Contact(String phoneNumber, String email, String profileLink) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileLink = profileLink;
    }

    public void addAdressesToContact(Address address) {
        if (addressSet == null) {
            addressSet = new HashSet<>();
        }
        addressSet.add(address);
        address.setContact(this);
    }
}
