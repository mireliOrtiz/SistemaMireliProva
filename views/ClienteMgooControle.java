/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import bean.ClienteMgoo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 10916731103
 */


public class ClienteMgooControle extends AbstractTableModel{
     private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        
    }
    
    public ClienteMgoo getBean(int linha) {
        return (ClienteMgoo) lista.get(linha);
           
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
        
        ClienteMgoo clienteMgoo = (ClienteMgoo) lista.get(rowIndex);
        
        if (columnIndex == 0) {
       
            return clienteMgoo.getIdClienteMgoo();
        }
        if (columnIndex == 1) {
            return clienteMgoo.getNomeMgoo();
        }
        if (columnIndex == 2) {
            return clienteMgoo.getCpfMgoo();
        }
        if (columnIndex == 3) {
            return clienteMgoo.getTelefoneMgoo();
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
            return "Cpf";
        }
        if (columnIndex == 3) {
            return "Telefone";
        }
        return "";
    }
}

    


