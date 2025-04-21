package de.cas_ual_ty.ydm.sleeve;

import de.cas_ual_ty.ydm.YDM;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public enum CardBackType
{
    // Default Card Back
	CARD_BACK("card_back"), 
    // Dye Colors
    BLACK("black"), BLUE("blue"), BROWN("brown"), CYAN("cyan"), GRAY("gray"), GREEN("green"), LIGHT_BLUE("light_blue"), LIGHT_GRAY("light_gray"), LIME("lime"), MAGENTA("magenta"), ORANGE("orange"), PINK("pink"), PURPLE("purple"), RED("red"), WHITE("white"), YELLOW("yellow"),
    // Vanilla Materials
    COPPER("copper"), IRON("iron"), GOLD("gold"), NETHERITE("netherite"),
    QUARTZ("quartz"), AMETHYST("amethyst"), DIAMOND("diamond"), EMERALD("emerald"),
    // Modded Materials
    TIN("tin"), SILVER("silver"), LEAD("lead"), PLATINUM("platinum"),
    BRASS("brass"), BRONZE("bronze"), STEEL("steel"),
    RUBY("ruby"), SAPPHIRE("sapphire");
	
    public static final CardBackType[] VALUES = CardBackType.values();
    
    public static CardBackType getFromIndex(int index)
    {
        return CardBackType.VALUES[index];
    }
    
    //TODO: Make it so that both these sleeves and the new ones can be used in Duels
    static
    {
        int index = 0;
        for(CardBackType duelPhase : CardBackType.VALUES)
        {
            duelPhase.index = index++;
        }
    }
    
    public final String name;
    private int index;
    
    CardBackType(String name)
    {
        this.name = name;
    }
    
    public boolean isCardBack()
    {
        return this == CARD_BACK;
    }
    
    public ResourceLocation getMainRL(int size)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + size + "/" + getResourceName() + ".png");
    }
    
    public ResourceLocation getItemModelRL(int size)
    {
        if(isCardBack())
        {
            return null;
        }
        else
        {
            return new ResourceLocation(YDM.MOD_ID, getResourceName() + "_" + size);
        }
    }
    
    public String getResourceName()
    {
        if(isCardBack())
        {
            return name;
        }
        else
        {
            return "sleeves_" + name;
        }
    }
    
    public Item getItem()
    {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(YDM.MOD_ID, getResourceName()));
    }
    
    public int getIndex()
    {
        return index;
    }
}
