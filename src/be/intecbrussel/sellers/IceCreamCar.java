package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    public PriceList priceList;
    public Stock stock;
    public double profit;

    public IceCreamCar() {
        this(new PriceList(), new Stock(), 0);
    }

    public IceCreamCar(PriceList priceList, Stock stock, double profit) {

        this.priceList = priceList;
        this.stock = stock;
        this.profit = profit;
    }


    @Override
    public Cone orderCone(Cone.Flavor[] balls) throws NoMorelceCreamException {

        if (stock.getBalls() > balls.length - 1 && stock.getCones() > 0) {
            stock.setBalls(stock.getBalls() - balls.length);
            stock.setCones(stock.getCones() - 1);

            return prepareCone(balls);

        } else if (stock.getCones() == 0 && stock.getBalls() < balls.length) {

            throw new NoMorelceCreamException("\"Just not enough {ball stock} and {cone stock} left for a new " + balls.length + "-ball Cone\"");

        } else if (stock.getCones() == 0) {

            throw new NoMorelceCreamException("\"Just not enough {cone stock} left for a new " + balls.length + "-ball Cone\"");

        } else {

            throw new NoMorelceCreamException("\"Just not enough {ball stock} left for a new " + balls.length + "-ball Cone\"");

        }
    }

    public Cone prepareCone(Cone.Flavor[] balls) {
        profit = profit + balls.length * priceList.getBallPrice();
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMorelceCreamException {

        if (stock.getIceRockets() > 0) {
            stock.setIceRockets(stock.getIceRockets() - 1);
            return prepareIceRocket();
        } else {
            throw new NoMorelceCreamException("\"Just not enough stock left for a new IceRocket\"");
        }
    }

    public IceRocket prepareIceRocket() {
        profit = profit + priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMorelceCreamException {

        if (stock.getMagni() > 0) {
            stock.setMagni(stock.getMagni() - 1);
            return prepareMagnum(type);
        } else {
            throw new NoMorelceCreamException("\"Just not enough stock left for a new magnum\"");
        }
    }

    public Magnum prepareMagnum(Magnum.MagnumType type) {
        profit = profit + priceList.getMagnumPrice(type);
        return new Magnum(type);
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
