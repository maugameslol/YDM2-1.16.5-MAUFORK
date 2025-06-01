package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.DuelCard;
import de.cas_ual_ty.ydm.duel.playfield.Zone;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EffectContinueAction extends SingleCardAction implements IAnnouncedAction {
	// I have no clue if any of this is needed - but it seems to work
	public EffectContinueAction(ActionType actionType, byte sourceZoneId, short sourceCardIndex)
    {
        super(actionType, sourceZoneId, sourceCardIndex);
    }
    
    public EffectContinueAction(ActionType actionType, Zone sourceZone, DuelCard sourceCard)
    {
        this(actionType, sourceZone.index, sourceZone.getCardIndexShort(sourceCard));
    }
	
	public EffectContinueAction(ActionType actionType, PacketBuffer buf)
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
    public Zone getFieldAnnouncementZone()
    {
        return sourceZone;
    }
    
	@Override
    public IFormattableTextComponent getAnnouncement(ITextComponent playerName)
    {
        return new TranslationTextComponent(getAnnouncementLocalKey()).append(" [").append(getFieldAnnouncementZone().getCard(sourceCardIndex).cardHolder.getCard().getName()).append("]");
    }
}