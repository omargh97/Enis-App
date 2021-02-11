package tn.enis.enismap.model;

public class Contact {
    private String userName;
    private String userEmail;
    private String userFonction;
    private String userTel;


    public Contact(String userName, String userEmail, String userFonction, String userTel) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userFonction = userFonction;
        this.userTel = userTel;
    }

    public Contact() {

    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserFonction() {
        return userFonction;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserFonction(String userFonction) {
        this.userFonction = userFonction;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
