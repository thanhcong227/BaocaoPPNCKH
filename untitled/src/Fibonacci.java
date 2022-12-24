import java.util.Scanner;

public class Fibonacci {

    static double total = 10000.0;
    static int number;
    static int[] fibonacci = new int[100];

    //Chọn cách chơi
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chọn 1 để chơi số lần hữu hạn và 2 để chơi số lần vô hạn :");
        int choose = sc.nextInt();
        if (choose == 1) {
            System.out.print("Nhập số lần chơi: ");
            int numberOfTurns = sc.nextInt();
            System.out.print("Nhập số tiền cược: ");
            int k = sc.nextInt();
            double n = 1;
            fibonacci();
            while (numberOfTurns-- > 0) {
                if (total < 0) {
                    System.out.println("Bạn thua");
                    break;
                }
                turn();
                if (n > 0)
                    k = k - 2;
                else
                    k = k + 1;
                if (k < 1)
                    k = 1;
                n = AllOdd(fibonacci[k]);
                System.out.println("Số tiền đặt cược: " + fibonacci[k] +"   Số tiền thắng "+n +"   Số tiền còn lại: " + total);
            }
        } else if (choose == 2) {
            System.out.print("Nhập số tiền cược: ");
            int k = sc.nextInt();
            double n = 1;
            fibonacci();
            while (true) {
                if (total< 0) {
                    System.out.println("Bạn thua");
                    break;
                }
                turn();
                if (n > 0)
                    k = k - 2;
                else
                    k = k + 1;
                n = AllOdd(fibonacci[k]);
                System.out.println("Số tiền đặt cược: " + fibonacci[k] +"   Số tiền thắng "+n +"   Số tiền còn lại: " + total);
            }
        }
    }

    // Tính số fibonacci
    public static void fibonacci() {
        fibonacci = new int[100];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < 100; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
    }

    // Quay lấy số ngẫu nhiên từ 0 đến 37
    public static void turn() {
        number = (int)(Math.random()*37);
    }

    //Đặt cược vào ô lẻ với số tiền money và trả về số tiền thắng
    public static int AllOdd(int money) {
        if (number % 2 == 1) {
            total += money;
            return money;
        } else {
            total -= money;
            return -money;
        }
    }
}
