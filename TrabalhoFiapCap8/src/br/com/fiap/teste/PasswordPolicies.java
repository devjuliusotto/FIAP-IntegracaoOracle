package br.com.fiap.teste;

public class PasswordPolicies {
    private int id;
    private long code;
    private String description;
    private int passwordLength;
    private int numberAlphaCharacters;
    private int numberNumericCharacters;
    private int numberSpecialCharacters;
    private int numberUppercaseCharacters;
    private int passwordReuseHistory;
    private int passwordExpirationDays;
    private int failedLoginAttempts;

    public PasswordPolicies(int id, long code, String description, int passwordLength, int numberAlphaCharacters, int numberNumericCharacters, int numberSpecialCharacters, int numberUppercaseCharacters, int passwordReuseHistory, int passwordExpirationDays, int failedLoginAttempts) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.passwordLength = passwordLength;
        this.numberAlphaCharacters = numberAlphaCharacters;
        this.numberNumericCharacters = numberNumericCharacters;
        this.numberSpecialCharacters = numberSpecialCharacters;
        this.numberUppercaseCharacters = numberUppercaseCharacters;
        this.passwordReuseHistory = passwordReuseHistory;
        this.passwordExpirationDays = passwordExpirationDays;
        this.failedLoginAttempts = failedLoginAttempts;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getCode() { return code; }
    public void setCode(long code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPasswordLength() { return passwordLength; }
    public void setPasswordLength(int passwordLength) { this.passwordLength = passwordLength; }

    public int getNumberAlphaCharacters() { return numberAlphaCharacters; }
    public void setNumberAlphaCharacters(int numberAlphaCharacters) { this.numberAlphaCharacters = numberAlphaCharacters; }

    public int getNumberNumericCharacters() { return numberNumericCharacters; }
    public void setNumberNumericCharacters(int numberNumericCharacters) { this.numberNumericCharacters = numberNumericCharacters; }

    public int getNumberSpecialCharacters() { return numberSpecialCharacters; }
    public void setNumberSpecialCharacters(int numberSpecialCharacters) { this.numberSpecialCharacters = numberSpecialCharacters; }

    public int getNumberUppercaseCharacters() { return numberUppercaseCharacters; }
    public void setNumberUppercaseCharacters(int numberUppercaseCharacters) { this.numberUppercaseCharacters = numberUppercaseCharacters; }

    public int getPasswordReuseHistory() { return passwordReuseHistory; }
    public void setPasswordReuseHistory(int passwordReuseHistory) { this.passwordReuseHistory = passwordReuseHistory; }

    public int getPasswordExpirationDays() { return passwordExpirationDays; }
    public void setPasswordExpirationDays(int passwordExpirationDays) { this.passwordExpirationDays = passwordExpirationDays; }

    public int getFailedLoginAttempts() { return failedLoginAttempts; }
    public void setFailedLoginAttempts(int failedLoginAttempts) { this.failedLoginAttempts = failedLoginAttempts; }
}
