package com.cep.domain.repository;

import com.cep.domain.model.Cep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CepRepository extends JpaRepository<Cep, String> {

    @Query(value = "SELECT * FROM public.cep WHERE logradouro ILIKE CONCAT('%', :logradouro, '%')", nativeQuery = true)
    public List<Cep> buscarPorLogradouro(@Param("logradouro") String logradouro, Pageable pageable);

    @Query(value = "SELECT * FROM public.cep WHERE cidade ILIKE CONCAT('%', :cidade, '%')", nativeQuery = true)
    public List<Cep> buscarPorCidade(@Param("cidade") String cidade, Pageable pageable);

}
