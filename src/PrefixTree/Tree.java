package PrefixTree;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tree {
    private final Node root;

    public Tree() {
        this.root = Node.rootNode();
    }

    public boolean add(String string, long bytesCount) {
        if (string.isEmpty())
            return false;

        return root.add(string, bytesCount);
    }

    public boolean remove(String string) {
        if (string.isEmpty())
            return true;

        return root.remove(string);
    }

    public boolean find(String string) {
        return getNodeByPrefix(string) != null;
    }

    public Map<Long, String> findAll(String prefix) {
        Node prefixedNode = getNodeByPrefix(prefix);
        if (prefixedNode == null || prefixedNode == root)
            return new HashMap<>();

        return prefixedNode.getAllStringsForThisBranch(new HashMap<>(), new StringBuilder(prefix.substring(0, prefix.length() - 1)));
    }

    private Node getNodeByPrefix(String prefix) {
        return root.findChildByPrefix(prefix);
    }
}
