package io.github.mateusesp.arquiteturaspring.montadora.configuration;

import io.github.mateusesp.arquiteturaspring.montadora.Motor;
import io.github.mateusesp.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorTurbo")
    @Primary
    public Motor motorTurbo() {
        Motor motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("CVT-TURBO");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        Motor motor = new Motor();
        motor.setCavalos(150);
        motor.setCilindros(4);
        motor.setModelo("CVT-ELETRIC");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
        Motor motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(4);
        motor.setModelo("CVT-DEFAULT");
        motor.setLitragem(1.8);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
}
