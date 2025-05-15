package dev.lucca.CadastroDeVeiculos.model.repository.service.controller;

import dev.lucca.CadastroDeVeiculos.enuns.VeiculosStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veiculos")
public class VeiculosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(unique = true)
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    @Enumerated(EnumType.STRING)
    VeiculosStatus status;


}
