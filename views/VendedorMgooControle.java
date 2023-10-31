/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import bean.VendedorMgoo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 10916731103
 */


public class VendedorMgooControle extends AbstractTableModel{
     private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        
    }
    
    public VendedorMgoo getBean(int linha) {
        return (VendedorMgoo) lista.get(linha);
           
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        VendedorMgoo vendedorMgoo = (VendedorMgoo) lista.get(rowIndex);
        
        if (columnIndex == 0) {
       
            return vendedorMgoo.getIdVendedorMgoo();
        }
        if (columnIndex == 1) {
            return vendedorMgoo.getNomeMgoo();
        }
        if (columnIndex == 2) {
            return vendedorMgoo.getCpfMgoo();
        }
        if (columnIndex == 3) {
            return vendedorMgoo.getTelefoneMgoo();
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

    


