package Testes.unitatrios.TestesUnitarios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Testes.unitatrios.TestesUnitarios.Service.numService;
import Testes.unitatrios.TestesUnitarios.Entity.num;
@RestController
@RequestMapping(value = "/api/teste")
public class numController {

    @Autowired
    private numService service;

    @PostMapping("/inserir")
    public ResponseEntity<String> cadastrar(@RequestBody num numeros) {
        try {
            service.cadastrar(numeros.getNumero());
            return ResponseEntity.ok("Números cadastrados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar números: " + e.getMessage());
        }
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<String> calcularEstatisticas() {
        try {
            String estatisticas = service.calcularEstatisticas();
            return ResponseEntity.ok(estatisticas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao calcular estatísticas: " + e.getMessage());
        }
    }
}