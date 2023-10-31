/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import bean.UsuariosMgoo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 10916731103
 */


public class UsuarioMgooControle extends AbstractTableModel{
     private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        
    }
    
    public UsuariosMgoo getBean(int linha) {
        return (UsuariosMgoo) lista.get(linha);
           
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        UsuariosMgoo usuarioMgoo = (UsuariosMgoo) lista.get(rowIndex);
        
        if (columnIndex == 0) {
       
            return usuarioMgoo.getIdUsuariosMgoo();
        }
        if (columnIndex == 1) {
            return usuarioMgoo.getNomeMgoo();
        }
        if (columnIndex == 2) {
            return usuarioMgoo.getCpfMgoo();
        }
        if (columnIndex == 3) {
            return usuarioMgoo.getNivelMgoo();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "CPF";
        }
        if (columnIndex == 3) {
            return "Nivel";
        }
        return "";
    }
}

    


