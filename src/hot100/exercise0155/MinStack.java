package hot100.exercise0155;

import java.util.ArrayList;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 */
public class MinStack {
    private ArrayList<Integer> min;
    private ArrayList<Integer> list;
    private  int index;
    /** initialize your data structure here. */
    public MinStack() {
        list =new ArrayList<>();
        min = new ArrayList<>();
        index = 0;
    }

    public void push(int x) {
        list.add(index,x);
        if(min.size()==0){
            min.add(x);
            index++;
        } else {
            min.add(Math.min(x,min.get(index-1)));
            index++;
        }
    }

    public void pop() {
        list.remove(index-1);
        min.remove(--index);
    }

    public int top() {
        return list.get(index-1);
    }

    public int getMin() {
        return min.get(index-1);
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(5);
        s.push(4);
        System.out.println(s.getMin());
        s.push(2);
        s.pop();
        s.push(3);
        System.out.println(s.getMin());
        s.pop();
        s.push(1);
        s.push(8);
        System.out.println(s.top());
        System.out.println(s.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */