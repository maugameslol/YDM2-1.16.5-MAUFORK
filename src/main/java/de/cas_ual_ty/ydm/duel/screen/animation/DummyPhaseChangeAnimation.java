package de.cas_ual_ty.ydm.duel.screen.animation;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.cas_ual_ty.ydm.YdmSoundEvents;
import de.cas_ual_ty.ydm.clientutil.ClientProxy;
import net.minecraft.util.SoundEvent;

public class DummyPhaseChangeAnimation extends Animation
{
	// TODO: Remove once PhaseChangeAnimation looks the way I want it to
	boolean turnPlayer;
	
	public DummyPhaseChangeAnimation(boolean turnPlayer)
    {
        super(ClientProxy.announcementAnimationLength);
        this.turnPlayer = turnPlayer;
    }
	
	@Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks)
    {
    }
	
	@Override
    public SoundEvent getSoundEvent()
    {
    	if(turnPlayer) 
    	{
    		return YdmSoundEvents.PHASE_CHANGE_PLAYER1.get();
    	}
    	else 
    	{
    		return YdmSoundEvents.PHASE_CHANGE_PLAYER2.get();
    	}
    }
}
