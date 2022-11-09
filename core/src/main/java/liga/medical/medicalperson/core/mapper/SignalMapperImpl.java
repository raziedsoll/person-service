package liga.medical.medicalperson.core.mapper;

import liga.medical.dto.RabbitMessageDto;
import liga.medical.medicalperson.core.model.entity.Signals;
import liga.medical.medicalperson.core.mapper.api.SignalsMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SignalMapperImpl implements SignalsMapper {
    @Override
    public Signals toEntity(RabbitMessageDto messageDto) {
        Signals signals = new Signals();
        signals.setPersonDataId(messageDto.getId());
        signals.setDescription(messageDto.getContent());
        signals.setType(String.valueOf(messageDto.getMessageType()));
        return signals;
    }
}
