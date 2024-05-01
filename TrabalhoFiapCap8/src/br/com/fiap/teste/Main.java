package br.com.fiap.teste;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        OperationsDAO operationsDao = new OperationsDAO();
        OperatorsDAO operatorsDao = new OperatorsDAO();
        TransactionsDAO transactionsDao = new TransactionsDAO();
        OperationsTypeDAO operationsTypeDao = new OperationsTypeDAO();
        PaymentDAO paymentDao = new PaymentDAO();
        PermissionProfilesDAO permissionProfilesDao = new PermissionProfilesDAO();
        PasswordPoliciesDAO passwordPoliciesDao = new PasswordPoliciesDAO();

        try {
        	

            // Teste para PasswordPoliciesDAO
            passwordPoliciesDao.insert(new PasswordPolicies(1, 303, "Default Policy", 10, 2, 3, 2, 2, 5, 90, 5));
            System.out.println("Password Policies inseridos:");
            for (PasswordPolicies pp : passwordPoliciesDao.getAll()) {
                System.out.println(pp);
            }
            
            // Teste para PermissionProfilesDAO
            permissionProfilesDao.insert(new PermissionProfiles(1, "ADM001", "Administrador", 1, 1));
            System.out.println("Permission Profiles inseridos:");
            for (PermissionProfiles pp : permissionProfilesDao.getAll()) {
                System.out.println(pp);
            }

        	
            // Teste para OperationsDAO
            operationsDao.insert(new Operation(19, "Compra de Material de Escritório", 2));
            operationsDao.insert(new Operation(20, "Venda de Software", 1));
            System.out.println("Operations inseridas:");
            for (Operation op : operationsDao.getAll()) {
                System.out.println(op);
            }
            
            // Teste para OperationsTypeDAO
            operationsTypeDao.insert(new OperationsType(1, 101, "Operação Financeira", true, 1));
            System.out.println("Operations Types inseridos:");
            for (OperationsType ot : operationsTypeDao.getAll()) {
                System.out.println(ot);
            }

            // Teste para OperatorsDAO
            operatorsDao.insert(new Operator(11, "John", "Doe", "john.doe@example.com", "pass123", new Date(), 0, null, 3));
            operatorsDao.insert(new Operator(12, "Jane", "Doe", "jane.doe@example.com", "pass123", new Date(), 0, null, 3));
            System.out.println("Operators inseridos:");
            for (Operator op : operatorsDao.getAll()) {
                System.out.println(op);
            }
            
            paymentDao.insert(new Payment(1, 202, "Pagamento Online", true));
            System.out.println("Payments inseridos:");
            for (Payment p : paymentDao.getAll()) {
                System.out.println(p);
            }

            // Teste para TransactionsDAO
            transactionsDao.insert(new Transaction(1, 123456789, 1, new Date(), new BigDecimal("1500.00"), 1, 1, 7));
            transactionsDao.insert(new Transaction(2, 987654321, 2, new Date(), new BigDecimal("3500.00"), 1, 2, 8));
            System.out.println("Transactions inseridas:");
            for (Transaction t : transactionsDao.getAll()) {
                System.out.println(t);
            }




            // Teste para PaymentDAO



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
