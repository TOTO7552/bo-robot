package fr.newcem.view.panel;

import fr.newcem.model.Test;
import fr.newcem.view.tableModel.ExecutionTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moi on 18/12/2016.
 */
public class ExecutionPanel extends JPanel {

    private JTable executionTable;
    private SubscribeTemplatePanel subscribeTemplatePanel;

    public ExecutionPanel(SubscribeTemplatePanel subscribeTemplatePanel) {
        this.subscribeTemplatePanel = subscribeTemplatePanel;
        this.init();
    }

    public void init() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(700, 300));


        ExecutionTableModel modelTemplate = new ExecutionTableModel();

        this.executionTable = new JTable(modelTemplate);
        this.executionTable.setBounds(20, 20, 500, 200);

        this.add(executionTable);
        //JPanel thisPanelWrapper = new JPanel();
        //this.add(thisPanelWrapper);


    }

    public void AddActionTemplate(Test actionTest){
        ((ExecutionTableModel) executionTable.getModel()).AddActionTemplate(actionTest);
        ((ExecutionTableModel) executionTable.getModel()).fireTableDataChanged();
    }

    public JTable getExecutionTable(){
        return this.executionTable;
    }

}
