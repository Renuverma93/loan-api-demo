package com.pesrsistent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pesrsistent.model.Loan;


@Repository
public interface LoansDAO extends JpaRepository<Loan, String>{



	@Query(value="SELECT * from loans  WHERE customer_id=?1",  nativeQuery = true)
	Optional<Loan> getLoanByCustomerId(String customer_id);


	 @Query(value="SELECT * from loans  WHERE customer_id=?1 AND loan_id=?1",  nativeQuery = true)
	Optional<Loan> getByLoanAndCustomerId(String customer_id, Long loan_id);

	
	 @Modifying
	 @Query(value="delete from loans  WHERE loan_id=?1",  nativeQuery = true)
     void deleteBycustomer_Id(@Param("loan_id") long loan_id);
     
	 

}
