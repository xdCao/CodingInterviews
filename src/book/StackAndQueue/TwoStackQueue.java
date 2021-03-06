package book.StackAndQueue;

import java.util.Stack;

/**
 * Created by xdcao on 2017/7/28.
 * 非常巧妙的设计，用stackPop来维护出队，stackPush维护入队，分工明确，
 * 在stackPop不为空的时候一定不做两个栈之间的数据交换，
 * stackPop只负责已有旧数据的维护，stackPush只负责更新数据的维护
 */
public class TwoStackQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(Integer num){
        stackPush.push(num);
    }

    public Integer poll(){
        if (stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("stacks are empty");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public Integer peek(){
        if (stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("stacks are rmpty");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


    //Tested
    public static void main(String[] args){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        TwoStackQueue twoStackQueue=new TwoStackQueue(stack1,stack2);
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        twoStackQueue.add(5);

        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());

    }


}
