package HW6;


public class CreateGoods {
    Goods temp;
    public CreateGoods(){
        temp = new Goods();
        temp.name = "empty";
        temp.count = 0;
        temp.description = new StringBuilder("empty");
        temp.price = Double.valueOf(0);
    }

    public CreateGoods setName(String name){
        temp.name = name;
        return this;
    }

    public CreateGoods setСount(int count){
        temp.count = count;
        return this;
    }

    public CreateGoods setDescription(StringBuilder description){
        temp.description = description;
        return this;
    }

    public CreateGoods setPrice(Double price){
        temp.price = price;
        return this;
    }

    public Goods Create(){
        return temp;
    }
}