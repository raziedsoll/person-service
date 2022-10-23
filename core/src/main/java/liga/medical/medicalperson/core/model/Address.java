package liga.medical.medicalperson.core.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "country_id")
    private long countryId;

    @Column(name = "city")
    private String city;

    @Column(name = "index")
    private long index;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private String flat;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Address(long countryId, String city, long index, String street, String building, String flat) {
        this.countryId = countryId;
        this.city = city;
        this.index = index;
        this.street = street;
        this.building = building;
        this.flat = flat;
        this.contact = contact;
    }
}
