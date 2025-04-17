package de.cas_ual_ty.ydm.card.properties;

public enum SkillType 
{
	NORMAL_SPELL("Normal Spell"), FIELD_SPELL("Field Spell"), CONTINUOUS_SPELL("Continuous Spell"), NORMAL_TRAP("Normal Trap"), CONTINUOUS_TRAP("Continuous Trap"),
	LINK("Link");
    
    public final String name;
    
    SkillType(String name)
    {
        this.name = name;
    }
    
    public static final SkillType[] VALUES = SkillType.values();
    
    public static SkillType fromString(String s)
    {
        for(SkillType skillType : SkillType.VALUES)
        {
            if(skillType.name.equals(s))
            {
                return skillType;
            }
        }
        
        return null;
    }
}
