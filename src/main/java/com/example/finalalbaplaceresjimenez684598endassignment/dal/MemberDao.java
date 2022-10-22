package com.example.finalalbaplaceresjimenez684598endassignment.dal;

import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private List<Member> members = new ArrayList<>();   // List of all the members

    public List<Member> getMembers() {
        return members;
    }

    // Creating a new member
    public void createNewMember(String name, String username, String password){
        members.add(new Member(name, username, password));
    }
}
