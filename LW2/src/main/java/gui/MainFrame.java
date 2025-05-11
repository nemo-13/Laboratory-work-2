package gui;

import ork.OrkBuilder;
import army.ArmyManager;
import builderfactory.*;
import ork.Ork;
import ork.OrkDirector;
import ork.OrkType;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private final ArmyManager armyManager = new ArmyManager();
    private final OrkDirector director = new OrkDirector();
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private OrkInfoPanel infoPanel;

    public MainFrame() {
        setTitle("Менеджер Армии");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel creationPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        creationPanel.setBorder(BorderFactory.createTitledBorder("Создание орка"));

        JComboBox<String> tribeCombo = new JComboBox<>(new String[]{"Мордор", "Мглистые горы", "Дол Гулдур"});
        JComboBox<OrkType> typeCombo = new JComboBox<>(OrkType.values());
        JButton createButton = new JButton("Создать");

        creationPanel.add(new JLabel("Племя:"));
        creationPanel.add(tribeCombo);
        creationPanel.add(new JLabel("Тип:"));
        creationPanel.add(typeCombo);
        creationPanel.add(createButton);

        add(creationPanel, BorderLayout.NORTH);

        JSplitPane mainSplitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitter.setDividerLocation(300);
        
        treeModel = new DefaultTreeModel(armyManager.getArmyTree());
        armyTree = new JTree(treeModel);
        armyTree.setRootVisible(true);

        mainSplitter.setLeftComponent(new JScrollPane(armyTree));

        infoPanel = new OrkInfoPanel();
        mainSplitter.setRightComponent(infoPanel);

        add(mainSplitter, BorderLayout.CENTER);

        createButton.addActionListener((ActionEvent e) -> createOrk(tribeCombo, typeCombo));
        armyTree.addTreeSelectionListener(e -> updateOrkInfo());
    }

    private void createOrk(JComboBox<String> tribeCombo, JComboBox<OrkType> typeCombo) {
        try {
            String tribe = (String) tribeCombo.getSelectedItem();
            OrkType type = (OrkType) typeCombo.getSelectedItem();
            OrkBuilder builder = getBuilderFactory(tribe).createOrkBuilder();
            Ork ork = director.createOrk(builder, type);

            armyManager.addOrk(ork);

            DefaultMutableTreeNode tribeNode = armyManager.findTribeNode(tribe);
            if (tribeNode != null) {
                tribeNode.add(new DefaultMutableTreeNode(ork));
                treeModel.reload();
                armyTree.expandPath(new TreePath(tribeNode.getPath()));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateOrkInfo() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
        if (node != null && node.getUserObject() instanceof Ork) {
            Ork ork = (Ork) node.getUserObject();
            infoPanel.updateInfo(ork);
        }
    }

    private OrkBuilderFactory getBuilderFactory(String tribe) {
        return switch (tribe) {
            case "Мордор" -> new MordorOrkBuilderFactory();
            case "Мглистые горы" -> new MistyMountainsOrkBuilderFactory();
            case "Дол Гулдур" -> new DolGuldurOrkBuilderFactory();
            default -> throw new IllegalArgumentException("Неизвестное племя");
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}