package de.cas_ual_ty.ydm.card.properties;

public enum Character 
{
	ANTAGONIST("Antagonist"), GENERIC("Generic"), HERO("Hero"), PROTAGONIST("Protagonist"), VILLAIN("Villain"),
	CLASS("Class"), FIGHTER("Fighter"), THIEF("Thief"), MAGE("Mage");
	
	public final String name;
    
    Character(String name)
    {
        this.name = name;
    }
    
    public static final Character[] VALUES = Character.values();
    
    public static Character fromString(String s)
    {
        for(Character character : Character.VALUES)
        {
            if(character.name.equals(s))
            {
                return character;
            }
        }
        
        return null;
    }
}
