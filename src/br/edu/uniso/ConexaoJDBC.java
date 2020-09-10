package br.edu.uniso;

import java.sql.*;

public class ConexaoJDBC {

    public static void main (String args[]){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://34.225.155.37:3306/bianca_campos","bianca_campos","mingau123");
            boolean valido = c.isValid(10000);
            System.out.println("Conexão é válida "+ valido);

            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("select * from ALUNO");
            while (rs.next()){
                System.out.println("RA: "+ rs.getInt("ra"));
                System.out.println("nome: "+rs.getString("primeiro_nome"));
                System.out.println("sobrenome: "+rs.getString("sobrenome"));
                System.out.println("Idade: "+ rs.getInt("idade"));

            }

            Statement i = c.createStatement();
            int resultado = i.executeUpdate("insert into ALUNO (ra, primeiro_nome, sobrenome, idade) values"+ "(15858, 'Guilherme', 'Vanini', 20)");

            System.out.println(resultado);



            rs.close();
            i.close();
            s.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
