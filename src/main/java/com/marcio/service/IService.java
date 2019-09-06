package com.marcio.service;

import java.util.List;

import com.marcio.entity.Data;

public interface IService {

	List<Data> search(String message);
	void gravar(Data data);
}
