package com.example.product;

import jdk.internal.instrumentation.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectionTest {

    @Test
    public void testConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Driver tidak ditemukan");
        }

        String url = "jdbc:postgresql://localhost:5432/blibliProduct";
        String user = "postgres";
        String password = "J@nuary29!";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();

            statement.execute("drop table if exists category");

            String sqlCreateTable = "create table category(\n" +
                    "id varchar(255) primary key, \n" +
                    "name varchar(255) not null \n" +
                    ")";

            statement.execute(sqlCreateTable);

            for (int i = 0; i < 10; i++) {
                //Insert 10 Records

                // Tidak direkomendasikan
//                String sqlInsert = "insert into category(id,name) values(' " + i + "' , '" + i + "');";
//                System.out.println(sqlInsert);
//                statement.execute(sqlInsert);

                String sqlInsert = "insert into category(id, name) values (?, ?);";
                PreparedStatement preparedStatements = con.prepareStatement(sqlInsert);
                preparedStatements.setString(1, String.valueOf(i));
                preparedStatements.setString(2, String.valueOf(i));

                preparedStatements.execute();
                preparedStatements.close();
            }

            ResultSet resultSet = statement.executeQuery("select id, name from category"); //dia lazy load

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
            }

            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Koneksi ke database gagal.");
        }
    }
}
