package Testes.unitatrios.TestesUnitarios;
import Testes.unitatrios.TestesUnitarios.Service.numService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class Testes {
    private numService service;

    @Before

    public void setUp() {
        service = new numService();
    }

    @Test
    public void TesteMedia() {
        service.cadastrar(List.of(1, 2, 3));
        double media = service.calcularMedia();
        Assert.assertEquals(2.0, media, 0.001);
    }

    @Test
    public void TesteMediaEmpty() {
        double media = service.calcularMedia();
        Assert.assertEquals(0.0, media, 0.001);
    }

    @Test
    public void TesteDesvio() {
        service.cadastrar(List.of(1, 2, 3, 4, 5));
        double desvioPadrao = service.calcularDesvioPadrao();
        Assert.assertEquals(1.4142135623730951, desvioPadrao, 0.001);
    }

    @Test
    public void TesteDesvioPadraoEmpty() {
        double desvioPadrao = service.calcularDesvioPadrao();
        Assert.assertEquals(0.0, desvioPadrao, 0.001);
    }
    @Test
    public void TesteMedianaEmpty() {
        double mediana = service.calcularMediana();
        Assert.assertEquals(0.0, mediana, 0.001);
    }
    @Test
    public void TesteMaiorValor() {
        service.encontrarMaior(List.of(10, 7, 4, 1, 22, 25));
        Assert.assertEquals(0.0, 0.001);
    }
    @Test
    public void TesteMenorValor() {
        service.encontrarMaior(List.of(10, 7, 4, 1, 22, 25));
        Assert.assertEquals(0.0, 0.001);
    }

    @Test
    public void TesteString() {
        service.cadastrar(List.of(1, 2, 3, 4, 5));
        String estatisticas = service.calcularEstatisticas();
        String expected = "Média: 3.0\nDesvio Padrão: 1.4142135623730951\nMediana: 3.0";
        Assert.assertEquals(expected, estatisticas);
    }

}

