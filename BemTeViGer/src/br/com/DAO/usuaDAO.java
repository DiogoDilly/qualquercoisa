/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.DTO.UsuariosDTO;
import java.sql.*;

import javax.swing.JOptionPane;
import br.com.VIEWS.Cadastro;
import br.com.VIEWS.Login;
/**
 *
 * @author aluno.saolucas
 */
public class usuaDAO {
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

  public void NovoUsu(UsuariosDTO objUsuaDTO) {
        String sql = ("insert into usuario( nome_usuario,senha_usuario) values(?, ?) ");

        conexao = ConexaoDAO.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuaDTO.getNomeUsu());
            pst.setString(2, objUsuaDTO.getSenhaUsu());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            pst.close();

        } catch (Exception e) {

            if (e.getMessage().contains("'usuario.username'")) {
                JOptionPane.showMessageDialog(null, "login ja existente, Usuario não foi inserido ");
                LimpaCampos();

            }
            JOptionPane.showMessageDialog(null, e);

        }

    }
  
  public void ApagaUsu(UsuariosDTO objUsuaDTO) {

        String sql = "delete from usuario where id = ?";
        conexao = ConexaoDAO.conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuaDTO.getId());

            int del = pst.executeUpdate();

            if (del > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuario deletado");
                LimpaCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " metodo apagar " + e);

        }

    }
  public void EditarUsu(UsuariosDTO objUsuaDTO) {
        String sql = "update usuario set  nome_usuario = ?, senha_usuario = ? where id = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(3, objUsuaDTO.getId());
            pst.setString(1, objUsuaDTO.getNomeUsu());
            pst.setString(2, objUsuaDTO.getSenhaUsu());

            int edit = pst.executeUpdate();

            if (edit > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                LimpaCampos();
                conexao.close();
            }
   } catch (Exception e) {
              JOptionPane.showMessageDialog(null, " Método editar " + e);
        }

    }
  
    public void LimpaCampos(){
         Cadastro.txtNomeUsu.setText(null);
         Cadastro.newSenhaUsu.setText(null);
         Login.txtNome.setText(null);
         Login.txtSenha.setText(null);
       
    }
}
