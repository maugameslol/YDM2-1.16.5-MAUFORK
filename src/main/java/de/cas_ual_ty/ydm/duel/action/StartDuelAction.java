package de.cas_ual_ty.ydm.duel.action;

import net.minecraft.network.PacketBuffer;

public class StartDuelAction extends Action 
{
	// This action shouldn't do anything right now
	
	public StartDuelAction(ActionType actionType, PacketBuffer buf) {
		super(actionType, buf);
	}

	@Override
	public void doAction() {
	}

	@Override
	public void undoAction() {
	}

	@Override
	public void redoAction() {
	}

}
