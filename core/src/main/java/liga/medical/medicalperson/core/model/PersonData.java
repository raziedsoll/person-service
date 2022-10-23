package liga.medical.medicalperson.core.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "person_data")
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_dt")
    private java.sql.Date birthDt;

    @Column(name = "age")
    private long age;

    @Column(name = "sex")
    private String sex;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id")
    private long medicalCardId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private long contactId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", columnDefinition = "check ( parent_id <> id )")
    private long parentId;

    public PersonData(String lastName, String firstName, Date birthDt, long age, String sex, long medicalCardId, long contactId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDt = birthDt;
        this.age = age;
        this.sex = sex;
        this.medicalCardId = medicalCardId;
        this.contactId = contactId;
    }
}
