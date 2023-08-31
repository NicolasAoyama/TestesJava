package Testes.unitatrios.TestesUnitarios.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class num {
    private List<Integer> numero;

    public num() {
    }

    public num(List<Integer> numero) {
        this.numero = numero;
    }
}