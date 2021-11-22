package com.pesrsistent.sevice;

import java.util.List;

import com.pesrsistent.model.Loan;


public interface LoanService {

	Loan loanInsert(Loan loans);

	List<Loan> getAllLoan();

	Loan getLoanByCustomerId(String loan_id);

	Loan getByLoanAndCustomerId(String customer_id,Long loan_id);

	 void deleteByLoanID(long loan_id);
	

}

