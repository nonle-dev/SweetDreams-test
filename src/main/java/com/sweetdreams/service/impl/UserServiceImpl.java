package com.sweetdreams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetdreams.entity.UserEntity;
import com.sweetdreams.repository.UserRepository;
import com.sweetdreams.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<UserEntity> listUser() {
		return repository.findAll();
	}
	

}
