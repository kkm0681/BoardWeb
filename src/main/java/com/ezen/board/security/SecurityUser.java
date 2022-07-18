package com.ezen.board.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.ezen.board.domain.Member;

public class SecurityUser extends User {
	
	private Member member;
	
	public SecurityUser(Member member) {
		
		super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
}
