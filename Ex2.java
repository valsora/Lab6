public class Ex2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(1);
        stack.push("hello");
        stack.push("world");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
