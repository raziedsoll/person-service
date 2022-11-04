package liga.medical.medicalperson.core.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;

import java.sql.Date;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medical_card")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "client_status", nullable = false)
    private String clientStatus;

    @Column(name = "med_status", nullable = false)
    private String medStatus;

    @Column(name = "registry_dt", nullable = false)
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "medicalCard", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Illness> illnessSet;

    @OneToOne(mappedBy = "medicalCard", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference
    private PersonData personData;

    public void addIllnessToCard(Illness illness) {
        if (illnessSet == null) {
            illnessSet = new HashSet<>();
        }
        illnessSet.add(illness);
        illness.setMedicalCard(this);
    }
}
