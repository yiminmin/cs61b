package hw0;

public class DrawingTriangle {
    public static void drawATriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        drawATriangle(5);
    }
}
