package br.com.fiap.teste;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (id, transaction_num, operation_id, trans_datetime, total, payment_id, operator_id, type_operation_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, transaction.getId());
            pstmt.setLong(2, transaction.getTransactionNum());
            pstmt.setInt(3, transaction.getOperationId());
            pstmt.setTimestamp(4, new Timestamp(transaction.getTransDateTime().getTime()));
            pstmt.setBigDecimal(5, transaction.getTotal());
            pstmt.setInt(6, transaction.getPaymentId());
            pstmt.setInt(7, transaction.getOperatorId());
            pstmt.setInt(8, transaction.getTypeOperationId());
            pstmt.executeUpdate();
        }
    }

    public List<Transaction> getAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getInt("id"),
                    rs.getLong("transaction_num"),
                    rs.getInt("operation_id"),
                    rs.getTimestamp("trans_datetime"),
                    rs.getBigDecimal("total"),
                    rs.getInt("payment_id"),
                    rs.getInt("operator_id"),
                    rs.getInt("type_operation_id")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
