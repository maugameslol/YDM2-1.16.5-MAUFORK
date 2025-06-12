package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class PendulumSummonMiddleAnimation extends SpinningSymbolAnimation
{
	public PendulumSummonMiddleAnimation(float centerPosX, float centerPosY, int size, int endSize)
    {
        super(centerPosX, centerPosY, size, endSize);
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/special_summon_pendulum.png");
    }
    
    @Override
    public SoundEvent getSoundEvent()
    {
    	return YdmSoundEvents.SUMMON_PENDULUM_MIDDLE.get();
    }
}