package com.example.demo.loan;

import com.example.demo.loan.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface LoanRepository extends CrudRepository<Loan, Integer>{

}
