package de.cas_ual_ty.ydm.deckbox;

import de.cas_ual_ty.ydm.YdmItems;
import de.cas_ual_ty.ydm.card.properties.Properties;
import de.cas_ual_ty.ydm.sleeve.DefaultSleevesItem;
import de.cas_ual_ty.ydm.sleeve.SleeveItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class DeckBoxContainer extends Container
{
    public ItemStack itemStack;
    public IItemHandler itemHandler;
    public Slot cardSleevesSlot;
    
    public DeckBoxContainer(ContainerType<?> type, int id, PlayerInventory playerInventory)
    {
        this(type, id, playerInventory, DeckBoxItem.getActiveDeckBox(playerInventory.player));
    }
    
    public DeckBoxContainer(ContainerType<?> type, int id, PlayerInventory playerInventory, ItemStack itemStack)
    {
        super(type, id);
        
        this.itemStack = itemStack;
        
        itemHandler = YdmItems.BLACK_DECK_BOX.getItemHandler(this.itemStack);
        
        final int mainDeckItemsPerRow = 20;
        final int extraDeckItemsPerRow = 10;
        final int sideDeckItemsPerRow = 10;
        
        // main deck
        for(int y = 0; y < DeckHolder.MAIN_DECK_SIZE / mainDeckItemsPerRow; ++y)
        {
            for(int x = 0; x < mainDeckItemsPerRow && x + y * mainDeckItemsPerRow < DeckHolder.MAIN_DECK_SIZE; ++x)
            {
                addSlot(new DeckBoxSlot(itemHandler, x + y * mainDeckItemsPerRow + DeckHolder.MAIN_DECK_INDEX_START, 8 + x * 18, 14 + y * 18));
            }
        }
        
        // extra deck
        for(int y = 0; y < DeckHolder.EXTRA_DECK_SIZE / extraDeckItemsPerRow; ++y)
        {
            for(int x = 0; x < extraDeckItemsPerRow && x + y * extraDeckItemsPerRow < DeckHolder.EXTRA_DECK_SIZE; ++x)
            {
                addSlot(new DeckBoxSlot(itemHandler, x + y * extraDeckItemsPerRow + DeckHolder.EXTRA_DECK_INDEX_START, 8 + x * 18, 122 + y * 18));
            }
        }
        
        // side deck
        for(int y = 0; y < DeckHolder.SIDE_DECK_SIZE / sideDeckItemsPerRow; ++y)
        {
            for(int x = 0; x < sideDeckItemsPerRow && x + y * sideDeckItemsPerRow < DeckHolder.SIDE_DECK_SIZE; ++x)
            {
                addSlot(new DeckBoxSlot(itemHandler, x + y * sideDeckItemsPerRow + DeckHolder.SIDE_DECK_INDEX_START, 188 + x * 18, 122 + y * 18));
            }
        }
        
		addSlot(cardSleevesSlot = new Slot(new Inventory(1), 0, 188, 190)
        {
            @Override
            public boolean mayPlace(ItemStack stack)
            {
                return (stack.getItem() instanceof DefaultSleevesItem) || (stack.getItem() instanceof SleeveItem);
            }
            
            @Override
            public int getMaxStackSize()
            {
                return 1;
            }
        });
        
        cardSleevesSlot.set(YdmItems.BLACK_DECK_BOX.getCardSleeves(itemStack));
        
        // player inventory
        for(int y = 0; y < 3; ++y)
        {
            for(int x = 0; x < 9; ++x)
            {
                addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 190 + y * 18));
            }
        }
        
        // player hot bar
        Slot s;
        for(int x = 0; x < 9; ++x)
        {
            s = new Slot(playerInventory, x, 8 + x * 18, 248);
            
            if(s.getItem() == this.itemStack)
            {
                s = new Slot(playerInventory, s.getSlotIndex(), s.x, s.y)
                {
                    @Override
                    public boolean mayPickup(PlayerEntity playerIn)
                    {
                        return false;
                    }
                };
            }
            
            addSlot(s);
        }
    }
    
    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index)
    {
        Slot slot = slots.get(index);
        ItemStack original = slot.getItem().copy();
        
        if(index < DeckHolder.TOTAL_DECK_SIZE || index == cardSleevesSlot.index)
        {
            //deck box slot or sleeves slot into inventory
            ItemStack itemStack = slot.getItem();
            
            if(moveItemStackTo(itemStack, cardSleevesSlot.index + 1, slots.size(), false))
            {
                slot.set(ItemStack.EMPTY);
                return ItemStack.EMPTY;
            }
            
            return ItemStack.EMPTY;
        }
        else if(original.getItem() == YdmItems.CARD)
        {
            //inventory to deck box
            
            Properties card = YdmItems.CARD.getCardHolder(original).getCard();
            boolean isExtraDeck = card.getIsInExtraDeck();
            
            int minTarget;
            int maxTarget;
            
            if(!isExtraDeck)
            {
                minTarget = DeckHolder.MAIN_DECK_INDEX_START;
                maxTarget = DeckHolder.MAIN_DECK_INDEX_END;
            }
            else
            {
                minTarget = DeckHolder.EXTRA_DECK_INDEX_START;
                maxTarget = DeckHolder.EXTRA_DECK_INDEX_END;
            }
            
            ItemStack itemStack = slot.getItem().split(1);
            
            if(moveItemStackTo(itemStack, minTarget, maxTarget, false))
            {
                return slot.getItem();
            }
            // side deck
            else if(moveItemStackTo(itemStack, DeckHolder.SIDE_DECK_INDEX_START, DeckHolder.SIDE_DECK_INDEX_END, false))
            {
                return slot.getItem();
            }
            
            slot.set(original);
        }
        else if((original.getItem() instanceof DefaultSleevesItem && !cardSleevesSlot.hasItem()) || (original.getItem() instanceof SleeveItem && !cardSleevesSlot.hasItem()))
        {
            cardSleevesSlot.set(slot.getItem().split(1));
            return slot.getItem();
        }
        
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean stillValid(PlayerEntity playerIn)
    {
        return true;
    }
    
    @Override
    public void removed(PlayerEntity playerIn)
    {
        // TODO can be removed when capabilities work again
        ((DeckBoxItem) itemStack.getItem()).saveItemHandlerToNBT(itemStack, itemHandler);
        ((DeckBoxItem) itemStack.getItem()).saveCardSleevesToNBT(itemStack, cardSleevesSlot.getItem());
        super.removed(playerIn);
    }
}
