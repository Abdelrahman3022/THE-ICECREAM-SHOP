package be.intecbrussel.sellers;
import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {
    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon() {
        this(new PriceList(), 0);
    }

    public IceCreamSalon(PriceList priceList, double totalProfit) {
        this.priceList = priceList;
        this.totalProfit = totalProfit;
    }


    @Override
    public double getProfit() {
        return totalProfit;
    }


    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        totalProfit = totalProfit + balls.length * priceList.getBallPrice();
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit = totalProfit + priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        totalProfit = totalProfit + priceList.getMagnumPrice(type);
        return new Magnum(type);
    }

    @Override
    public String toString() {
        return "{IceCreamSalon} ===> \"PriceList\":" + priceList + ", \"TotalProfit\":" + totalProfit;
    }
}