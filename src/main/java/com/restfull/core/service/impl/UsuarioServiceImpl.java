package com.restfull.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.restfull.core.entity.Usuario;
import com.restfull.core.repository.IUsuarioRepository;

/**
 * 
 * @author Sergio
 *
 *UserDetailService busca en la base de datos, si es admin, lector, usuario
 *Esto lo hace spring security
 */
public class UsuarioServiceImpl implements UserDetailsService {
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario user = usuarioRepository.findByUsername(username);
		return new User(user.getUsername(),user.getPassword(),user.isActivo(), 
				user.isActivo(), user.isActivo(),user.isActivo(), 
				buildgrante(user.getRol()));
	}
	
	public List<GrantedAuthority> buildgrante(byte rol){
		String[] roles = {"LECTOR","USUARIO","ADMINISTRADOR"};
		
		List<GrantedAuthority> auths = new ArrayList<>();
		for(int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		
		return auths;
	}
}
