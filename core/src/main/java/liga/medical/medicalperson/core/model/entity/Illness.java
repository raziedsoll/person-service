package liga.medical.medicalperson.core.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "illness")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private String heaviness;

    @Column(name = "appearance_dttm", nullable = false, updatable = false)
    private Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private Date recoveryDt;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id", nullable = false, updatable = false)
    @JsonBackReference
    private MedicalCard medicalCard;
}
