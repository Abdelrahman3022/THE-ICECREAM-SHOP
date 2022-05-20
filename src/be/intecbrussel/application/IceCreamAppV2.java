package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import java.util.ArrayList;

public class IceCreamAppV2 {
    public static void main(String[] args) throws NoMorelceCreamException {

        PriceList priceList1 = new PriceList(4, 3, 8);
        Stock carStock = new Stock(2, 4, 5, 4);
        IceCreamSeller iceCreamSeller1 = new IceCreamCar(priceList1, carStock, 0);


        ArrayList<Eatable> ordersTotalList = new ArrayList<>();

        try {
//            Order Cone!!!

            ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY}));
            ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.VANILLA, Cone.Flavor.MOKKA}));
            ordersTotalList.add(iceCreamSeller1.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA}));

        } catch (NoMorelceCreamException e) {
            System.err.println(e.getMessage());
        }

        try {
//            Order Magnum!!!

            ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE));
            ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.ALPINENUTS));
            ordersTotalList.add(iceCreamSeller1.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES));

        } catch (NoMorelceCreamException e) {
            System.err.println(e.getMessage());
        }


        try {
//           Order IceRocket!!!

            ordersTotalList.add(iceCreamSeller1.orderIceRocket());
            ordersTotalList.add(iceCreamSeller1.orderIceRocket());

        } catch (NoMorelceCreamException e) {
            System.err.println(e.getMessage());
        }


        Eatable[] ordersTotal = ordersTotalList.toArray(new Eatable[0]);

        System.out.println("\nNumber of your current order(s):" + ordersTotal.length);

        // what did you eat?
        System.out.println("\nYour current orders are:");

        for (Eatable yourOrders : ordersTotal) {
            yourOrders.eat();

        }

        // How much is total profit of IceCreamCar?
        System.out.println("\nTotal profit is:" + (iceCreamSeller1.getProfit()) + " euro.");

    }
}