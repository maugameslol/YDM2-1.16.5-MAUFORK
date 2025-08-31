package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.CardPosition;
import de.cas_ual_ty.ydm.duel.playfield.ZoneOwner;

public class MoveStackAction extends MoveAction
{

	public MoveStackAction(ActionType actionType, byte zoneId, short cardIndex, byte destinationZoneId,
			CardPosition destinationCardPosition, ZoneOwner player) {
		super(actionType, zoneId, cardIndex, destinationZoneId, destinationCardPosition, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCard() {
		// TODO Auto-generated method stub
		
	}
	
}
