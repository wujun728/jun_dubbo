package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateTest {
    public static void main(String[] args) {
       /* Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString=sdf.format(date);
        System.out.println(dateString);*/

        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString=sdf.format(date);
        char[] charArray=new char[]{
                '0' ,'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'
        };
        Random random=new Random();
        int[] indexArray=new int[]{
                random.nextInt(36),random.nextInt(36),random.nextInt(36),random.nextInt(36),random.nextInt(36)
        };
        char[] generateArray=new char[5];
        for(int i=0;i<indexArray.length;i++){
            generateArray[i]=charArray[indexArray[i]];
        }
        System.out.println(dateString+new String(generateArray));


    }
}
