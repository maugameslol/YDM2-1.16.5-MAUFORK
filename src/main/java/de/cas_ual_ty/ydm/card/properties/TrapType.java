package de.cas_ual_ty.ydm.card.properties;

public enum TrapType
{
	// TODO: Make "Link" Traps... it sounds ridiculous, but I like the idea
    NORMAL("Normal"), CONTINUOUS("Continuous"), COUNTER("Counter"),
    LINK("Link");
    
    public final String name;
    
    TrapType(String name)
    {
        this.name = name;
    }
    
    public static final TrapType[] VALUES = TrapType.values();
    
    public static TrapType fromString(String s)
    {
        for(TrapType trapType : TrapType.VALUES)
        {
            if(trapType.name.equals(s))
            {
                return trapType;
            }
        }
        
        return null;
    }
}
