package de.cas_ual_ty.ydm.duel.screen.animation;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.cas_ual_ty.ydm.YdmSoundEvents;
import de.cas_ual_ty.ydm.clientutil.ClientProxy;
import net.minecraft.util.SoundEvent;

public class DuelStartAnimation extends Animation
{
	// TODO: Work on this
	public DuelStartAnimation() 
	{
		super(ClientProxy.announcementAnimationLength);
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) 
	{
		// TODO: Make this look nice
	}
	
	@Override
    public SoundEvent getSoundEvent()
    {
    	return YdmSoundEvents.DUEL_START.get();
    }
}
