package fr.newcem.view.tableModel;

import fr.newcem.model.Template;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moi on 18/12/2016.
 */
public class TemplateTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<Template> templateTableListModel;

    private int currentlySelectedRowIndex;

    public TemplateTableModel()  {
        this.templateTableListModel = new ArrayList<Template>();
        templateTableListModel.add(new Template());
        templateTableListModel.add(new Template());
        templateTableListModel.add(new Template("ff","565","fddfgf651","dvdf","fghfg","ff","565","fddfgf651"));
    }

    public int getRowCount() {
        return templateTableListModel.size();
    }


    public int getColumnCount() {
        return 8;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0) {
            return templateTableListModel.get(rowIndex).getName();
        }
        if(columnIndex==3) {
            return templateTableListModel.get(rowIndex).getAction();
        }
        if(columnIndex==1) {
            return templateTableListModel.get(rowIndex).getFilMarque();
        }
        if(columnIndex==2) {
            return templateTableListModel.get(rowIndex).getFilPdv();
        }
        if(columnIndex==4) {
            return templateTableListModel.get(rowIndex).getNumeroClient();
        }
        if(columnIndex==5) {
            return templateTableListModel.get(rowIndex).getVin();
        }
        if(columnIndex==6) {
            return templateTableListModel.get(rowIndex).getDpiMadax();
        }
        if(columnIndex==7) {
            return templateTableListModel.get(rowIndex).getDdc();
        }

        return templateTableListModel;
    }

    public String getColumnName(int column){
        if(column==0){
            return "TemplateName";
        }
        else if(column==1){
            return "Action";
        }
        else if(column==2){
            return "Marque";
        }
        else if(column==3){
            return "PDV";
        }
        else if(column==4){
            return "N°Client";
        }
        else if(column==5){
            return "VIN";
        }
        else if(column==6){
            return "DPI MADAX";
        }
        else if(column==7){
            return "DDC";
        }
        else{return "colonne sans nom";}
    }

    public void addActionTemplate(Template actionTemplate){
        templateTableListModel.add(actionTemplate);
    }
    public boolean isCellEditable(int row, int col)
    { return true; }

    public Template getSelectedActionTemplate(int rowIndex){
        return  templateTableListModel.get(rowIndex);
    }

    public void updateCurrentlySelectedTemplateWithFormValue(Template template){
        templateTableListModel.set(getCurrentlySelectedRowIndex(),template);
    }



    public void setCurrentlySelectedRowIndex(int currentlySelectedRowIndex){
        this.currentlySelectedRowIndex = currentlySelectedRowIndex;
    }

    public int getCurrentlySelectedRowIndex(){
       return  this.currentlySelectedRowIndex;
    }
}
