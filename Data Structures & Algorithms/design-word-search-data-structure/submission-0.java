class Node {
    char ch;
    Node[] child = new Node[26];
    boolean isEnd;

    public Node(char ch) {
        this.ch = ch;
        this.isEnd = false;
    }
}

class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node('#');   // dummy
    }

    public void insertInternal(String word, int indx, Node node) {
        if (indx == word.length()) {
            node.isEnd = true;
            return;
        }
        char ch = word.charAt(indx);
        if (node.child[ch-'a'] == null) {
            node.child[ch-'a'] = new Node(ch);
        }
        insertInternal(word, indx+1, node.child[ch-'a']);
    }

    public void insert(String word) {
        insertInternal(word, 0, root);
    }

    public boolean searchInternal(String word, int indx, Node node) {
        if (indx == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(indx);
        if (ch == '.') {
            for (int i=0; i<26; i++) {
                if (node.child[i] != null) {
                    if (searchInternal(word, indx+1, node.child[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (node.child[ch - 'a'] != null) return searchInternal(word, indx+1, node.child[ch-'a']);
            else return false;
        }
    }

    public boolean search(String word) {
        return searchInternal(word, 0, root);
    }

    public boolean startsWithInternal(String word, int indx, Node node) {
        if (indx == word.length()) {
            return true;
        }

        char ch = word.charAt(indx);
        if (node.child[ch - 'a'] != null) return startsWithInternal(word, indx+1, node.child[ch-'a']);
        else return false;
    }

    public boolean startsWith(String prefix) {
        return startsWithInternal(prefix, 0, root);
    }
}

class WordDictionary {

    PrefixTree prefixTree;

    public WordDictionary() {
        prefixTree = new PrefixTree();
    }

    public void addWord(String word) {
        prefixTree.insert(word);
    }

    public boolean search(String word) {
        return prefixTree.search(word);
    }
}