package com.test.bot.frontend.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginToken{

    PostgresUtility postgresUtility =new PostgresUtility();

    public String obtener_token(String COLUMNA_URL_BD,String COLUMNA_TIPO_BD,String COLUMNA_PORT_BD,String COLUMNA_USER_BD,String COLUMNA_PWS_BD, String COLUMNA_USUARIO) throws SQLException {

        Connection conn= postgresUtility.connectDatabase(COLUMNA_URL_BD,COLUMNA_PORT_BD,COLUMNA_TIPO_BD,COLUMNA_USER_BD,COLUMNA_PWS_BD);
        Statement stmt = conn.createStatement();
        int cod= Integer.parseInt(COLUMNA_USUARIO);
        ResultSet rs= stmt.executeQuery("SELECT * FROM ibmx_a07e6d02edaf552.tdp_token_vendedor WHERE codatis='"+cod+"'");
        String token=null;
        while (rs.next()) {
            token = rs.getString("token");
            System.out.println(token);
        }
        conn.close();
        return token;
    }

}
