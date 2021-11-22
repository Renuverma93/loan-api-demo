package com.pesrsistent.sevice.impl;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pesrsistent.dao.LoansDAO;
import com.pesrsistent.model.Loan;
import com.pesrsistent.sevice.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
    
	@Autowired
	private LoansDAO loansDAO;
	//
	@Override
	public Loan loanInsert(Loan loans) {
		
		return loansDAO.save(loans);
	}
	//
	@Override
	public List<Loan> getAllLoan() {
		
		return loansDAO.findAll();
	}
	
//
	@Override
	public Loan getLoanByCustomerId(String customer_id) {
		
		Optional<Loan> data=loansDAO.getLoanByCustomerId(customer_id);
		
		return (Loan) data.get();
	}

	@Override
	public Loan getByLoanAndCustomerId(String customer_id, Long loan_id) {
		
		Optional<Loan> daata=loansDAO.getByLoanAndCustomerId( customer_id,loan_id);
		 return (Loan) daata.get();
	}

	@Override
	@Transactional
	public void deleteByLoanID(long loan_id) {
		
		loansDAO.deleteBycustomer_Id(loan_id);
	}

	

	
	
}

