package de.cas_ual_ty.ydm.card.properties;

public enum Archetype {

	DUMMY("Dummy");
    
    public final String name;
    
    Archetype(String name)
    {
        this.name = name;
    }
    
    public static final Archetype[] VALUES = Archetype.values();
    
    public static Archetype fromString(String s)
    {
        for(Archetype archetype : Archetype.VALUES)
        {
            if(archetype.name.equals(s))
            {
                return archetype;
            }
        }
        
        return null;
    }
}
