package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public interface IceCreamSeller extends Profitable{
    Cone orderCone(Cone.Flavor[] balls) throws NoMorelceCreamException;

    IceRocket orderIceRocket() throws NoMorelceCreamException;

    Magnum orderMagnum(Magnum.MagnumType type) throws NoMorelceCreamException;

}