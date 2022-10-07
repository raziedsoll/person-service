package liga.medical.medicalperson.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.medicalperson", "liga.medical.common.service"})
public class MedicalPersonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalPersonApplication.class, args);
    }
}
