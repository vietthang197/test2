import java.util.List;

class Chicken{

}

interface HenHouse {
    List<Chicken> getChickens();
}
public class ChickenSong {
    public static void main(String[] args) {
        HenHouse house = new HenHouse() {
            @Override
            public List<Chicken> getChickens() {
                return null;
            }
        };
        Chicken chicken = house.getChickens().get(0);
        for (int i = 0; i < house.getChickens().size(); chicken = house.getChickens().get(i++)) {
            System.out.println("Cluck");
        }
    }

}
