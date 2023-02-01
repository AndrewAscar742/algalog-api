package br.com.sp.algalogapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sp.algalogapi.api.dto.input.ClienteDto;
import br.com.sp.algalogapi.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByEmail(String email);

}
