package de.cas_ual_ty.ydm.card.properties;

public enum Attribute
{
	// Original Attributes
    DARK("DARK"), DIVINE("DIVINE"), EARTH("EARTH"), FIRE("FIRE"), LIGHT("LIGHT"), WATER("WATER"), WIND("WIND"),
    // Non-Monster, Card Attributes
    SPELL("SPELL"), TRAP("TRAP"), SKILL("SKILL"),
    // VG Attributes and Alignments
    THUNDER("THUNDER"), WOOD("WOOD"), DREAMS("DREAMS"), FIEND("FIEND"),
    // Printed, but unused
    LAUGH("LAUGH"),
    // Custom Attributes
    METAL("METAL"), NEUTRAL("NEUTRAL"), CHAOS("CHAOS"), RAINBOW("RAINBOW"), 
    // Custom Non-Monster, Card Attributes
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
