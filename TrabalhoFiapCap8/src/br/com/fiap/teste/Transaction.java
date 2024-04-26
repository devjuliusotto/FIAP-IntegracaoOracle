package br.com.fiap.teste;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private int id;
    private long transactionNum;
    private int operationId;
    private Date transDateTime;
    private BigDecimal total;
    private int paymentId;
    private int operatorId;
    private int typeOperationId;

    public Transaction(int id, long transactionNum, int operationId, Date transDateTime, BigDecimal total, int paymentId, int operatorId, int typeOperationId) {
        this.id = id;
        this.transactionNum = transactionNum;
        this.operationId = operationId;
        this.transDateTime = transDateTime;
        this.total = total;
        this.paymentId = paymentId;
        this.operatorId = operatorId;
        this.typeOperationId = typeOperationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(long transactionNum) {
        this.transactionNum = transactionNum;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public Date getTransDateTime() {
        return transDateTime;
    }

    public void setTransDateTime(Date transDateTime) {
        this.transDateTime = transDateTime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(int typeOperationId) {
        this.typeOperationId = typeOperationId;
    }
}
