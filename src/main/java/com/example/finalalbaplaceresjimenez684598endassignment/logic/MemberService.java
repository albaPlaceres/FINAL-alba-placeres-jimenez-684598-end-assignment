package com.example.finalalbaplaceresjimenez684598endassignment.logic;

import com.example.finalalbaplaceresjimenez684598endassignment.dal.MemberDao;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;

import java.util.Objects;

public class MemberService {
    private MemberDao memberDao;

    // Constructor
    public MemberService() {
        memberDao = new MemberDao();
        addMembers();
    }

    // Get a member by its username
    public Member getMemberByUsername (String username){
        for (Member u : memberDao.getMembers()){
            if (Objects.equals(u.getUsername(), username)){
                return u;
            }
        }
        return null;
    }

    // Adding random members to the database
    public void addMembers(){
        memberDao.createNewMember("Alba", "username1", "password1");
        memberDao.createNewMember("Vanessa", "username2", "password2");
        memberDao.createNewMember("Plami", "username3", "password3");
        memberDao.createNewMember("Motche", "username4", "password4");
    }
}
