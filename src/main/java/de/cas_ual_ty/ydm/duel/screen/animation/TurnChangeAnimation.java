package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;

public class TurnChangeAnimation extends PhaseChangeAnimation 
{
	public TurnChangeAnimation(ITextComponent message, boolean turnPlayer, float centerPosX, float centerPosY, int size, int endSize) 
	{
		super(message, turnPlayer, centerPosX, centerPosY, size, endSize);
	}
	
	@Override
    public SoundEvent getSoundEvent()
    {
    	if(turnPlayer) 
    	{
    		return YdmSoundEvents.TURN_SWITCH_PLAYER1.get();
    	}
    	else 
    	{
    		return YdmSoundEvents.TURN_SWITCH_PLAYER2.get();
    	}
    }
}
