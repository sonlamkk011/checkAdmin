package com.example.checkadmin.account;

import com.example.checkadmin.entity.Account;
import com.example.checkadmin.model.AccountModel;
import com.example.checkadmin.model.MySQLAccountModel;
import com.example.checkadmin.passwordHasher.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;
    public AccountService(){
        this.accountModel = new MySQLAccountModel();
    }
    public Account register(Account account){
    String salt = SHA512Hasher.randomString( 7 );
    String passwordHash = SHA512Hasher.encode(account.getPassword(), salt);
    account.setPassword(passwordHash + "." + salt);
    accountModel.save(account);
    return account;
    }
    public Account login(String username, String password){
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword() , password)){
            return account;
        }
        return null;
    }

}
