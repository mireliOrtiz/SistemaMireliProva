/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import bean.ProdutoMgoo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 10916731103
 */


public class ProdutoMgooControle extends AbstractTableModel{
     private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        
    }
    
    public ProdutoMgoo getBean(int linha) {
        return (ProdutoMgoo) lista.get(linha);
           
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
        
       ProdutoMgoo produtoMgoo = (ProdutoMgoo) lista.get(rowIndex);
        
        if (columnIndex == 0) {
       
            return produtoMgoo.getIdProdutoMgoo();
        }
        if (columnIndex == 1) {
            return produtoMgoo.getMarcaMgoo();
        }
        if (columnIndex == 2) {
            return produtoMgoo.getModeloMgoo();
        }
        if (columnIndex == 3) {
            return produtoMgoo.getAnoFabricacaoMgoo();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Marca";
        }
        if (columnIndex == 2) {
            return "Modelo";
        }
        if (columnIndex == 3) {
            return "Ano de Fabricação";
        }
        return "";
    }

  
}

    


