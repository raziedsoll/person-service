package liga.medical.medicalperson.core.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "auth_logs", schema = "medical_schema")
@Getter
@Setter
@NoArgsConstructor
public class AuthLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "successfully")
    private boolean successfully;

    @Column(name = "data_time")
    private Timestamp dataTime;

    public AuthLog(String name, boolean successfully, Timestamp dataTime) {
        this.username = name;
        this.successfully = successfully;
        this.dataTime = dataTime;
    }
}
