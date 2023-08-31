package Testes.unitatrios.TestesUnitarios.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class numService {

    private List<Integer> numeros = new ArrayList<>();
    public int encontrarMaior() {
        return encontrarMaior(numeros);
    }
    public int encontrarMenor() {
        return encontrarMenor(numeros);
    }
    public void cadastrar(List<Integer> numeros) {
        this.numeros.addAll(numeros);
    }
    public double calcularMedia() {
        return calcularMedia(numeros);
    }

    public double calcularDesvioPadrao() {
        return calcularDesvioPadrao(numeros);
    }
    //Maior num
    public int encontrarMaior(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia");
        }
        int maior = numeros.get(0);

        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }
    //Menor num
    private int encontrarMenor(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia");
        }

        int menor = numeros.get(0); // Assume o primeiro número como o menor

        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }

        return menor;
    }

    //Media
    private double calcularMedia(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return (double) soma / numeros.size();
    }
    //DesvioPadrao
    private double calcularDesvioPadrao(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }
        double media = calcularMedia(numeros);
        double somadif = 0.0;
        for (int numero : numeros) {
            double diferenca = numero - media;
            somadif += diferenca * diferenca;
        }
        double variancia = somadif / numeros.size();
        return Math.sqrt(variancia);
    }
    //Mediana
    public double calcularMediana() {
        if (numeros.isEmpty()) {
            return 0.0;
        }
        List<Integer> numMeio = new ArrayList<>(numeros);
        Collections.sort(numMeio);

        int tamanho = numMeio.size();
        if (tamanho % 2 == 0) {
            int meioP = numMeio.get(tamanho / 2 - 1);
            int meioS = numMeio.get(tamanho / 2);
            return (double) (meioP + meioS) / 2;
        } else {
            return numMeio.get(tamanho / 2);
        }
    }
    //Tudo
    public String calcularEstatisticas() {
        double media = calcularMedia();
        double desvioPadrao = calcularDesvioPadrao();
        double mediana = calcularMediana();
        int maior = encontrarMaior();
        int menor = encontrarMenor();

        String mensagem = "Maior Valor: " + maior + "\nMenor Valor: " + menor + "\nValor Minimo: " + "\nMédia: " + media + "\nDesvio Padrão: " + desvioPadrao + "\nMediana: " + mediana;

        return mensagem;
    }
}
