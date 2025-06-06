package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ExitGraveyardAnimation extends SpinningSymbolAnimation
{
    
    public ExitGraveyardAnimation(float centerPosX, float centerPosY, int size, int endSize)
    {
    	super(centerPosX, centerPosY, size, endSize);
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/graveyard_fire.png");
    }
    
    @Override
    public SoundEvent getSoundEvent()
    {
    	return YdmSoundEvents.GY_EXIT.get();
    }
}