package com.tomaz.finance.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomaz.finance.dto.TransactionCreateDTO;
import com.tomaz.finance.dto.TransactionUpdateDTO;
import com.tomaz.finance.entities.Transaction;
import com.tomaz.finance.services.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {
	
	@Autowired
	private TransactionService service;
	
	@GetMapping
	public ResponseEntity<List<Transaction>> findAll(){
		
		List<Transaction> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Transaction> create(@Valid @RequestBody TransactionCreateDTO dto){
		Transaction obj = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody TransactionUpdateDTO dto){
		Transaction obj = service.update(id, dto);
		return ResponseEntity.ok(obj);
	}
}
