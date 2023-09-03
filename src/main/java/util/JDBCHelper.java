package util;

import repository.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {
    public static ResultSet excuteQuery(String sql, Object...args){
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection = DatabaseContext.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return resultSet;
    }
    public static Integer excuteUpdate(String sql, Object...args){
        Connection connection;
        PreparedStatement preparedStatement;
        Integer row;
        connection = DatabaseContext.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return row;
    }
}
