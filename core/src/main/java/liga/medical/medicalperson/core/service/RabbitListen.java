package liga.medical.medicalperson.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.QueueNames;
import liga.medical.dto.RabbitMessageDto;
import liga.medical.medicalperson.core.annotations.DbLog;
import liga.medical.medicalperson.core.mapper.api.SignalsMapper;
import liga.medical.medicalperson.core.service.api.SignalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitListen {

    private final SignalsService signalsServiceImpl;
    private final ObjectMapper objectMapper;
    private final SignalsMapper signalsMapperImpl;

    @DbLog
    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void listenDailyQueue(String message) throws JsonProcessingException {
        RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
        signalsServiceImpl.save(signalsMapperImpl.toEntity(rabbitMessageDto));
    }

    @DbLog
    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void listenAlertQueue(String message) throws JsonProcessingException {
        RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
        signalsServiceImpl.save(signalsMapperImpl.toEntity(rabbitMessageDto));
    }
}
