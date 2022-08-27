package com.desafio.GerenciadorContas.model;

import com.desafio.GerenciadorContas.Enum.StatusConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MostrarContasModel {

    private Long id;
    private String nome;
    private double valor;
    private StatusConta status;

    public MostrarContasModel(GerenciadorModel gerenciadorModel){
        id = gerenciadorModel.getId();
        nome= gerenciadorModel.getNome();
        valor = gerenciadorModel. getValor();
        status = gerenciadorModel.getStatus();
    }

    public static List<MostrarContasModel> convert(List<GerenciadorModel> gerenciadorModel){
        return  gerenciadorModel.stream().map(MostrarContasModel::new).collect((Collectors.toList()));

    }
}
