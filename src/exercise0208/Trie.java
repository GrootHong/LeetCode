package exercise0208;

/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 */

import java.util.HashMap;

/**
 * 思路：
 * 使用hashMap可以在O(1)时间内完成insert和search的调用，
 * 但是对于startsWith，可以在内部维护一个StringBuilder,
 * 直接在sb中查找
 *
 */
public class Trie {
    /** Initialize your data structure here. */
    private HashMap<String,Boolean> map;
    private StringBuilder sb;
    public Trie() {
        map = new HashMap<>();
        sb = new StringBuilder();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        sb.append(word+" ");
        map.put(word,true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(map.get(word)!=null){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        String str = sb.toString();
        if(str.startsWith(prefix)){
            return true;
        }
        if(str.contains(" "+prefix)){
            return true;
        }
        return false;
    }
}

