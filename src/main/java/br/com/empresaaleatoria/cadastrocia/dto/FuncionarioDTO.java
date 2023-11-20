package br.com.empresaaleatoria.cadastrocia.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioDTO {
	
	@NotBlank(message = "O campo 'nome' não pode estar em branco.")
    private String nome;

	@CPF(message = "CPF inválido")
	private String cpf;

    private String logradouro;
    
    @Null(message = "ativo precisa ser nulo")
    private Boolean ativo;

    @NumberFormat
    private String numero;

    private String bairro;

    @Pattern(regexp = "^[\\p{L} \\s]*$", message = "O campo deve conter apenas letras, espaços e acentos.")
    private String municipio;

    @Size(max = 2)
    private String uf;

    private String codigoIbge;

    @Pattern(regexp = "[0-9]{8}$", message = "O campo  cep deve conter apenas numeros de 8 digitos.")
    private String cep;

    private String complemento;

    @Email(message = "email inválido")
    private String email;

    @Pattern(regexp = "^([1-9]{2})$", message = "O ddd deve conter apenas numeros")
    private String ddd;

    @Pattern(regexp = "^9?[0-9]{8}$", message = "O telefone deve conter apenas numeros")
    private String telefone;

    @Null(message = "salario precisa ser nulo")
    private BigDecimal salario;

	@Pattern(regexp = "^(?i)(estagiario|junior|pleno|senior)$", message = "A descrição do cargo deve ser 'estagiario', 'junior', 'pleno' ou 'senior'.")
	@NotBlank(message = "O campo 'descricao' não pode estar em branco.")
    private String cargoNome;
	
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataAdmissao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "dataNascimento não pode ser nulo")
    private String dataNascimento;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataDesligamento;

}
