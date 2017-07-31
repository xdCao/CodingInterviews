package book.StackAndQueue;

import java.util.Stack;

/**
 * Created by xdcao on 2017/7/28.
 */
public class SortStackByStack {

    private Stack<Integer> stack;

    private Stack<Integer> helper;

    private Integer cur;

    public SortStackByStack(Stack<Integer> stack) {
        this.stack = stack;
        this.helper = new Stack<>();
    }


    public Stack<Integer> sort(){

        if (stack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }else {
            while (!stack.isEmpty()){
                cur=stack.pop();
                if (helper.isEmpty()){
                    helper.push(cur);
                }else {
                    if (cur<helper.peek()){
                        helper.push(cur);
                    }else if (cur>=helper.peek()){
                        while (!helper.isEmpty()){
                            stack.push(helper.pop());
                        }
                        helper.push(cur);
                    }
                }
            }
        }
        return helper;
    }


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        SortStackByStack sortStackByStack=new SortStackByStack(stack);
        Stack<Integer> sort = sortStackByStack.sort();
        System.out.println(sort);

    }



}
