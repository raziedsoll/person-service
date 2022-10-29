package liga.medical.medicalperson.core.model.pojo;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Illness {
    private int id;
    private long medicalCardId;
    private long typeId;
    private String heaviness;
    private Timestamp appearanceDttm;
    private Date recoveryDt;
}
