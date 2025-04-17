package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import net.minecraft.util.ResourceLocation;

public class DefensePositionAnimation extends ExpandingSymbolAnimation
{
    
    public DefensePositionAnimation(float centerPosX, float centerPosY, int size, int endSize)
    {
    	super(centerPosX, centerPosY, size, endSize);
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/defense_position.png");
    }
}
