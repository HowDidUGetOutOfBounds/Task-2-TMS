package lesson13;


//Post to github
interface SeasonPrice {
    double calcPrice(double discount, double price);
}

class Phone {
    double price;
    String name;

    public Phone(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getSeasonPrice(double discount, SeasonPrice func) {
        return func.calcPrice(discount, price);
    }

}

public class LambdaApp {
    public static void main(String[] args) {

        Phone phone = new Phone(1700.0, "NewSung S20");
        double winterPrice = phone.getSeasonPrice(10, (discount, currPrice) -> {
            return currPrice - discount * 5;
        });

        double summerPrice = phone.getSeasonPrice(10, (discount, currPrice) -> {
            return currPrice * (1 - (discount/100));
        });

        System.out.println(winterPrice);
        System.out.println(summerPrice);

    }

}