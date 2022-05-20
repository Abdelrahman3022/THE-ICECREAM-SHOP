package be.intecbrussel.eatables;
import java.util.Arrays;

public class Cone implements Eatable{
    private Flavor[] balls;

    public Cone() {
        this(Flavor.values());
    }

    public Cone(Flavor[] balls) {

        this.balls = balls;


    }


    @Override
    public void eat() {
        String eatCone;
        for (Flavor f : balls) {
            eatCone = f.name();
            System.out.print(eatCone + ", ");
        }

        System.out.println("(" + Arrays.stream(balls).count() + " ball(s) Cone)");


    }


    public enum Flavor {

        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;


    }
}