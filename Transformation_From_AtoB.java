import java.util.*;
public class Transformation_From_AtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();
        List<Long> seq = new ArrayList<>();
        seq.add(b);
        while (b > a) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b = (b - 1) / 10;
            } else {
                break;
            }
            seq.add(b);
        }
        if (b == a) {
            System.out.println("YES");
            Collections.reverse(seq);
            System.out.println(seq.size());
            for (long num : seq)
                System.out.print(num + " ");
            System.out.println();
        } else {
            System.out.println("NO");
        }
    }
}
