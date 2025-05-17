package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.PlayField;
import de.cas_ual_ty.ydm.duel.playfield.Zone;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EffectNegateAction extends SingleZoneAction implements IAnnouncedAction
{
    public byte negatedZoneId;
    
    public Zone negatedZone;
    
    public EffectNegateAction(ActionType actionType, byte sourceZoneId, byte negatedZoneId)
    {
        super(actionType, sourceZoneId);
        this.negatedZoneId = negatedZoneId;
    }
    
    public EffectNegateAction(ActionType actionType, Zone sourceZone, Zone negatedZone)
    {
        this(actionType, sourceZone.index, negatedZone.index);
    }
    
    public EffectNegateAction(ActionType actionType, PacketBuffer buf)
    {
        this(actionType, buf.readByte(), buf.readByte());
    }
    
    @Override
    public void writeToBuf(PacketBuffer buf)
    {
        super.writeToBuf(buf);
        buf.writeByte(negatedZoneId);
    }
    
    @Override
    public void initServer(PlayField playField)
    {
        super.initServer(playField);
        negatedZone = playField.getZone(negatedZoneId);
    }
    
    @Override
    public void doAction()
    {
    	// from zone to zone, no need for a specific card
    }
    
    @Override
    public String getAnnouncementLocalKey()
    {
        return actionType.getLocalKey();
    }
    
    @Override
    public Zone getFieldAnnouncementZone()
    {
        return negatedZone;
    }
    
    @Override
    public IFormattableTextComponent getAnnouncement(ITextComponent playerName)
    {
        return new TranslationTextComponent(getAnnouncementLocalKey()).append(": ").append(getFieldAnnouncementZone().getTopCardSafely().cardHolder.getCard().getName());
    }
}