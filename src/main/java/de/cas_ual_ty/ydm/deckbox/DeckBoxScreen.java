package de.cas_ual_ty.ydm.deckbox;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.clientutil.ScreenUtil;
import de.cas_ual_ty.ydm.clientutil.YdmBlitUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DeckBoxScreen extends ContainerScreen<DeckBoxContainer>
{
	//TODO: Add a scroll bar to make this UI smaller.
	/** Amount scrolled in Creative mode inventory (0 = top, 1 = bottom) */
	//public float scrollOffs;
	/** True if the scrollbar is being dragged */
	//public boolean scrolling;
	
    public static final ResourceLocation DECK_BOX_GUI_TEXTURE = new ResourceLocation(YDM.MOD_ID, "textures/gui/deck_box.png");
    
    public DeckBoxScreen(DeckBoxContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }
    
    @Override
    public void init(Minecraft mc, int width, int height)
    {
        super.init(mc, width, height);
    }
    
    @Override
    protected void init()
    {
        imageWidth = 300; //original is 284
        imageHeight = 242; //original is 250
        super.init();
    }
    
    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks)
    {
    	leftPos = 104; //Previous version used 104. Adjust as needed, as people have been saying it gets cut off.
        renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        renderTooltip(ms, mouseX, mouseY);
    }
    
    @Override
    protected void renderLabels(MatrixStack ms, int mouseX, int mouseY)
    {
        Slot s;
        int amount;
        
        // main deck
        
        amount = 0;
        for(int i = DeckHolder.MAIN_DECK_INDEX_START; i < DeckHolder.MAIN_DECK_INDEX_END; ++i)
        {
            s = getMenu().getSlot(i);
            
            if(s != null && s.hasItem())
            {
                amount++;
            }
        }
        
        //drawString
        font.draw(ms, new TranslationTextComponent("container.ydm.deck_box.main").append(" " + amount + "/" + DeckHolder.MAIN_DECK_SIZE), 8F, 3F, 0x404040); //original is 6F
        
        // extra deck
        
        amount = 0;
        for(int i = DeckHolder.EXTRA_DECK_INDEX_START; i < DeckHolder.EXTRA_DECK_INDEX_END; ++i)
        {
            s = getMenu().getSlot(i);
            
            if(s != null && s.hasItem())
            {
                amount++;
            }
        }
        
        //drawString
        font.draw(ms, new TranslationTextComponent("container.ydm.deck_box.extra").append(" " + amount + "/" + DeckHolder.EXTRA_DECK_SIZE), 8F, 83F, 0x404040); //original is 92F
        
        // side deck
        
        amount = 0;
        for(int i = DeckHolder.SIDE_DECK_INDEX_START; i < DeckHolder.SIDE_DECK_INDEX_END; ++i)
        {
            s = getMenu().getSlot(i);
            
            if(s != null && s.hasItem())
            {
                amount++;
            }
        }
        
        //drawString
        font.draw(ms, new TranslationTextComponent("container.ydm.deck_box.side").append(" " + amount + "/" + DeckHolder.SIDE_DECK_SIZE), 116F, 83F, 0x404040); //original is 124F
        
        font.draw(ms, new TranslationTextComponent("container.ydm.deck_box.sleeves"), 186F, (float) (imageHeight - 96 + 2), 0x404040);
        
        font.draw(ms, inventory.getDisplayName(), 8F, (float) (imageHeight - 96 + 2), 0x404040);
    }
    
    @Override
    protected void renderBg(MatrixStack ms, float partialTicks, int mouseX, int mouseY)
    {
        ScreenUtil.white();
        minecraft.getTextureManager().bind(DeckBoxScreen.DECK_BOX_GUI_TEXTURE);
		YdmBlitUtil.blit(ms, leftPos, topPos, imageWidth, imageHeight, 0, 0, imageWidth, imageHeight, 512, 256);
    }
}
