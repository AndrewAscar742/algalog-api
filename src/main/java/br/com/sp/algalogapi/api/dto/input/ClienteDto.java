package br.com.sp.algalogapi.api.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sp.algalogapi.domain.ValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto{
	
	@NotNull(groups = ValidationGroup.class)
	private Long id;
	@NotBlank
	@Size(min = 3,max = 60)
	private String nome; 
	@NotBlank
	@Email
	@Size(min = 3,max = 255)
	private String email; 
	@NotBlank
	private String telefone;
	
	
}
	
	
	


