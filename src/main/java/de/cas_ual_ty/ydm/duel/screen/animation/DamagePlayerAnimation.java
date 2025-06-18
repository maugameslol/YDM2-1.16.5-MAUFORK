package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class DamagePlayerAnimation extends StaticSymbolFadeOutAnimation
{
	boolean isOpponent;
    public DamagePlayerAnimation(float centerPosX, float centerPosY, int size, int endSize, boolean isOpponent)
    {
    	super(centerPosX, centerPosY, size, endSize);
    	this.isOpponent = isOpponent;
    }
    
    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/direct_damage.png");
    }
    
    @Override
    public SoundEvent getSoundEvent()
    {
    	if(isOpponent) 
    	{
    		return YdmSoundEvents.DIRECT_ATTACK_PLAYER2.get();
    	}
    	else 
    	{
    		return YdmSoundEvents.DIRECT_ATTACK_PLAYER1.get();
    	}
    }
}
