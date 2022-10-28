package liga.medical.medicalperson.core.model.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class MedicalCard {
    private int id;
    private String clientStatus;
    private String medStatus;
    private Date registryDt;
    private String comment;
}
