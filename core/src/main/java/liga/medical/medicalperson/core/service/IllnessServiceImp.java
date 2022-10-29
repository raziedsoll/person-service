package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.mapper.IllnessMapper;
import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImp implements IllnessService {

    private final IllnessMapper illnessMapper;

    @Autowired
    IllnessServiceImp(IllnessMapper illnessMapper) {
        this.illnessMapper = illnessMapper;
    }

    @Override
    public List<Illness> getAllIllness() {
        return illnessMapper.getAllIllness();
    }

    @Override
    public int postIllness(Illness illness) {
        return illnessMapper.postIllness(illness);
    }
}
