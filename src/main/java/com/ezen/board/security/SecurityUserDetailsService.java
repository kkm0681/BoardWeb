package com.ezen.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezen.board.domain.Member;
import com.ezen.board.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// MemberRepository로 회원 정보 조회
		Optional<Member> optional = memberRepo.findById(username);
		
		if (optional.isPresent()) {
			// UserDetails 타입의 객체로 변환하여 리턴
			Member member = optional.get();
			return new SecurityUser(member);
		} else {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		}
	}
}
