package JAVA;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public int RandomNum(){
        Random rand=new Random();
        int num=rand.nextInt(100)+1;
        return num;
    }
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=in.nextInt();
        NumberGame ngame=new NumberGame();
        ngame.check(n);
    }
    public void check(int n){
        if(n==RandomNum()){
            System.out.println("You guessed right Number");
        }
        else{
            if(n<RandomNum()){
                System.out.println("Too Low");
            }
            else{
                System.err.println("Too High");
            }
        }
    }
}
