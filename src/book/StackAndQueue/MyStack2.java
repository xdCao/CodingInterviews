package book.StackAndQueue;

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

    //Tested
    public static void main(String[] args){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        MyStack2 myStack2=new MyStack2(stack1,stack2);

        myStack2.push(2);
        System.out.println(myStack2.getMin());
        myStack2.push(4);
        System.out.println(myStack2.getMin());
        myStack2.push(1);
        System.out.println(myStack2.getMin());
        myStack2.pop();
        System.out.println(myStack2.getMin());
        myStack2.pop();
        System.out.println(myStack2.getMin());
        myStack2.pop();
        System.out.println(myStack2.getMin());
        myStack2.pop();
        System.out.println(myStack2.getMin());

    }


}
