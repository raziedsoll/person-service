package liga.medical.medicalperson.core.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "medical_card")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "client_status")
    private String clientStatus;

    @Column(name = "med_status")
    private String medStatus;

    @Column(name = "registry_dt")
    private java.sql.Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "medicalCard", cascade = CascadeType.ALL)
    private Set<Illness> illnessSet;

    @OneToOne(mappedBy = "medicalCardId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonData personData;

    public MedicalCard(String clientStatus, String medStatus, Date registryDt, String comment) {
        this.clientStatus = clientStatus;
        this.medStatus = medStatus;
        this.registryDt = registryDt;
        this.comment = comment;
    }

    public void addIllnessToCard(Illness illness){
        if (illnessSet == null){
            illnessSet = new HashSet<>();
        }
        illnessSet.add(illness);
        illness.setMedicalCard(this);
    }
}
