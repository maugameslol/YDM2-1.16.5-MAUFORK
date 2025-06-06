package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class DestroyTokenAnimation extends StaticSymbolFadeOutAnimation
{
	public DestroyTokenAnimation(float centerPosX, float centerPosY, int size, int endSize)
    {
        super(centerPosX, centerPosY, size, endSize);
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/default_destroy_spark.png");
    }
    
    @Override
    public SoundEvent getSoundEvent() 
    {
    	return YdmSoundEvents.TOKEN_REMOVE.get();
    }
}