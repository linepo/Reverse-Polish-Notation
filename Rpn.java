package pauline;

import java.util.Stack;

public class Rpn {

    public static void main(String[] args) {
        String[] str = new String[] { "3", "4", "-", "5", "+" };
        System.out.println("'34-5+' = "  + calculRPN(str));
        String[] str2 = new String[] { "3", "4", "5", "*", "-" };
        System.out.println("'345*-' = "  + calculRPN(str2));
    }

    public static int calculRPN(String[] str) {

        String operateurs = "+-*/";
        Stack<String> tmp = new Stack<String>();
 
        for(String s : str){
            if(!operateurs.contains(s)){
                tmp.push(s);
            }else{
                int a = Integer.valueOf(tmp.pop());
                int b = Integer.valueOf(tmp.pop());
                int index = operateurs.indexOf(s);
                switch(index){
                    case 0:
                        tmp.push(String.valueOf(a+b));
                        break;
                    case 1:
                        tmp.push(String.valueOf(b-a));
                        break;
                    case 2:
                        tmp.push(String.valueOf(a*b));
                        break;
                    case 3:
                        tmp.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        
        return Integer.valueOf(tmp.pop());
    }
}
