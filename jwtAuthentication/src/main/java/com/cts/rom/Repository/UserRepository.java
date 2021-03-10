package com.cts.rom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.rom.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser,String > {

	public MyUser findByUsername(String username);

	

}
