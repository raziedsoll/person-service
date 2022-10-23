package liga.medical.medicalperson.core.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "illness")
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private String heaviness;

    @Column(name = "appearance_dttm")
    private java.sql.Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private java.sql.Date recoveryDt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;

    public Illness(long typeId, String heaviness, Timestamp appearanceDttm, Date recoveryDt) {
        this.typeId = typeId;
        this.heaviness = heaviness;
        this.appearanceDttm = appearanceDttm;
        this.recoveryDt = recoveryDt;
    }
}
