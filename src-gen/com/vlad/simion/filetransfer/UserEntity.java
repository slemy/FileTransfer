package com.vlad.simion.filetransfer;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER_ENTITY.
 */
public class UserEntity {

    private Long id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Workplace;
    private byte[] ProfileImage;

    public UserEntity() {
    }

    public UserEntity(Long id) {
        this.id = id;
    }

    public UserEntity(Long id, String FirstName, String LastName, String Email, String Workplace, byte[] ProfileImage) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Workplace = Workplace;
        this.ProfileImage = ProfileImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getWorkplace() {
        return Workplace;
    }

    public void setWorkplace(String Workplace) {
        this.Workplace = Workplace;
    }

    public byte[] getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(byte[] ProfileImage) {
        this.ProfileImage = ProfileImage;
    }

}
