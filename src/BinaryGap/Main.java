package BinaryGap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Vui lòng nhập số nguyên bất kỳ: ");
        int n = sc.nextInt();

        System.out.println("Max Binary Gap: " + solution(n));
    }

    public static String integerToBinary(int n){ // hàm chuyển đổi số nguyên sang 1 chuỗi nhị phân
        StringBuilder binaryString = new StringBuilder();
        while(n != 0){
            binaryString.append(n % 2);

            n/=2;
        }

        return binaryString.reverse().toString();
    }

    public static int solution(int n){ // đáp án
        int maxCount = 0;
        String binaryString = integerToBinary(n);

        System.out.println("Chuỗi nhị phân: " + binaryString);
        for(int i=0; i < binaryString.length(); i++){
            int count = 0;

            if(binaryString.charAt(i) == '1') // tối ưu không cần kiểm tra code bên dưới nhiều lần
                continue;

            while(i < binaryString.length() && binaryString.charAt(i) != '1'){
                count++;
                i++;
            }

            if(maxCount < count && i != binaryString.length())
                maxCount = count;
        }

        return maxCount;
    }
}
