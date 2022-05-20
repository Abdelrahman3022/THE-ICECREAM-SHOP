package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMorelceCreamException;
import be.intecbrussel.sellers.PriceList;

import java.util.ArrayList;

public class IceCreamApp {
    public static void main(String[] args) throws NoMorelceCreamException {


        PriceList priceList1 = new PriceList(6, 5, 10);
        IceCreamSeller iceCreamSeller1 = new IceCreamSalon(priceList1, 0);

        ArrayList<Eatable> ordersTotalList = new ArrayList<>();


        ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY}));
        ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.VANILLA, Cone.Flavor.MOKKA}));
        ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA}));
        ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE));
        ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.ALPINENUTS));
        ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES));
        ordersTotalList.add(iceCreamSeller1.orderIceRocket());
        ordersTotalList.add(iceCreamSeller1.orderIceRocket());

        Eatable[] ordersTotal = ordersTotalList.toArray(new Eatable[0]);


        // what did you eat?
        System.out.println("Your orders are:");

        for (Eatable yourOrders : ordersTotal) {
            yourOrders.eat();

        }

        // How much is total profit of IceCreamSalon?
        System.out.println("\nTotal profit is:" + (iceCreamSeller1.getProfit()) + " euro.");

    }
}