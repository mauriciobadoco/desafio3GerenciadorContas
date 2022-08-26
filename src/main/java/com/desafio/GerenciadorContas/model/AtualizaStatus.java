package com.desafio.GerenciadorContas.model;

import com.desafio.GerenciadorContas.Enum.StatusConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizaStatus {

    private StatusConta status;
}
