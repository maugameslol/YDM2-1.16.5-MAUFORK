package de.cas_ual_ty.ydm.card.properties;

public enum MaterialType 
{
	NORMAL("Normal"), ENERGY("Energy"), MANA("Mana"), LINK("Link"), XYZ("Xyz");
    
    public final String name;
    
    MaterialType(String name)
    {
        this.name = name;
    }
    
    public static final MaterialType[] VALUES = MaterialType.values();
    
    public static MaterialType fromString(String s)
    {
        for(MaterialType materialType : MaterialType.VALUES)
        {
            if(materialType.name.equals(s))
            {
                return materialType;
            }
        }
        
        return null;
    }
}
