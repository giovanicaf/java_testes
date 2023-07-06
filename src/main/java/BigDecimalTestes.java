import java.math.BigDecimal;

public class BigDecimalTestes {



    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("123.45");
        long l1;
        l1 = b1.multiply(new BigDecimal("100")).longValue();

        new BigDecimal("123.45").multiply(new BigDecimal("100")).longValue();


        long times100 = b1.multiply(new BigDecimal("100")).longValue();
        System.out.println(times100);

    }

}
