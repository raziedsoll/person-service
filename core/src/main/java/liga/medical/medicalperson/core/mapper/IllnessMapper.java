package liga.medical.medicalperson.core.mapper;

import liga.medical.medicalperson.core.model.pojo.Illness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IllnessMapper {
    @Select("Select * from illness")
    List<Illness> getAllIllness();

    @Insert("Insert into illness (medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) " +
            "values (#{medicalCardId}, #{typeId}, #{heaviness}, #{appearanceDttm}, #{recoveryDt});")
    int postIllness(Illness illness);
}
