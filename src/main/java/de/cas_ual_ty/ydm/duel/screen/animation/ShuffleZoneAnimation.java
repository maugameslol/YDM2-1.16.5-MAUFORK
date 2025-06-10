package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YdmSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;

public class ShuffleZoneAnimation extends TextAnimation 
{
	
	public ShuffleZoneAnimation(ITextComponent message, float centerPosX, float centerPosY) 
	{
		super(message, centerPosX, centerPosY);
	}
	
	@Override
	public void tick() 
	{
		super.tick();
		if(tickTime == 0 && getSoundEvent() != null) 
        {
    		Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(getSoundEvent(), 1.0F, 0.25F));
    	}
		
		//I really hope this doesn't break anything
		if(tickTime == maxTickTime / 2 && getSoundEvent() != null) 
        {
    		Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(getSoundEvent(), 1.0F, 0.25F));
    	}
		
		if(tickTime == maxTickTime && getSoundEvent() != null) 
        {
    		Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(getSoundEvent(), 1.0F, 0.25F));
    	}
	}
	
	@Override
    public SoundEvent getSoundEvent()
    {
    	return YdmSoundEvents.CARD_SHUFFLE.get();
    }
}
