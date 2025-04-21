package de.cas_ual_ty.ydm.sleeve;

import net.minecraft.item.Item;

public class DefaultSleevesItem extends Item
{
    public final CardBackType sleeves;
    
    public DefaultSleevesItem(Properties properties, CardBackType sleeves)
    {
        super(properties);
        this.sleeves = sleeves;
    }
}
