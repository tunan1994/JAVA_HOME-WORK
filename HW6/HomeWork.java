package HW6;


public class HomeWork {
    public static void main(String[] args) {
        Goods FirstGood = new Goods();
        FirstGood = new CreateGoods()
                .setName("Мыло")
                .setDescription(new StringBuilder("Хозяйственное"))
                .setPrice(12.5)
                .setСount(1)
                .Create();

        FirstGood.print();
    }
}