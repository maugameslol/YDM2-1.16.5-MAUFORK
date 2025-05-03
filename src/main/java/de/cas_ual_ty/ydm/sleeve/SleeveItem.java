package de.cas_ual_ty.ydm.sleeve;

import java.util.List;

import de.cas_ual_ty.ydm.YdmDatabase;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;


public class SleeveItem extends Item
{
	//TODO: This is the Item class for the Custom Sleeves. I am trying to move them over to using the database system that sets and cards use.
    public SleeveItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public void appendHoverText(ItemStack itemStack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        SleeveProperties sleeve = getSleeveProperties(itemStack);
        tooltip.clear();
        sleeve.addItemInformation(tooltip);
    }
    
    @Override
    public ITextComponent getName(ItemStack itemStack)
    {
    	SleeveProperties sleeve = getSleeveProperties(itemStack);
        return new StringTextComponent(sleeve.name + " Sleeves");
    }
    
    public SleeveProperties getSleeveProperties(ItemStack itemStack)
    {
        String code = getNBT(itemStack).getString(JsonKeys.CODE);
        
        if(code.isEmpty())
        {
            return SleeveProperties.DUMMY;
        }
        
        SleeveProperties sleeve = YdmDatabase.SLEEVES_LIST.get(code);
        
        if(sleeve == null)
        {
        	sleeve = SleeveProperties.DUMMY;
        }
        
        return sleeve;
    }
    
    public void setSleeveProperties(ItemStack itemStack, SleeveProperties sleeve)
    {
        getNBT(itemStack).putString(JsonKeys.CODE, sleeve.code);
    }
    
    public CompoundNBT getNBT(ItemStack itemStack)
    {
        return itemStack.getOrCreateTag();
    }
    
    public ItemStack createItemForSleeve(SleeveProperties sleeve)
    {
        ItemStack itemStack = new ItemStack(this);
        setSleeveProperties(itemStack, sleeve);
        return itemStack;
    }
    
    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) 
    {
    	if(!allowdedIn(group))
        {
            return;
        }
        
        for(SleeveProperties sleeve : YdmDatabase.SLEEVES_LIST)
        {
        	if(sleeve.isIndependentAndItem()) 
        	{
        		items.add(createItemForSleeve(sleeve));
        	}
        }
	}
    
    @Override
    public boolean shouldOverrideMultiplayerNbt()
    {
        return true;
    }
}

