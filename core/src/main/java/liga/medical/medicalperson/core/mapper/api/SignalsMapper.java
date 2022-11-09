package liga.medical.medicalperson.core.mapper.api;

import liga.medical.dto.RabbitMessageDto;
import liga.medical.medicalperson.core.model.entity.Signals;

public interface SignalsMapper {
    Signals toEntity(RabbitMessageDto messageDto);
}
