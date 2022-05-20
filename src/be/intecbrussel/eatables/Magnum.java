package be.intecbrussel.eatables;

public class Magnum implements Eatable{
    private MagnumType type;

    public Magnum() {
        this(MagnumType.valueOf(""));
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }


    @Override
    public void eat() {

        System.out.println(getType() + " (Magnum)");


    }

    public MagnumType getType() {
        return type;
    }

    public enum MagnumType {

        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES;


    }
}
