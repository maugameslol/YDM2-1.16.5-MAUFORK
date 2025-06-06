package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class EffectContinueAnimation extends StaticSymbolFadeOutAnimation
{
	public EffectContinueAnimation(float centerPosX, float centerPosY, int size, int endSize)
    {
        super(centerPosX, centerPosY, size, endSize);
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/effect_continue.png");
    }

    @Override
    public SoundEvent getSoundEvent() 
    {
    	return YdmSoundEvents.EFFECT_CONTINUE.get();
    }
}