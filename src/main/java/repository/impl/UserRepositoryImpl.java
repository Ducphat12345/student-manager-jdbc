package repository.impl;

import model.User;
import repository.UserRepository;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    List<User> userList;
    ResultSet resultSet = null;
    public List<User> getAllUser(){
        userList = new ArrayList<>();
        String sql = "select * from users";
        resultSet = JDBCHelper.excuteQuery(sql);
        try {
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                userList.add(new User(username, password, role));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return userList;
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "select * from users where username = ?";
        resultSet = JDBCHelper.excuteQuery(sql, username);
        try {
            while (resultSet.next()){
                String userName = resultSet.getString("username");
                String passWord = resultSet.getString("password");
                String role = resultSet.getString("role");
                User user = new User(userName, passWord, role);
                return user;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return null;
    }
}
