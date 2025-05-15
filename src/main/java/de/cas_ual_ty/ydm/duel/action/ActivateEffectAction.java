package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.DuelCard;
import de.cas_ual_ty.ydm.duel.playfield.Zone;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ActivateEffectAction extends SingleZoneAction implements IAnnouncedAction {
	//TODO: Make an activate effect action with a simple animation similar to DuelingBook
	public DuelCard card;
	
	public ActivateEffectAction(ActionType actionType, byte sourceZoneId, DuelCard card)
    {
        super(actionType, sourceZoneId);
        this.card = card;
    }
    
    public ActivateEffectAction(ActionType actionType, Zone sourceZone, DuelCard card)
    {
        this(actionType, sourceZone.index, card);
    }
	
	public ActivateEffectAction(ActionType actionType, PacketBuffer buf)
    {
        super(actionType, buf);
    }
	
	@Override
    public void doAction()
    {
    }
	
	@Override
    public String getAnnouncementLocalKey()
    {
        return actionType.getLocalKey();
    }
    
	@Override
    public IFormattableTextComponent getAnnouncement(ITextComponent playerName)
    {
        return new TranslationTextComponent(getAnnouncementLocalKey()).append(": ").append(card.getCardHolder().getCard().getName());
    }
}
