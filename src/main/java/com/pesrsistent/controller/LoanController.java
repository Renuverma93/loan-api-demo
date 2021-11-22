package com.pesrsistent.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pesrsistent.model.Loan;
import com.pesrsistent.sevice.LoanService;

@RestController
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/loans")
	public Loan loanData(@RequestBody Loan loans) {
		return loanService.loanInsert(loans);
	}
	
	@GetMapping("/all")
	public List<Loan> getLoan(){
		return loanService.getAllLoan();
	}
	
	@GetMapping("/{customer_id}/loans")
	public Loan getLoanByCustomerId(@PathVariable("customer_id") String customer_id) {
		return loanService.getLoanByCustomerId(customer_id);
	}
	
	
	@DeleteMapping("/delete/{loan_id}/loans")
	public String deleteLoan(@PathVariable("loan_id")long loan_id) {
		loanService.deleteByLoanID(loan_id);
		return "One record deleted sucssesfully check record http://localhost:1996/all";
	}
	
	
	@PutMapping("update/{customer_id}/loans/{loan_id}")
	public Loan updateLoan(@RequestBody Loan loans, @PathVariable("customer_id")String customer_id, @PathVariable("loan_id")Long loan_id) {
		Loan update=loanService.getByLoanAndCustomerId(customer_id,loan_id);
		update.setBalance_tenure(loans.getBalance_tenure());
		update.setAmount(loans.getAmount());
		return loanService.loanInsert(update);
	} 
	

	
	
	
	
	
}
