package fr.newcem.view.panel;

import fr.newcem.model.Test;
import fr.newcem.model.Template;
import fr.newcem.service.BOAccessNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubscribeTemplatePanel extends JPanel {
    private JLabel panelTitle;

    private JLabel labelTemplateName;
    private JTextField actionTemplateName;
    private JTextField actionTemplateAction;
    private JTextField actionTemplateFilMarque;
    private JTextField actionTemplateFilPDV;
    private JTextField actionTemplateNumClient;
    private JTextField actionTemplateVin;
    private JTextField actionTemplateDpiMadax;
    private JTextField actionTemplateDdc;
    private JTextField actionTemplateOffre;

    public SubscribeTemplatePanel() {
        this.init();
    }

    private TemplatesPanel templatesPanel;

    private ExecutionPanel executionPanel;

    public void init() {

        //String actionCode []= {"SO","AN","AV","RS","MS","TR"};
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 150));
        //NORTH: TITLE
        this.panelTitle = new JLabel("Template: action sur contrat");
        panelTitle.setBorder(BorderFactory.createLineBorder(Color.black));


        //WEST: PANELS

        JPanel labelsPanelWrapper = new JPanel();
        JPanel labelsPanel = new JPanel(new GridLayout(0,  2,  5,  5));
        labelsPanel.setPreferredSize(new Dimension(375,150));
        labelsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        labelsPanel.add(new JLabel("Template Name: "));
        actionTemplateName = new JTextField("Souscription");
        labelsPanel.add(actionTemplateName);
        labelsPanel.add(new JLabel("Evenement: "));
        actionTemplateAction = new JTextField("SO");
        labelsPanel.add(actionTemplateAction);
        labelsPanel.add(new JLabel("Marque: "));
        actionTemplateFilMarque = new JTextField("AP");
        labelsPanel.add(actionTemplateFilMarque);
        labelsPanel.add(new JLabel("Point de vente: "));
        actionTemplateFilPDV = new JTextField("999999X");
        labelsPanel.add(actionTemplateFilPDV);
        labelsPanel.add(new JLabel("N°Client: "));
        actionTemplateNumClient = new JTextField("0000000015");
        labelsPanel.add(actionTemplateNumClient);
        labelsPanel.add(new JLabel("VIN: "));
        actionTemplateVin = new JTextField("VF3SF65DFD6545543");
        labelsPanel.add(actionTemplateVin);
        labelsPanelWrapper.add(labelsPanel);

        //CENTER: INPUTS
        JPanel textFieldPanelWrapper = new JPanel();
        JPanel textFieldPanel = new JPanel(new GridLayout(0,  2,  5,  5));
        textFieldPanel.setPreferredSize(new Dimension(375,75));
        textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        textFieldPanel.add(new JLabel("DPI Madax: contrôler initialisation"));
        actionTemplateDpiMadax = new JTextField("");
        textFieldPanel.add(actionTemplateDpiMadax);
        textFieldPanel.add(new JLabel("DDC: "));
        actionTemplateDdc = new JTextField("Date du jour, 01/02/2016");
        textFieldPanel.add(actionTemplateDdc);
        textFieldPanel.add(new JLabel("Offre: "));
        actionTemplateOffre = new JTextField("0000013600+0000009600,36,30000,5+0000012500");
        textFieldPanel.add(actionTemplateOffre);
        textFieldPanelWrapper.add(textFieldPanel);



        //EAST: BUTTONS
        JPanel buttonsPanel = new JPanel(new GridLayout(0,  1,  10,  10));
        buttonsPanel.setPreferredSize(new Dimension(150, 150));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonsPanel.add(createStartButton());
        buttonsPanel.add(createBackgroundChooser());
        buttonsPanel.add(createActionButton());

        //buttonsPanel.add(createGroupPictureChooser());
        //buttonsPanel.add(createBackgroundChooser());
        //buttonsPanel.add(createTargetFolderChooser());

        JPanel westPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        westPanel.add(labelsPanelWrapper, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(textFieldPanelWrapper, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(buttonsPanel,gbc);


        this.add(panelTitle,BorderLayout.NORTH);
        this.add(westPanel,BorderLayout.CENTER);
        //this.add(textFieldPanelWrapper,BorderLayout.CENTER);

    }

    private JButton createActionButton() {
        return new JButton(new AbstractAction("Exécuter") {
            public void actionPerformed(ActionEvent actionEvent) {
                executionPanel.AddActionTemplate(extractExecutionTemplateFromFormSubscribeTemplatePanel());
                BOAccessNavigation souscription = new BOAccessNavigation();

            }
        });
    }

    private JButton createStartButton() {
        return new JButton(new AbstractAction("Dupliquer test") {
            public void actionPerformed(ActionEvent e) {

                templatesPanel.addActionTemplate(extractActionTemplateFromFormSubscribeTemplatePanel());
            }
        });
    }

    private JButton createBackgroundChooser() {
        return new JButton(new AbstractAction("MAJ Test") {
            public void actionPerformed(ActionEvent actionEvent) {
                templatesPanel.updateSelectedTemplate(extractActionTemplateFromFormSubscribeTemplatePanel());
            }
        });
    }

    private JButton createGroupPictureChooser() {
        return new JButton(new AbstractAction("Avenant") {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public void SetSubscribeTemplatePanel(TemplatesPanel templatesPanel, ExecutionPanel executionPanel){
        this.templatesPanel = templatesPanel;
        this.executionPanel = executionPanel;
    }

    private Template extractActionTemplateFromFormSubscribeTemplatePanel(){
        Template formActionTemplate = new Template();
        formActionTemplate.setName(actionTemplateName.getText());
        formActionTemplate.setAction(actionTemplateAction.getText());
        formActionTemplate.setFilMarque(actionTemplateFilMarque.getText());
        formActionTemplate.setFilPdv(actionTemplateFilPDV.getText());
        formActionTemplate.setNumeroClient(actionTemplateNumClient.getText());
        formActionTemplate.setVin(actionTemplateVin.getText());
        formActionTemplate.setDpiMadax(actionTemplateDpiMadax.getText());
        formActionTemplate.setDdc(actionTemplateDdc.getText());
        return formActionTemplate;
    }

    private Test extractExecutionTemplateFromFormSubscribeTemplatePanel(){
        Test actionTest = new Test(extractActionTemplateFromFormSubscribeTemplatePanel(), "TimeStamp de test", 62051242);
        return actionTest;
    }


    public void UpdateForm(Template actionTemplate){
        actionTemplateName.setText(actionTemplate.getName());
        actionTemplateAction.setText(actionTemplate.getAction());
        actionTemplateFilMarque.setText(actionTemplate.getFilMarque());
        actionTemplateFilPDV.setText(actionTemplate.getFilPdv());
        actionTemplateNumClient.setText(actionTemplate.getNumeroClient());
        actionTemplateVin.setText(actionTemplate.getVin());
        actionTemplateDpiMadax.setText(actionTemplate.getDpiMadax());
        actionTemplateDdc.setText(actionTemplate.getDdc());

    }
}
