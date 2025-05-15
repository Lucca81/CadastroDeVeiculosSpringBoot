package dev.lucca.CadastroDeVeiculos.model.repository.service.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculosRepository extends JpaRepository<VeiculosModel,Long> {
    Optional<VeiculosModel> findByPlaca(String placa);

}
