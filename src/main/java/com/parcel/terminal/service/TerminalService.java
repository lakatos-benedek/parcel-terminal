package com.parcel.terminal.service;

import java.util.Date;
import java.util.List;

public interface TerminalService {
	public String addParcel(String size, Date validTo);

	public Integer getParcelForClient(Integer id, String password);

	public List<Integer> getEmptyBoxes();
}
