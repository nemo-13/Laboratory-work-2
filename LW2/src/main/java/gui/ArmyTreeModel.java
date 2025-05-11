package gui;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ArmyTreeModel extends DefaultTreeModel {
    public ArmyTreeModel(DefaultMutableTreeNode root) {
        super(root);
    }

    public void addOrkToTree(DefaultMutableTreeNode tribeNode, String orkName) {
        DefaultMutableTreeNode orkNode = new DefaultMutableTreeNode(orkName);
        tribeNode.add(orkNode);
        nodesWereInserted(tribeNode, new int[]{tribeNode.getChildCount() - 1});
    }
}
