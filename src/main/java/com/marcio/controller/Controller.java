package com.marcio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.entity.Data;
import com.marcio.service.impl.ServiceImpl;

@RestController
@RequestMapping
public class Controller {
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam("message") String message){
		return ResponseEntity.status(HttpStatus.OK).body(new ServiceImpl().search(message));
	}
	
	@PostMapping("/gravar")
	public ResponseEntity<?> gravar(@RequestBody Data data){
		new ServiceImpl().gravar(data);
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
	
}
