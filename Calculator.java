import java.util.*;
public class Calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        char op=sc.next().charAt(0);
        double result;
        switch(op){
            case '+':{
                result=a+b;
                System.out.println(result);
                break;


            }
            case '-':{
                result=a-b;
                break;
            }
            default:{
                System.out.println("nothing");
            }

        }

    }
}