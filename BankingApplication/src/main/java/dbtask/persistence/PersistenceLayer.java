package dbtask.persistence;

import dbtask.account.AccountInfo;
import dbtask.customer.CustomerInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersistenceLayer {
    void closeConnection();

    int createAccount(AccountInfo accountInfo) throws SQLException;

    ArrayList createAccount(ArrayList<ArrayList>infoList) throws SQLException;

    ArrayList createCustomer(ArrayList<ArrayList>infoList) throws SQLException;
    
    int createCustomer(CustomerInfo customerInfo) throws SQLException;

    void deleteCustomer(int customerId) throws SQLException;

    void activateCustomer(int customerId) throws SQLException;

    void deActivateAccount(int accountNumber) throws SQLException;

    void activateAccount(int accountNumber) throws SQLException;

    void insertNewCash(double newBalance,int accountNumber) throws SQLException;

    void deleteAccount(int customerId) throws SQLException;

    ArrayList storeActiveInfoToList() throws SQLException;

    ArrayList storeInActiveInfoToList() throws SQLException;
    
    ArrayList getCustomerList() throws SQLException;
    
    ArrayList getAccountList() throws SQLException;
}

