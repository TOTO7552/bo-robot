package fr.newcem.view;
import fr.newcem.view.panel.ExecutionPanel;
import fr.newcem.view.panel.SubscribeTemplatePanel;
import fr.newcem.service.BOAccessNavigation;
import fr.newcem.view.panel.TemplatesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;


public class MainView extends JFrame {

    private String soloPicturesFolderPath;
    private String groupePicturesFolderPath;
    private String backgroundPicturesFolderPath;
    private String targetFolder;

    private JLabel templatesListTitle;
    private JLabel ExecutedTestListTitle;


    public MainView() throws HeadlessException {

        //JPanel panelDesignAndRunButton = new JPanel(new GridLayout(5,1));
        //JPanel panelDesignAndRunButtonLean = new JPanel(new GridBagLayout());
        //Insets leanButtonInsets = new Insets(5,5,5,5);
        //panelDesignAndRunButtonLean.add(createFileChooser(),new GridBagConstraints(0,1,1,2,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH, leanButtonInsets,0,0));
        this.setLayout(new BorderLayout(5,5));

        JPanel listPanelWrapper= new JPanel();

        //ACTION TEMPLATES PANEL
        //JPanel wrapper1= new JPanel();
        SubscribeTemplatePanel subscribeTemplatePanel = new SubscribeTemplatePanel();
        TemplatesPanel templatesPanel = new TemplatesPanel(subscribeTemplatePanel);


        listPanelWrapper.add(templatesPanel);
        this.templatesListTitle = new JLabel("Scenario d'actions");
        //EAST: BUTTONS
        JPanel buttonsPanel = new JPanel(new GridLayout(0,  1,  10,  10));
        buttonsPanel.add(templatesListTitle);
        buttonsPanel.setPreferredSize(new Dimension(150, 150));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonsPanel.add(createStartButton());
        buttonsPanel.add(createBackgroundChooser());
        buttonsPanel.add(createActionButton());

        listPanelWrapper.add(buttonsPanel);


        //TESTING QUEUE PANEL
        //JPanel wrapper2 = new JPanel();
        SubscribeTemplatePanel subscribeTemplatePanel2 = new SubscribeTemplatePanel();
        ExecutionPanel templatesPanel2 = new ExecutionPanel(subscribeTemplatePanel2);
        listPanelWrapper.add(templatesPanel2);
        this.ExecutedTestListTitle = new JLabel("Testing Queue");
        listPanelWrapper.add(ExecutedTestListTitle);

        //listPanelWrapper.add(wrapper1);
        //listPanelWrapper.add(wrapper2);
        subscribeTemplatePanel.SetSubscribeTemplatePanel(templatesPanel,templatesPanel2);

        this.add(subscribeTemplatePanel,BorderLayout.WEST);
        this.add(listPanelWrapper,BorderLayout.CENTER);
        //this.add(wrapper2,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 600);
        this.setVisible(true);
    }



    private JButton createStartButton() {
        return new JButton(new AbstractAction("Jouer actions dans l'odre") {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private JButton createBackgroundChooser() {
        return new JButton(new AbstractAction("Sauver scénario") {
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
    }
    private JButton createActionButton() {
        return new JButton(new AbstractAction("Supprimer test") {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
