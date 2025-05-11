package army;

import ork.Ork;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmyManager {
    private final Map<String, List<Ork>> army = new HashMap<>();
    private final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Армия");

    public ArmyManager() {
        rootNode.add(new DefaultMutableTreeNode("Мордор"));
        rootNode.add(new DefaultMutableTreeNode("Мглистые горы"));
        rootNode.add(new DefaultMutableTreeNode("Дол Гулдур"));
    }

    public void addOrk(Ork ork) {
        army.computeIfAbsent(ork.getTribe(), k -> new ArrayList<>()).add(ork);
        DefaultMutableTreeNode tribeNode = findTribeNode(ork.getTribe());
        if (tribeNode != null) tribeNode.add(new DefaultMutableTreeNode(ork.getName()));
    }

    public DefaultMutableTreeNode getArmyTree() {
        return rootNode;
    }

    public Ork findOrkByName(String name) {
        for (List<Ork> tribeOrks : army.values()) {
            for (Ork ork : tribeOrks) {
                if (ork.getName().equals(name)) {
                    return ork;
                }
            }
        }
        return null;
    }

    public DefaultMutableTreeNode findTribeNode(String tribe) {
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) rootNode.getChildAt(i);
            if (node.getUserObject().equals(tribe)) return node;
        }
        return null;
    }
}