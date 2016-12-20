package fr.newcem.view.panel;
import fr.newcem.model.Template;
import fr.newcem.view.Listener.TemplateListSelectionListener;
import fr.newcem.view.tableModel.TemplateTableModel;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;

public class TemplatesPanel extends JPanel  {

    private JTable templatesTable;
    private SubscribeTemplatePanel subscribeTemplatePanel;
    private TemplateTableModel modelTemplate;

    public TemplatesPanel(SubscribeTemplatePanel subscribeTemplatePanel) {
        this.subscribeTemplatePanel = subscribeTemplatePanel;
        this.init();
    }

    public void init() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(700, 300));


        this.modelTemplate = new TemplateTableModel();
        this.templatesTable = new JTable(modelTemplate);
        this.templatesTable.setBounds(20, 20, 500, 200);
        this.add(new JScrollPane(templatesTable));

        templatesTable.getSelectionModel().addListSelectionListener(new TemplateListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                modelTemplate.setCurrentlySelectedRowIndex(templatesTable.getSelectedRow());

                subscribeTemplatePanel.UpdateForm(modelTemplate.getSelectedActionTemplate(templatesTable.getSelectedRow()));
                System.out.println(templatesTable.getValueAt(templatesTable.getSelectedRow(), 0).toString());

            }
        });
        this.add(templatesTable);
        //JPanel thisPanelWrapper = new JPanel();
        //this.add(thisPanelWrapper);


    }

    public void addActionTemplate(Template actionTemplate){
        ((TemplateTableModel) templatesTable.getModel()).addActionTemplate(actionTemplate);
        ((TemplateTableModel) templatesTable.getModel()).fireTableDataChanged();
    }


    public JTable getTemplatesTable(){
        return this.templatesTable;
    }

    public void updateSelectedTemplate(Template template){
        ((TemplateTableModel)templatesTable.getModel()).updateCurrentlySelectedTemplateWithFormValue(template);
        ((TemplateTableModel)templatesTable.getModel()).fireTableDataChanged();
    }
}
