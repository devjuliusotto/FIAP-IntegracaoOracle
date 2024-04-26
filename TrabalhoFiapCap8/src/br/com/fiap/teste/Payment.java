package br.com.fiap.teste;

public class Payment {
    private int id;
    private long code;
    private String description;
    private boolean enabled;

    public Payment(int id, long code, String description, boolean enabled) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.enabled = enabled;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getCode() { return code; }
    public void setCode(long code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
