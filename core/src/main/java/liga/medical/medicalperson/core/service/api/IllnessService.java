package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.pojo.Illness;

import java.util.List;

public interface IllnessService {
    List<Illness> getAllIllness();

    int postIllness(Illness illness);
}
