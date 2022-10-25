package com.example.finalalbaplaceresjimenez684598endassignment.logic;

import com.example.finalalbaplaceresjimenez684598endassignment.dal.MemberDao;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import java.time.LocalDate;
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
    public void addMembers(){   // 'LocalDate.of' checks if the date is valid
        memberDao.createNewMember("Alba Placeres", "username1", "password1",  LocalDate.of(2003, 12, 9));
        memberDao.createNewMember("Vanessa", "Fedorciuk", "username2", "password2", LocalDate.of(2002, 12, 31));
        memberDao.createNewMember("David Jimenez", "username3", "password3", LocalDate.of(1979, 11, 15));
        memberDao.createNewMember("Yeray", "Placeres", "username4", "password4", LocalDate.of(1975, 12, 20));
    }
}
