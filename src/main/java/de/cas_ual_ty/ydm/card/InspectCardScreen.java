package de.cas_ual_ty.ydm.card;

import net.minecraft.client.util.InputMappings; //import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.matrix.MatrixStack; //import com.mojang.blaze3d.vertex.PoseStack;
import de.cas_ual_ty.ydm.clientutil.CardRenderUtil;
import net.minecraft.client.gui.screen.Screen; //import net.minecraft.client.gui.screens.Screen;
//import net.minecraft.util.text.IFormattableTextComponent; //import net.minecraft.network.chat.Component;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class InspectCardScreen extends Screen
{
    public final CardHolder cardHolder;

    public InspectCardScreen(ITextComponent pTitle, CardHolder cardHolder)
    {
        super(pTitle);
        this.cardHolder = cardHolder;
    }
    
    public InspectCardScreen(CardHolder cardHolder)
    {
        this(StringTextComponent.EMPTY, cardHolder);
    }

	@Override
    public void render(MatrixStack ms, int pMouseX, int pMouseY, float pPartialTick)
    {
        if(minecraft != null)
        {
            renderBackground(ms);
        }

        CardRenderUtil.renderInfoCardWithRarity(ms, pMouseX, pMouseY, width / 2, height / 2, 128, 128, cardHolder);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers)
    {
    	InputMappings.Input mouseKey = InputMappings.getKey(pKeyCode, pScanCode);

        if(minecraft.options.keyInventory.isActiveAndMatches(mouseKey))
        {
            onClose();
            return true;
        }

        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
}
