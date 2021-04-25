package com.example.sms.dao;

import com.example.sms.bean.Student;
import com.example.sms.bean.User;
import com.example.sms.util.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/4/25
 * @see: com.example.sms.dao
 * @version: v1.0.0
 */
public class StudentDao {
    private String sql = "";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ArrayList<Student> students = new ArrayList<>();
    private Student student;
    private Connection connection = null;

    private Connection getConn() {
        try {
            if ((connection == null) || connection.isClosed()) {
                DB db = new DB();
                connection = db.getConn();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Student> getByResultSet(ResultSet resultSet) {
        try {
            if (resultSet == null || !resultSet.next()) {
                return null;
            }
            students.clear();
            do {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setNumber(resultSet.getString("number"));
                student.setName(resultSet.getString("name"));
                student.setMajor(resultSet.getString("major"));
                student.setClazz(resultSet.getString("clazz"));
                student.setSex(resultSet.getString("sex"));
                student.setAddress(resultSet.getString("address"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setMember(resultSet.getBoolean("isMember"));
                students.add(student);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void close() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
            preparedStatement = null;
            connection = null;
        }
    }

    public ArrayList<Student> findAll() {
        sql = "select * from student";
        try {
            preparedStatement = getConn().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getByResultSet(resultSet);
    }

    public ArrayList<Student> getByNumber(String number) {
        getConn();
        if (number == null) {
            number = "";
        }
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call getByNumberProc(?)}"); // 存储过程
            cs.setString(1, number);
            resultSet = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getByResultSet(resultSet);
    }

    public Boolean save(Student save) {
        int result = 0;
        ArrayList<Student> students = getByNumber(save.getNumber());
        Student check = students != null && students.size() > 0 ? students.get(0) : null;
        try {
            if (check != null) {
                sql = "update student set `name`=?,major=?,clazz=?,sex=?,address=?,birthday=?,isMember=? where `number`=?";
                preparedStatement = getConn().prepareStatement(sql);
                preparedStatement.setString(1, save.getName());
                preparedStatement.setString(2, save.getMajor());
                preparedStatement.setString(3, save.getClazz());
                preparedStatement.setString(4, save.getSex());
                preparedStatement.setString(5, save.getAddress());
                preparedStatement.setString(6, save.getBirthday());
                preparedStatement.setBoolean(7, save.getMember());
                preparedStatement.setString(8, save.getNumber());
            } else {
                sql = "insert into student(`name`,`number`,major,clazz,sex,address,birthday,isMember) values(?,?,?,?,?,?,?,?)";
                preparedStatement = getConn().prepareStatement(sql);
                preparedStatement.setString(1, save.getName());
                preparedStatement.setString(2, save.getNumber());
                preparedStatement.setString(3, save.getMajor());
                preparedStatement.setString(4, save.getClazz());
                preparedStatement.setString(5, save.getSex());
                preparedStatement.setString(6, save.getAddress());
                preparedStatement.setString(7, save.getBirthday());
                preparedStatement.setBoolean(8, save.getMember());
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result > 0;
    }


    public Student getById(int id) {
        getConn();
        sql = "select * from student where id=?";
        try {
            preparedStatement = getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getByResultSet(resultSet).get(0);
    }

    public boolean delete(int id) {
        sql = "delete from student where id=?";
        int result = 0;
        try {
            preparedStatement = getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result > 0;
    }

}
