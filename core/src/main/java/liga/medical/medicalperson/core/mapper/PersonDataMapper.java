package liga.medical.medicalperson.core.mapper;

import liga.medical.medicalperson.core.model.pojo.PersonData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDataMapper {
    @Insert("insert into person_data " +
            "values(#{id},#{lastName},#{firstName},#{birthDt}," +
            "#{age},#{sex},#{contactId},#{medicalCardId},#{parentId})")
    int postPersonData(PersonData personData);

    @Select("select * from person_data where id=#{id}")
    PersonData getPersonDataById(int id);

    @Select("select * from person_data;")
    List<PersonData> getAllPersonData();

    @Delete("delete from person_data where id=#{id};")
    void deletePersonData(int id);
}
