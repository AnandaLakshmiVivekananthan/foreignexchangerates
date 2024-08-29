package com.fer.foreignexchangerates.repository;

import com.fer.foreignexchangerates.model.ExchangeRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Ananda Lakshmi Vivekananthan
 */
@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Integer> {

	@Query(value = "SELECT * FROM exchangerates WHERE date = CURRENT_DATE LIMIT 1", nativeQuery = true)
	Optional<ExchangeRate> findLatestRecords();
}
