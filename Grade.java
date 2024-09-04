package JAVA;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        String sub[]={"Hindi","English","Math","Chemistry","Physics","Drawing"};
        int mark[]=new int[sub.length];
        int marks=0;
        Scanner in=new Scanner(System.in);
        for(int i=0;i<sub.length;i++){
            System.out.print("Enter the marks of "+sub[i]+" subject :");
            mark[i]=in.nextInt();
            marks+=mark[i];
        }
        int avgMarks=marks/sub.length;
        char grade=' ';
        if (avgMarks>80) {
            grade='A';
        } else if(avgMarks<=80 &&avgMarks>60){
            grade='B';
        }else{
            grade='C';
        }
        System.out.println("Total marks in all subjects = "+marks);
        System.out.println("Average marks are = "+avgMarks);
        System.out.println("The Grade is = "+grade);

    }
}
