package br.com.fiap.teste;

import java.util.Date;

public class PasswordHistories {
    private int id;
    private int operatorId;
    private int changeOperatorId;
    private String password;
    private Date passwordChangeDate;

    public PasswordHistories(int id, int operatorId, int changeOperatorId, String password, Date passwordChangeDate) {
        this.id = id;
        this.operatorId = operatorId;
        this.changeOperatorId = changeOperatorId;
        this.password = password;
        this.passwordChangeDate = passwordChangeDate;
    }

    // Getters
    public int getId() { return id; }
    public int getOperatorId() { return operatorId; }
    public int getChangeOperatorId() { return changeOperatorId; }
    public String getPassword() { return password; }
    public Date getPasswordChangeDate() { return passwordChangeDate; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setOperatorId(int operatorId) { this.operatorId = operatorId; }
    public void setChangeOperatorId(int changeOperatorId) { this.changeOperatorId = changeOperatorId; }
    public void setPassword(String password) { this.password = password; }
    public void setPasswordChangeDate(Date passwordChangeDate) { this.passwordChangeDate = passwordChangeDate; }
}
