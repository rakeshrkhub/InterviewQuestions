package EnpassTechnologies;

public class PrimeNumber {
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n<=3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // write a program to print prime numbers between 0 and 99.
        for(int i=0;i<=99;i++){
            if(isPrime(i)==true){
                System.out.print(i+" ");
            }
        }
    }

}
