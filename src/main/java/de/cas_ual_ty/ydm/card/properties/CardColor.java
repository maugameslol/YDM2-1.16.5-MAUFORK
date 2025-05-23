package de.cas_ual_ty.ydm.card.properties;

public enum CardColor {
	// TODO: Work on making this be used by cards.
	// Default Colors
	NORMAL_YELLOW("normal_yellow"), EFFECT_ORANGE("effect_orange"), RITUAL_LIGHT_BLUE("ritual_light_blue"), LINK_BLUE("link_blue"), FUSION_PURPLE("fusion_purple"), SYNCHRO_WHITE("synchro_white"), TOKEN_LIGHT_GRAY("token_light_gray"), XYZ_BLACK("xyz_black"),
	SPELL_GREEN("spell_green"), TRAP_MAGENTA("trap_magenta"), 
	SKILL_BLUE("skill_blue"),
	DARK_SYNCHRO_GRAY("dark_synchro_gray"),
	// Dye Colors
    BLACK("black"), BLUE("blue"), BROWN("brown"), CYAN("cyan"), GRAY("gray"), GREEN("green"), LIGHT_BLUE("light_blue"), LIGHT_GRAY("light_gray"), LIME("lime"), MAGENTA("magenta"), ORANGE("orange"), PINK("pink"), PURPLE("purple"), RED("red"), WHITE("white"), YELLOW("yellow"),
	// Blank
	BLANK ("blank");
	
	public final String name;
    
	CardColor(String name)
    {
        this.name = name;
    }
    
    public static final CardColor[] VALUES = CardColor.values();
    
    public static CardColor fromString(String s)
    {
        for(CardColor cardColor : CardColor.VALUES)
        {
            if(cardColor.name.equals(s))
            {
                return cardColor;
            }
        }
        
        return null;
    }
}
