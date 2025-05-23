package de.cas_ual_ty.ydm.sleeve;

import de.cas_ual_ty.ydm.YdmDatabase;

public class DefaultSleeves {
	public static SleeveProperties CARD_BACK_PROPERTIES;
    public static SleeveProperties CARD_BACK_SLEEVE;
    
    public static SleeveProperties SLEEVES_BLACK_PROPERTIES;
    public static SleeveProperties SLEEVES_BLACK_SLEEVE;
    
    public static SleeveProperties SLEEVES_BLUE_PROPERTIES;
    public static SleeveProperties SLEEVES_BLUE_SLEEVE;
    
    public static SleeveProperties SLEEVES_BROWN_PROPERTIES;
    public static SleeveProperties SLEEVES_BROWN_SLEEVE;
    
    public static SleeveProperties SLEEVES_CYAN_PROPERTIES;
    public static SleeveProperties SLEEVES_CYAN_SLEEVE;
    
    public static SleeveProperties SLEEVES_GRAY_PROPERTIES;
    public static SleeveProperties SLEEVES_GRAY_SLEEVE;
    
    public static SleeveProperties SLEEVES_GREEN_PROPERTIES;
    public static SleeveProperties SLEEVES_GREEN_SLEEVE;
    
	public static void createAndRegisterEverything()
    {
		//TODO: Find a way to reuse the old CardBackType Values
		
		DefaultSleeves.CARD_BACK_PROPERTIES = new SleeveProperties();
		DefaultSleeves.CARD_BACK_PROPERTIES.isHardcoded = true;
		DefaultSleeves.CARD_BACK_PROPERTIES.name = "Card Back";
		DefaultSleeves.CARD_BACK_PROPERTIES.code = "card_back";
		DefaultSleeves.CARD_BACK_PROPERTIES.text = "The default card back.";
		DefaultSleeves.CARD_BACK_PROPERTIES.image = null;
        DefaultSleeves.CARD_BACK_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.CARD_BACK_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.CARD_BACK_PROPERTIES);
        
        DefaultSleeves.SLEEVES_BLACK_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_BLACK_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_BLACK_PROPERTIES.name = "Black Sleeves";
		DefaultSleeves.SLEEVES_BLACK_PROPERTIES.code = "sleeves_black";
		DefaultSleeves.SLEEVES_BLACK_PROPERTIES.text = "The default black colored sleeves.";
		DefaultSleeves.SLEEVES_BLACK_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_BLACK_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_BLACK_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_BLACK_PROPERTIES);
        
        DefaultSleeves.SLEEVES_BLUE_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_BLUE_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_BLUE_PROPERTIES.name = "Blue Sleeves";
		DefaultSleeves.SLEEVES_BLUE_PROPERTIES.code = "sleeves_blue";
		DefaultSleeves.SLEEVES_BLUE_PROPERTIES.text = "The default blue colored sleeves.";
		DefaultSleeves.SLEEVES_BLUE_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_BLUE_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_BLUE_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_BLUE_PROPERTIES);
        
        DefaultSleeves.SLEEVES_BROWN_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_BROWN_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_BROWN_PROPERTIES.name = "Brown Sleeves";
		DefaultSleeves.SLEEVES_BROWN_PROPERTIES.code = "sleeves_brown";
		DefaultSleeves.SLEEVES_BROWN_PROPERTIES.text = "The default brown colored sleeves.";
		DefaultSleeves.SLEEVES_BROWN_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_BROWN_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_BROWN_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_BROWN_PROPERTIES);
        
        DefaultSleeves.SLEEVES_CYAN_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_CYAN_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_CYAN_PROPERTIES.name = "Cyan Sleeves";
		DefaultSleeves.SLEEVES_CYAN_PROPERTIES.code = "sleeves_cyan";
		DefaultSleeves.SLEEVES_CYAN_PROPERTIES.text = "The default cyan colored sleeves.";
		DefaultSleeves.SLEEVES_CYAN_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_CYAN_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_CYAN_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_CYAN_PROPERTIES);
        
        DefaultSleeves.SLEEVES_GRAY_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_GRAY_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_GRAY_PROPERTIES.name = "Gray Sleeves";
		DefaultSleeves.SLEEVES_GRAY_PROPERTIES.code = "sleeves_gray";
		DefaultSleeves.SLEEVES_GRAY_PROPERTIES.text = "The default gray colored sleeves.";
		DefaultSleeves.SLEEVES_GRAY_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_GRAY_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_GRAY_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_GRAY_PROPERTIES);
        
        DefaultSleeves.SLEEVES_GREEN_PROPERTIES = new SleeveProperties();
		DefaultSleeves.SLEEVES_GREEN_PROPERTIES.isHardcoded = true;
		DefaultSleeves.SLEEVES_GREEN_PROPERTIES.name = "Green Sleeves";
		DefaultSleeves.SLEEVES_GREEN_PROPERTIES.code = "sleeves_green";
		DefaultSleeves.SLEEVES_GREEN_PROPERTIES.text = "The default green colored sleeves.";
		DefaultSleeves.SLEEVES_GREEN_PROPERTIES.image = null;
        DefaultSleeves.SLEEVES_GREEN_SLEEVE = DefaultSleeves.createDefaultSleeve(DefaultSleeves.SLEEVES_GREEN_PROPERTIES);
        YdmDatabase.SLEEVES_LIST.add(DefaultSleeves.SLEEVES_GREEN_PROPERTIES);
    }
	public static SleeveProperties createDefaultSleeve(SleeveProperties s)
    {
        return new SleeveProperties(s.name, s.code, s.text, null);
    }
}
