package com.parcel.terminal.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.terminal.model.Box;
import com.parcel.terminal.model.Parcel;
import com.parcel.terminal.repository.BoxRepository;
import com.parcel.terminal.repository.ParcelRepository;

@Service
public class TerminalServiceImpl implements TerminalService {

	private BoxRepository boxRepository;

	private ParcelRepository parcelRepository;

	@Autowired
	public TerminalServiceImpl(BoxRepository boxRepository, ParcelRepository parcelRepository) {
		this.boxRepository = boxRepository;
		this.parcelRepository = parcelRepository;
	}

	@Override
	public String addParcel(String size, Date validTo) {
		if (boxRepository.countEmptyBoxes(size) == 0) {
			return "All the boxes of the given size are full, find another terminal to put the parcel in.";
		}
		Parcel newParcel = new Parcel();
		newParcel.setSize(size);
		newParcel.setStoredUntil(validTo);
		newParcel.setPassword(RandomStringUtils.randomAlphanumeric(6));
		parcelRepository.save(newParcel);

		List<Box> freeBoxes = boxRepository.getEmptyBoxesBySize(size);
		freeBoxes.get(0).setParcelId(newParcel.getId());
		boxRepository.save(freeBoxes.get(0));

		return String.format("The parcel has been succesfully added to box %2d with UID %2d", freeBoxes.get(0).getId(),
				newParcel.getId());
	}

	@Override
	public Integer getParcelForClient(Integer id, String password) {
		Parcel parcel = parcelRepository.getParcelByIdAndPassword(id, password);
		if (parcel == null) {
			return -1;
		} else {
			Box box = boxRepository.getBoxFromParcelId(parcel.getId());
			box.setParcelId(null);
			boxRepository.save(box);
			parcelRepository.delete(parcel);
			return box.getId();
		}
	}

	@Override
	public List<Integer> getEmptyBoxes() {
		return boxRepository.getEmptyBoxes();
	}

}
