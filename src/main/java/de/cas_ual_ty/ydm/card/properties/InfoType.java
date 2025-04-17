package de.cas_ual_ty.ydm.card.properties;

public enum InfoType 
{
	NORMAL("Normal"), RULE("Rule"), RULES("Rules"), TIP("Tip"), STRATEGY("Strategy"), FAQ("FAQ"), FORMAT("Format");
	
	public final String name;
    
    InfoType(String name)
    {
        this.name = name;
    }
    
    public static final InfoType[] VALUES = InfoType.values();
    
    public static InfoType fromString(String s)
    {
        for(InfoType infoType : InfoType.VALUES)
        {
            if(infoType.name.equals(s))
            {
                return infoType;
            }
        }
        
        return null;
    }
}
