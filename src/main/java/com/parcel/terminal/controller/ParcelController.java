package com.parcel.terminal.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.terminal.service.TerminalService;

@RestController
@RequestMapping("/")
public class ParcelController {

	private TerminalService terminalService;

	@Autowired
	public ParcelController(TerminalService terminalService) {
		this.terminalService = terminalService;
	}

	@PostMapping("/addParcel")
	public ResponseEntity<String> addParcel(@RequestParam(value = "parcelSize") String size,
			@RequestParam(value = "storedUntil") @DateTimeFormat(pattern = "yyyyMMdd") Date storedUntil) {
		return new ResponseEntity<>(terminalService.addParcel(size, storedUntil), HttpStatus.OK);
	}

	@GetMapping("/getParcel")
	public ResponseEntity<Integer> getParcel(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "password") String password) {
		return new ResponseEntity<>(terminalService.getParcelForClient(id, password), HttpStatus.OK);
	}

	@GetMapping("/getEmptyBoxes")
	public ResponseEntity<List<Integer>> getEmptyBoxes() {
		return new ResponseEntity<>(terminalService.getEmptyBoxes(), HttpStatus.OK);
	}
}
