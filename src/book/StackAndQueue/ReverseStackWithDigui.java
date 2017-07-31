package book.StackAndQueue;

import java.util.Stack;

/**
 * Created by xdcao on 2017/7/28.
 * 递归果然比较难懂。。
 */
public class ReverseStackWithDigui {

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result=stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last=getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);

    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
    }

}
