package hot100.exercise0146;

/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
进阶:
你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 思路：
 * 底层使用HashMap实现，可以在O(1)时间内找到对应的key。
 * 最需要关注的问题是：怎样确定最不常用的数据。
 * 如果一直调用的是put函数，那么最先添加进的一定是最不常用的。
 * 如果有调用get方法，那么这个get到的值就是目前为止最新的。
 * ---------------------------------------------------
 * 使用动态规划算法，定义一个链表dp，
 * 如果对LRUCache进行put操作，则同时在dp链表最后添加一个相同值，表示这个值是最新添加的。
 * 如果put时，是修改底层map的值，则对dp链表中对应的值删除，然后在链表尾重新添加，
 * 如果是get时，则将dp链表中对应的值删除，重新在链表尾添加。
 * 上述方法能保证dp链表的头结点始终是最不常用的。但是时间复杂度并没有到O(1);
 *
 *
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        int num = l.get(1);
        l.put(3,3);
        num = l.get(2);
        l.put(4,4);
        num = l.get(1);
        num = l.get(3);
        num = l.get(4);

    }
    private int capacity;
    private HashMap<Integer,Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }
    public int get(int key) {
        if(cache.get(key)==null){
            return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
        return value;
    }
    public void put(int key, int value) {
        if(cache.get(key)==null){
            if(capacity>0){
                capacity--;
                cache.put(key,value);
            } else {
                cache.remove(getFirstKey());
                cache.put(key,value);
            }
        } else {
            cache.remove(key);
            cache.put(key,value);
        }
    }

    private int getFirstKey(){
        for(int i : cache.keySet()){
            return i;
        }
        return -1;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */