package io.github.mateusesp.arquiteturaspring.montadora.api;

import io.github.mateusesp.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carros")
public class TesteFabricaController {

    @Autowired
    @Qualifier("motorTurbo")
    private Motor motor;

    @PostMapping
    public CarroStatus startEngine(@RequestBody Chave chave) {
        Carro carro = new HondaHRV(motor);
        return carro.startEngine(chave);
    }
}
