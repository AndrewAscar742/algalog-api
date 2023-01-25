package br.com.sp.algalogapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sp.algalogapi.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
