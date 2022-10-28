package liga.medical.medicalperson.core.model.pojo;

import lombok.Data;

@Data
public class Address {
    private int id;
    private long countryId;
    private String city;
    private long index;
    private String street;
    private String building;
    private String flat;
    private long contactId;
}
