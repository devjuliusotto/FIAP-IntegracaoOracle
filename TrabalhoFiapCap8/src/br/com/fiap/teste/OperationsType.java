package br.com.fiap.teste;

public class OperationsType {
    private int id;
    private int code;
    private String description;
    private boolean enabled;
    private int typeOperation;

    public OperationsType(int id, int code, String description, boolean enabled, int typeOperation) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.enabled = enabled;
        this.typeOperation = typeOperation;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public int getTypeOperation() { return typeOperation; }
    public void setTypeOperation(int typeOperation) { this.typeOperation = typeOperation; }
}
