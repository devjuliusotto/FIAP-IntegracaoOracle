package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (id, code, description, enabled) VALUES (payment_seq.nextval, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, payment.getCode());
            pstmt.setString(2, payment.getDescription());
            pstmt.setBoolean(3, payment.isEnabled());
            pstmt.executeUpdate();
        }
    }

    public List<Payment> getAll() throws SQLException {
        List<Payment> paymentsList = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("id"),
                        rs.getLong("code"),
                        rs.getString("description"),
                        rs.getBoolean("enabled")
                );
                paymentsList.add(payment);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar pagamentos: " + e.getMessage());
            throw e;
        }
        return paymentsList;
    }
}
