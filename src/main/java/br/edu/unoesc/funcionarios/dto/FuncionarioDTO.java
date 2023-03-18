package br.edu.unoesc.funcionarios.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.unoesc.funcionarios.model.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {
	Long id;

	@NotBlank(message = "Nome não pode ser vaziu!")
	@Size(min=3, max = 50, message = "O nome de ter entre {min} e {max} caráteres!")
	String nome;
	
	@Size(max = 100, message = "O endereço não pode ter mais de {max} caráteres!")
	String endereco;
	
	@NotNull(message = "Número de dependentes não pode ser vaziu!")
	@Min(value = 0, message = "Não é possivel doar ses dependentes!")
	Integer numDep;

	@NotNull(message = "Salário deve ser informado!")
	BigDecimal salario;

	@NotNull(message = "Informe sua data de nascimento!")
	LocalDate nascimento;;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.endereco = funcionario.getEndereco();
		this.numDep = funcionario.getNumDep();
		this.salario = funcionario.getSalario();
		this.nascimento = funcionario.getNascimento();
	}
}