package liga.medical.medicalperson.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.medicalperson.core", "liga.medical.common.service"})
@EnableAspectJAutoProxy
public class MedicalPersonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalPersonApplication.class, args);
    }
}
