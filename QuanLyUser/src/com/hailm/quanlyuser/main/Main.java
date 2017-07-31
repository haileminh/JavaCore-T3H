package com.hailm.quanlyuser.main;

import com.hailm.quanlyuser.Account;
import com.hailm.quanlyuser.User;
import com.hailm.quanlyuser.UserManager;

public class Main {
    public static void main(String[] args) {
        Account taiKhoan1 = new Account("TK1", "123");
        Account taiKhoan2 = new Account("TK2", "123");
        User user1 = new User(taiKhoan1, "Le Minh Hai", "123456");
        User user2 = new User(taiKhoan2, "Huỳnh", "123456");
        UserManager userManager = new UserManager();
        userManager.signUp(user1);
        userManager.signUp(user2);
          
       userManager.signIn("TK11", "123");
       
       userManager.searchByName("Le Minh");
       
       userManager.deleteUser("TK12");
       
       userManager.sortUser();
    }
}
