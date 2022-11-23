package HW6;


public class Goods {
    int count;
    String name;
    Double price;
    StringBuilder description;
    
    public void print(){
        System.out.println(
                String.format(
                        "%d %s %f %s",
                        count,
                        name,
                        price,
                        description));
    }

}