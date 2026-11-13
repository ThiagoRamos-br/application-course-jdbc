package entities;

import exception.DbException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Properties loadProperties () {
        try (FileInputStream fs = new FileInputStream("src/db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Connection conect = null;

    /* aqui ele faz a conecção do banco com a ajuda do
     loadproperties que encontrou o endereço do banco na sua pasta
     ai ele instancia o drivermanager e chama o metodo
     getconmection e adiciona as variaveis
     url = onde tem o endereço da url do banco
     props= e aqui tem o metodo loadproperties q fez
     todo o comando de endereçamento com o banco*/
    public static Connection getConect() {
        if (conect == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conect = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conect;
    }


    // aqui ele fecha a conecção com banco para que nao fique aberta
    public static void closeConect () {
        if (conect != null) {
            try {
                conect.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatemant (Statement st) {
        if (st != null) {
            try{
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
    }

    public static void closeResultSet (ResultSet rs) {
        if (rs != null) {
            try{
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
    }
}
