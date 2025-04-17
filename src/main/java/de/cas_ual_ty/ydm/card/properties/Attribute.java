package de.cas_ual_ty.ydm.card.properties;

public enum Attribute
{
    DARK("DARK"), DIVINE("DIVINE"), EARTH("EARTH"), FIRE("FIRE"), LIGHT("LIGHT"), WATER("WATER"), WIND("WIND"),
    SPELL("SPELL"), TRAP("TRAP"), SKILL("SKILL"),
    METAL("METAL"), THUNDER("THUNDER"), WOOD("WOOD"),
    INFO("INFO"), MATERIAL("MATERIAL");
    
    public final String name;
    
    Attribute(String name)
    {
        this.name = name;
    }
    
    public static final Attribute[] VALUES = Attribute.values();
    
    public static Attribute fromString(String s)
    {
        for(Attribute attribute : Attribute.VALUES)
        {
            if(attribute.name.equals(s))
            {
                return attribute;
            }
        }
        
        return null;
    }
}
