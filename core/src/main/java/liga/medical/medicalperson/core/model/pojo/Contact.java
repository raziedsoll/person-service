package liga.medical.medicalperson.core.model.pojo;

import lombok.Data;

@Data
public class Contact {
    private int id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
