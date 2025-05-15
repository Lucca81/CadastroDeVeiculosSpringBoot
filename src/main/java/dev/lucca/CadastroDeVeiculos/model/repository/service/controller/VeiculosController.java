package dev.lucca.CadastroDeVeiculos.model.repository.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/veiculos")
public class VeiculosController {

    VeiculosService veiculosService;

    public VeiculosController(VeiculosService veiculosService) {
        this.veiculosService = veiculosService;
    }

    @PostMapping
    public ResponseEntity<VeiculosModel> cadastrarVeiculo(@RequestBody VeiculosModel veiculo) {
        VeiculosModel veiculoSalvo = veiculosService.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<VeiculosModel>> listarVeiculos() {
        List<VeiculosModel> veiculos = veiculosService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculosModel> buscarVeiculo(@PathVariable Long id) {
        VeiculosModel veiculo = veiculosService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculosModel> atualizarVeiculo(@PathVariable Long id, @RequestBody VeiculosModel veiculo) {
        VeiculosModel veiculoAtualizado = veiculosService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculosService.excluirId(id);
        return ResponseEntity.noContent().build();
    }




}
