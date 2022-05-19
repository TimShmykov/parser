package ru.TimShmykov.parser;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.Properties;

//public class DbMain {
//    public static void main(String[] args) {// throws SQLException {
//       String url = "jdbc:h2:mem:";
//
//     //  Connection con = DriverManager.getConnection(url);
//     //  Statement st = con.createStatement(); // Защита базы?
//     //  ResultSet rs = st.executeQuery("select 1+1"); // некий запрос?
//     //  if(rs.next()){
//     //      System.out.println(rs.getInt(1));
//     //  }
//     //  DriverDataSource dataSource = new DriverDataSource(
//     //          url,
//     //          "org.h2.Driver",
//     //          new Properties(),
//     //          "sa",
//     //          ""
//     //  );
//     //  JdbcTemplate template = new JdbcTemplate(dataSource);
//
//
//
//        Integer integer = template.queryForObject("select 1+1", Integer.class); // взаимодействие с базой
//        System.out.println(integer);
//    }
//}
