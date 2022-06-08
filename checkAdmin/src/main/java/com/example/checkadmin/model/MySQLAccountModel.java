package com.example.checkadmin.model;

import com.example.checkadmin.entity.Account;
import com.example.checkadmin.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLAccountModel implements AccountModel{
    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (fullName, username, email, password, status ) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET fullName = ?, username = ?, email = ?, password = ?, status = ? WHERE id = ?;";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?;";
    private static final String FIND_BY_ID = "SELECT * FROM accounts WHERE id = ?;";
    private static final String FIND_BY_ALL = "SELECT * FROM accounts;";


    public MySQLAccountModel() {
        super();
    }

    @Override
    public boolean save(Account obj) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, obj.getFullname());
            preparedStatement.setString(2, obj.getUsername());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setString(4, obj.getPassword());
            preparedStatement.setInt(5, obj.getStatus());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Account updateObj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }
}
