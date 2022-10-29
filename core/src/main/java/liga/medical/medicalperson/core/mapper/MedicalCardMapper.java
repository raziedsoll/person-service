package liga.medical.medicalperson.core.mapper;

import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.model.pojo.MedicalCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardMapper {

    @Select("Select * from medical_card")
    List<MedicalCard> getAllMedicalCard();

    @Select("Select * from illness where id = #{medical_card_id}")
    List<Illness> getMedicalCardById(int medicalCardId);

    @Insert("Insert into medical_card (client_status, med_status, registry_dt, comment) " +
            "values (#{clientStatus}, #{medStatus}, #{registryDt}, #{comment})")
    int postMedicalCard(MedicalCard medicalCard);
}
