package de.cas_ual_ty.ydm.sleeve;

import de.cas_ual_ty.ydm.YDM;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public enum DefaultSleevesType
{
	// TODO: Put sleeves in the database, make them dynamically generated like sets and cards, so that we don't have this mess anymore.
    // Default Card Back
	CARD_BACK("card_back"), 
	// Metals and Minerals
    BRONZE("bronze"), SILVER("silver"), GOLD("gold"), PLATINUM("platinum"), RUBY("ruby"), DIAMOND("diamond"), EMERALD("emerald"), COPPER("copper"), AMETHYST("amethyst"), SAPPHIRE("sapphire"), NETHERITE("netherite"),
    // Dye Colors
    BLACK("black"), BLUE("blue"), BROWN("brown"), CYAN("cyan"), GRAY("gray"), GREEN("green"), LIGHT_BLUE("light_blue"), LIGHT_GRAY("light_gray"), LIME("lime"), MAGENTA("magenta"), ORANGE("orange"), PINK("pink"), PURPLE("purple"), RED("red"), WHITE("white"), YELLOW("yellow");
    
    public static final DefaultSleevesType[] VALUES = DefaultSleevesType.values();
    
    public static DefaultSleevesType getFromIndex(int index)
    {
        return DefaultSleevesType.VALUES[index];
    }
    
    static
    {
        int index = 0;
        for(DefaultSleevesType duelPhase : DefaultSleevesType.VALUES)
        {
            duelPhase.index = index++;
        }
    }
    
    public final String name;
    private int index;
    
    DefaultSleevesType(String name)
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
