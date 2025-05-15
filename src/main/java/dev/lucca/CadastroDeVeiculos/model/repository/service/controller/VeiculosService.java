package dev.lucca.CadastroDeVeiculos.model.repository.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculosService {
    @Autowired
    private VeiculosRepository veiculosRepository;

    public VeiculosModel save(VeiculosModel veiculo) {
        if(veiculosRepository.findByPlaca(veiculo.getPlaca()).isPresent()) {
            throw new RuntimeException("Veiculo com a placa " + veiculo.getPlaca() + " já existe");

        }
        return veiculosRepository.save(veiculo);
    }

    public List<VeiculosModel> listarVeiculos(){
        return veiculosRepository.findAll();
    }

    public Optional<VeiculosModel> buscarPorId(Long id){
        return veiculosRepository.findById(id);
    }

    public void excluirId(Long id){
        veiculosRepository.deleteById(id);
    }

    public VeiculosModel atualizarVeiculo(Long id, VeiculosModel veiculoAtualizado){
        VeiculosModel veiculosExistente = veiculosRepository.findById(id).orElseThrow(()-> new RuntimeException("Veiculo não encontrado"));
        veiculosExistente.setMarca(veiculoAtualizado.getMarca());
        veiculosExistente.setModelo(veiculoAtualizado.getModelo());
        veiculosExistente.setAno(veiculoAtualizado.getAno());
        veiculosExistente.setStatus(veiculoAtualizado.getStatus());
        return veiculosRepository.save(veiculosExistente);
    }




}
