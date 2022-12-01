package com.parcel.terminal.service;

import java.time.LocalDateTime;
import java.util.List;

public interface TerminalService {
	public void addParcel(String size, LocalDateTime validTo);
	
	public Integer getParcelForClient(String uniqueID, String password);
	
	public List<Integer> getEmptyBoxes();
}
