package de.cas_ual_ty.ydm.card.properties;

public enum PrimaryCardType
{
    MONSTER("Monster"), SPELL("Spell"), TRAP("Trap"), SKILL("Skill"),
    INFO("Info"), MATERIAL("Material");
	
    public final String name;
    
    PrimaryCardType(String name)
    {
        this.name = name;
    }
    
    public static final PrimaryCardType[] VALUES = PrimaryCardType.values();
    
    public static PrimaryCardType fromString(String s)
    {
        for(PrimaryCardType type : PrimaryCardType.VALUES)
        {
            if(type.name.equals(s))
            {
                return type;
            }
        }
        
        return null;
    }
}
