package StackAndQueue;

import java.util.Stack;

/**
 * Created by xdcao on 2017/7/28.
 */
public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(Integer num){

        stackData.push(num);

        if (stackMin.isEmpty()){
            stackMin.push(num);
        }else {
            if (num<=getMin()){
                stackMin.push(num);
            }else {
                stackMin.push(getMin());
            }
        }

    }


    public Integer pop(){

        if (stackData.isEmpty()){
            throw new RuntimeException("stackData is empty");
        }else {
            stackData.pop();
            return stackMin.pop();
        }


    }

    public Integer getMin(){

        if(this.stackMin.isEmpty()){
            throw new RuntimeException("stackmin is empty");
        }else {
            return stackMin.peek();
        }

    }


}
