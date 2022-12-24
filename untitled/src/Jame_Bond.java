import java.util.Scanner;

public class Jame_Bond {

    //Tổng số tiền ban đầu
    static double total = 10000.0;

    //Quay ra số ngẫu nhiên number
    static int number;

    //Chọn cách chơi
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chọn 1 để chơi số lần hữu hạn và 2 để chơi số lần vô hạn : ");
        int choose = sc.nextInt();
        if (choose ==1) {
            System.out.print("Nhập số lần chơi: ");
            int numberOfTurns = sc.nextInt();
            while (numberOfTurns-- > 0) {
                if (total < 0) {
                    System.out.println("Bạn thua");
                    break;
                }
                turn();
                Zero(10);
                All13To18(50);
                All19To36(140);
                System.out.println("Tổng tiền còn lại : " + total);
            }
        } else if (choose == 2) {
            while (true) {
                if (total < 0) {
                    System.out.println("You lose");
                    break;
                }
                turn();
                Zero(10);
                All13To18(50);
                All19To36(140);
                System.out.println("Tổng tiền còn lại: " + total);
            }
        }
    }

    //Quay lấy số ngẫu nhiên từ 0 đến 37
    public static void turn() {
        number = (int)(Math.random()*37);
    }

    //Đặt vào ô số 0
    public static void Zero(double money) {
        if (number == 0) {
            total += (money*35);
        } else {
            total -= money;
        }
    }

    //Dặt vào ô số 13-18
    public static void All13To18(double money) {
        if (number >= 13 && number <= 18) {
            total += (money*5);
        } else {
            total -= money;
        }
    }

    //Đặt vào ô số 19-36
    public static void All19To36(double money) {
        if (number >= 19 && number <= 36) {
            total += (money*2);
        } else {
            total -= money;
        }
    }
}
