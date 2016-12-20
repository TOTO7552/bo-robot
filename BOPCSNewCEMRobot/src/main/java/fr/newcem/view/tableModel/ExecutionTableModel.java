package fr.newcem.view.tableModel;

import fr.newcem.model.Test;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ExecutionTableModel extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    private List<Test> templateTableListModel;

    public ExecutionTableModel()  {
        this.templateTableListModel = new ArrayList<Test>();


    }


    public int getRowCount() {
        return templateTableListModel.size();
    }


    public int getColumnCount() {
        return 11;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        int i = 0;

        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getAction();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getContratCode();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getActionDate();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getFilMarque();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getName();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getNumeroClient();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getVin();
        }

        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getDdc();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getDpiMadax();
        }
        i++;
        if(columnIndex==i) {
            return templateTableListModel.get(rowIndex).getFilPdv();
        }
        return templateTableListModel;
    }

    public String getColumnName(int columnIndex){

        int i = 0;

        if(columnIndex==i) {
            return "Action";
        }
        i++;
        if(columnIndex==i) {
            return "ContratCode";
        }
        i++;
        if(columnIndex==i) {
            return "Occur date";
        }
        i++;
        if(columnIndex==i) {
            return "Marque";
        }
        i++;
        if(columnIndex==i) {
            return "TemplateName";
        }
        i++;
        if(columnIndex==i) {
            return "N°Client";
        }
        i++;
        if(columnIndex==i) {
            return "VIN";
        }

        i++;
        if(columnIndex==i) {
            return "DDC";
        }
        i++;
        if(columnIndex==i) {
            return "DPI MADAX";
        }
        i++;
        if(columnIndex==i) {
            return "PDV";
        }

        else{return "colonne sans nom";}


    }

    public void AddActionTemplate(Test actionTest){
        templateTableListModel.add(actionTest);

    }


}
