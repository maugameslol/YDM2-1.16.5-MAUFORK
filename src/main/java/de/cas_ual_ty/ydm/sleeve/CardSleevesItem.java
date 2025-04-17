package de.cas_ual_ty.ydm.sleeve;

import net.minecraft.item.Item;

public class CardSleevesItem extends Item
{
    public final CardSleevesType sleeves;
    
    public CardSleevesItem(Properties properties, CardSleevesType sleeves)
    {
        super(properties);
        this.sleeves = sleeves;
    }
}
