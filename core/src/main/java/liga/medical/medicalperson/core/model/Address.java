package liga.medical.medicalperson.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "index")
    private long index;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false)
    private String building;

    @Column(name = "flat")
    private String flat;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
}
