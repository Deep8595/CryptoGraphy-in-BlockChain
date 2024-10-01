/* 
   step 1) let two prime no b p = 53 and q = 59
    Now first part of public key : n  = p * q = 3127
    we also need a small exponent say e :
     BUT E MUST BE 
     An  integer.
     Not be a factor of Q(n).
     1 < e < Q(n) -- [Φ(n) is discussed below], 
     Let us now consider it to be equal to 3.
     Our Public Key is made of n and e
 
   
 * >> Generating Private Key: 

    We need to calculate Φ(n) :
    Such that Φ(n) = (P-1)(Q-1)     
      so,  Φ(n) = 3016
    Now calculate Private Key, d : 
    d = (k*Φ(n) + 1) / e for some integer k
    For k = 2, value of d is 2011.


 * 
   Convert letters to numbers : H  = 8 and I = 9
    Thus Encrypted Data c = (89e)mod n 
   Thus our Encrypted Data comes out to be 1394
   Now we will decrypt 1394 : 
    Decrypted Data = (cd)mod n
   Thus our Encrypted Data comes out to be 89
   8 = H and I = 9 i.e. "HI".

 */


import java.io.*;
import java.math.*;
import java.util.*;

public class rsaAlgorithm{
    public static double gcd(double a , double h){
        double temp ;
        while(true){
            temp = a % h;
            if(temp == 0)
            return h;
            a = h;
            h = temp;
        }
    }
    public static void main(String[] args){
        double p = 11;
        double q = 17;

        double n = p * q;

        double e = 2 ;
        double phi = (p-1)*(q -1);
        while (e < phi){
            if( gcd ( e , phi ) == 1)
            break;
            else 
                 e++;

        }
        int k = 2 ;
        double  d = (1+(k*phi))/e;
        double msg = 12;
        System.out.println("Message data = " + msg);

        double c = Math.pow(msg,e);
        c = c % n ;
        System.out.println("Encrypted data = " + c);

        double m = Math.pow( c , d);
        m = m % n;
        System.out.println("Original Message Sent = " +m);
    }


}

































