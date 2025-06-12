package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YdmSoundEvents;
import de.cas_ual_ty.ydm.duel.playfield.CardPosition;
import de.cas_ual_ty.ydm.duel.playfield.DuelCard;
import de.cas_ual_ty.ydm.duel.playfield.ZoneOwner;
import de.cas_ual_ty.ydm.duel.screen.widget.ZoneWidget;
import net.minecraft.util.SoundEvent;

public class DrawCardAnimation extends MoveAnimation
{
	public DrawCardAnimation(ZoneOwner view, DuelCard duelCard, ZoneWidget sourceZone, ZoneWidget destinationZone, CardPosition sourcePosition, CardPosition destinationPosition) {
		super(view, duelCard, sourceZone, destinationZone, sourcePosition, destinationPosition);
	}
	
	@Override
    public SoundEvent getSoundEvent() 
    {
    	return YdmSoundEvents.CARD_DRAW.get();
    }
}
