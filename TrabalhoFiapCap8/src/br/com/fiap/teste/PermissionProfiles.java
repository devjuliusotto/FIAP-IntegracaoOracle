package br.com.fiap.teste;

public class PermissionProfiles {
    private int id;
    private String code;
    private String description;
    private int accessLevel;
    private int passwordPoliciesId;

    public PermissionProfiles(int id, String code, String description, int accessLevel, int passwordPoliciesId) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.accessLevel = accessLevel;
        this.passwordPoliciesId = passwordPoliciesId;
    }

    // Getters
    public int getId() { return id; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public int getAccessLevel() { return accessLevel; }
    public int getPasswordPoliciesId() { return passwordPoliciesId; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDescription(String description) { this.description = description; }
    public void setAccessLevel(int accessLevel) { this.accessLevel = accessLevel; }
    public void setPasswordPoliciesId(int passwordPoliciesId) { this.passwordPoliciesId = passwordPoliciesId; }
}
