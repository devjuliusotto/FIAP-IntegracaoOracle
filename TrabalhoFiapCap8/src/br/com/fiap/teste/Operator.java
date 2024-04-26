package br.com.fiap.teste;

import java.util.Date;

public class Operator {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date passcodeExpiryDate;
    private int passwdFailureRetry;
    private Date lastPasswdFailureDate;
    private int permissionProfileId;

    public Operator(int id, String firstName, String lastName, String email, String password, Date passcodeExpiryDate, int passwdFailureRetry, Date lastPasswdFailureDate, int permissionProfileId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passcodeExpiryDate = passcodeExpiryDate;
        this.passwdFailureRetry = passwdFailureRetry;
        this.lastPasswdFailureDate = lastPasswdFailureDate;
        this.permissionProfileId = permissionProfileId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPasscodeExpiryDate() {
        return passcodeExpiryDate;
    }

    public void setPasscodeExpiryDate(Date passcodeExpiryDate) {
        this.passcodeExpiryDate = passcodeExpiryDate;
    }

    public int getPasswdFailureRetry() {
        return passwdFailureRetry;
    }

    public void setPasswdFailureRetry(int passwdFailureRetry) {
        this.passwdFailureRetry = passwdFailureRetry;
    }

    public Date getLastPasswdFailureDate() {
        return lastPasswdFailureDate;
    }

    public void setLastPasswdFailureDate(Date lastPasswdFailureDate) {
        this.lastPasswdFailureDate = lastPasswdFailureDate;
    }

    public int getPermissionProfileId() {
        return permissionProfileId;
    }

    public void setPermissionProfileId(int permissionProfileId) {
        this.permissionProfileId = permissionProfileId;
    }
}
