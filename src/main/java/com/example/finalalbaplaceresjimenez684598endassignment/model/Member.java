package com.example.finalalbaplaceresjimenez684598endassignment.model;

import java.time.LocalDate;

public class Member {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int memberIdentifier;
    private LocalDate birthDate;

    public String getFullName() {
        return (firstName + " " + lastName);
    }

    public void setFullName(String fullName){
        String[] fullNameArray = fullName.split(" ");
        firstName = fullNameArray[0];
        lastName = fullNameArray[1];
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(int memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Check if the birthdate is valid
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Constructor with separate first and last name
    public Member(String firstName, String lastName, String username, String password, LocalDate birhtdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthDate = birhtdate;
    }

    // Constructor with full name
    public Member(String fullName, String username, String password, LocalDate birhtdate) {
        setFullName(fullName);
        this.username = username;
        this.password = password;
        this.birthDate = birhtdate;
    }
}
