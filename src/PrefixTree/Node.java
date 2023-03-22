package PrefixTree;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Node {

    // Ключ корня
    static final char EMPTY_KEY = '\0';

    private final char key;

    private long bytesCount;

    private final Map<Character, Node> children;

    private boolean isEndOfString = false;

    Node(char key, String string) {
        this.key = Character.toLowerCase(key);
        children = new HashMap<>();
        bytesCount = -1;
        if (string.isEmpty()) {
            isEndOfString = true;
        } else {
            add(string, -1);
        }
    }

    Node(char key, String string, long bytesCount) {
        this(key, string);
        this.bytesCount = bytesCount;
    }

    static Node rootNode() {
        return new Node(EMPTY_KEY, "");
    }

    boolean add(String string, long bytesCount) {
        if (string.isEmpty()) {
            boolean contained = isEndOfString;
            isEndOfString = true;
            this.bytesCount = bytesCount;

            return !contained;
        }

        char nextKey = string.charAt(0);

        if (children.containsKey(nextKey)) {
            return children.get(nextKey).add(string.substring(1), bytesCount);
        }

        children.put(nextKey, new Node(nextKey, string.substring(1)));
        return true;
    }

    boolean remove( String string) {
        if (string.isEmpty()) {
            boolean contained = isEndOfString;

            isEndOfString = false;
            return contained;
        }

        char nextKey = string.charAt(0);
        if (!children.containsKey(nextKey))
            return false;

        return children.get(nextKey).remove(string.substring(1));
    }

    Node findChildByPrefix(String prefix) {
        if (prefix.isEmpty())
            return this;

        char nextKey = prefix.charAt(0);

        if (!children.containsKey(nextKey))
            return null;

        return children.get(nextKey).findChildByPrefix(prefix.substring(1));
    }

    Map<Long, String> getAllStringsForThisBranch(Map<Long, String> strings, StringBuilder prefix) {
        prefix.append(key);
        if (isEndOfString) {
            strings.put(bytesCount, prefix.toString());
        }

        for (Node node : children.values()) {
            node.getAllStringsForThisBranch(strings, prefix);
        }
        prefix.deleteCharAt(prefix.length() - 1);

        return strings;
    }

    public long getBytesCount() {
        return bytesCount;
    }
}