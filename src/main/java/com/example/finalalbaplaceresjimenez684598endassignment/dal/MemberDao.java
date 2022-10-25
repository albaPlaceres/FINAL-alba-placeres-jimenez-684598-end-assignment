package com.example.finalalbaplaceresjimenez684598endassignment.dal;

import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private List<Member> members = new ArrayList<>();   // List of all the members

    public List<Member> getMembers() {
        return members;
    }

    // Creating a new member with first and last name
    public void createNewMember(String firstName, String lastName, String username, String password, LocalDate birthdate){
        members.add(new Member(firstName, lastName, username, password, birthdate));
    }

    // Creating a new member with full name
    public void createNewMember(String fullName, String username, String password, LocalDate birthdate){
        members.add(new Member(fullName, username, password, birthdate));
    }
}
