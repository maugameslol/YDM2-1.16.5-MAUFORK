package de.cas_ual_ty.ydm.card;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmDatabase;
import de.cas_ual_ty.ydm.rarity.Rarities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CardItem extends Item
{
    public CardItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public void appendHoverText(ItemStack itemStack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        CardHolder holder = getCardHolder(itemStack);
        tooltip.clear();
        if(Screen.hasShiftDown()) 
    	{
        	holder.addTooltipName(tooltip);
    		holder.addShiftInfo(tooltip);
    	}
        
        else 
        {
        	holder.addInformation(tooltip);
        	tooltip.add(StringTextComponent.EMPTY);
        	tooltip.add(new TranslationTextComponent("info." + YDM.MOD_ID + ".hold_shift_for_details").withStyle(Style.EMPTY.applyFormat(TextFormatting.GRAY)));
        }
    }
    
    @Override
    public ITextComponent getName(ItemStack itemStack)
    {
        CardHolder holder = getCardHolder(itemStack);
        return new StringTextComponent(holder.getCard().getName());
    }
    
    @Override
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pUsedHand)
    {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        CardHolder cardHolder = getCardHolder(itemStack);
        if(cardHolder != null && pPlayer.level.isClientSide)
        {
            YDM.proxy.openCardInspectScreen(cardHolder);
            return ActionResult.success(itemStack);
        }
        
        return super.use(pLevel, pPlayer, pUsedHand);
    }
    
    public CardHolder getCardHolder(ItemStack itemStack)
    {
        return new ItemStackCardHolder(itemStack);
    }
    
    public ItemStack createItemForCard(de.cas_ual_ty.ydm.card.properties.Properties card, byte imageIndex, String rarity, String code)
    {
        ItemStack itemStack = new ItemStack(this);
        getCardHolder(itemStack).override(new CardHolder(card, imageIndex, rarity, code));
        return itemStack;
    }
    
    public ItemStack createItemForCard(de.cas_ual_ty.ydm.card.properties.Properties card, byte imageIndex, String rarity)
    {
        ItemStack itemStack = new ItemStack(this);
        getCardHolder(itemStack).override(new CardHolder(card, imageIndex, rarity));
        return itemStack;
    }
    
    public ItemStack createItemForCard(de.cas_ual_ty.ydm.card.properties.Properties card)
    {
        return createItemForCard(card, (byte) 0, Rarities.CREATIVE.name);
    }
    
    public ItemStack createItemForCardHolder(CardHolder card)
    {
        ItemStack itemStack = new ItemStack(this);
        getCardHolder(itemStack).override(card);
        return itemStack;
    }
    
    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items)
    {
        if(!allowdedIn(group))
        {
            return;
        }
        
        YdmDatabase.forAllCardVariants((card, imageIndex) ->
        {
            items.add(createItemForCard(card, imageIndex, Rarities.CREATIVE.name));
        });
    }
    
    @Override
    public boolean shouldOverrideMultiplayerNbt()
    {
        return true;
    }
}
