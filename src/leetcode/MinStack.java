package leetcode;

public class MinStack {
    int[] stk;
    int top;
    int min;

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(-0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    public MinStack() {
        stk = new int[3*10000];
        top = -1;
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Math.min(min, val);
        top++;
        stk[top] = val;
    }

    public void pop() {
        //adjust min value
        if(stk[top] == min){
            min = Integer.MAX_VALUE;
            for (int i=0; i<top; i++){
                min = Math.min(stk[i], min);
            }
        }

        top--;
    }

    public int top() {
        return stk[top];
    }

    public int getMin() {
        return min;
    }
}
