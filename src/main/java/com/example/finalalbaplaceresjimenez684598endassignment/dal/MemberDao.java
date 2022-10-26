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

    // Add a new member with first and last name
    public void addMember(String firstName, String lastName, String username, String password, LocalDate birthdate, int memberIdentifier){
        members.add(new Member(firstName, lastName, username, password, birthdate, memberIdentifier));
    }

    // Add a new member with full name
    public void addMember(String fullName, String username, String password, LocalDate birthdate, int memberIdentifier){
        members.add(new Member(fullName, username, password, birthdate, memberIdentifier));
    }
}
