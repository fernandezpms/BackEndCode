package com.taller4.tpfinal.tpfinal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taller4.tpfinal.tpfinal.controller.UsuarioController;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UsuarioController userCtrl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		var usuario =  userCtrl.findByUserName(username);

		if(usuario != null){
			return new User(usuario.getUserName(), usuario.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuario no enocntrado: " + username);
		}

	}

}