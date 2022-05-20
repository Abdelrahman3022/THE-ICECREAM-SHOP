package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {

    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
        this(0, 0, 0);
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        setBallPrice(ballPrice);
        setRocketPrice(rocketPrice);
        setMagnumStandardPrice(magnumStandardPrice);
    }


    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {

        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType type) {
        if (type.equals(Magnum.MagnumType.ALPINENUTS)) {
            return magnumStandardPrice * 1.5;
        } else if (type.equals(Magnum.MagnumType.BLACKCHOCOLATE)) {
            return magnumStandardPrice * 1.2;
        } else if (type.equals(Magnum.MagnumType.MILKCHOCOLATE)) {
            return magnumStandardPrice * 1.3;
        } else if (type.equals(Magnum.MagnumType.ROMANTICSTRAWBERRIES)) {
            return magnumStandardPrice * 1.4;
        } else if (type.equals(Magnum.MagnumType.WHITECHOCOLATE)) {
            return magnumStandardPrice * 1.2;
        } else {
            return magnumStandardPrice;
        }
    }

}