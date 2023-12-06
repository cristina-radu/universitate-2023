package org.example.service;

import org.example.model.Student;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcService {

    public void insertStudent(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO student(first_name, last_name, age, score)" +
                    " VALUES ('Ion', 'Mircea', 21, 9)");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public List<Student> findStudents(){
        List<Student> students = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *  FROM STUDENT");
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setAge(rs.getInt("age"));
                student.setScore(rs.getInt("score"));
                students.add(student);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return students;
    }

    public void findWithParams(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student where age = ?");
            ps.setInt(1, 21);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("first_name") + " "+ rs.getString("last_name"));
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    /*delimiter //
        CREATE PROCEDURE insertStudent(OUT id int,
          IN firstName varchar(30), IN lastName varchar(30), IN age int, IN score int)
        BEGIN
        INSERT INTO student(first_name, last_name, age, score) VALUES (firstName, lastName, age, score);
        SET id = LAST_INSERT_ID();
        END //
        delimiter ;
*/

    public Student executeProcedure(Student student){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

            CallableStatement cs = connection.prepareCall("{call insertStudent(?, ?, ?, ?, ?)}");
            cs.setString(2, student.getFirstName());
            cs.setString(3, student.getLastName());
            cs.setInt(4, student.getAge());
            cs.setInt(5, student.getScore());

            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();
            student.setId(cs.getInt(1));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return student;
    }

}
