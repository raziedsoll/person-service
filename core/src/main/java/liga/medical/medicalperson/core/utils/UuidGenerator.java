package liga.medical.medicalperson.core.utils;

import java.util.UUID;

public class UuidGenerator {
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
