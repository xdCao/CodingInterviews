package StackAndQueue;

import java.util.Stack;

/**
 * Created by xdcao on 2017/7/28.
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int newNum){

        if (this.stackMin.isEmpty()){
            stackMin.push(newNum);
        }else {
            if (newNum<=stackMin.peek()){
                this.stackMin.push(newNum);
            }
        }

        stackData.push(newNum);

    }

    public Integer pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("stack is empty");
        }else {
            Integer pop = stackData.pop();
            if (pop<=stackMin.peek()){
                stackMin.pop();
            }
            return pop;
        }
    }

    public Integer getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("stackmin is empty");
        }else {
            return this.stackMin.peek();
        }
    }


}
