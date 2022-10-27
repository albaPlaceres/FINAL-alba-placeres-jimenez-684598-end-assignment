package com.example.finalalbaplaceresjimenez684598endassignment.logic;

import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import java.util.Objects;

public class LoginService {
    private MemberService memberService;

    public LoginService() {
        memberService = new MemberService();
    }

    // Check if the member exists and the combination is correct
    public boolean loginSuccessful(String enteredUsername, String enteredPassword){
        Member member = memberService.getMemberByUsername(enteredUsername);
        return (Objects.nonNull(member) && (Objects.equals(member.getPassword(), enteredPassword)));
    }
}
