package de.cas_ual_ty.ydm.sleeve;

import net.minecraft.item.Item;

public class DefaultSleevesItem extends Item
{
    public final DefaultSleevesType sleeves;
    
    public DefaultSleevesItem(Properties properties, DefaultSleevesType sleeves)
    {
        super(properties);
        this.sleeves = sleeves;
    }
}
