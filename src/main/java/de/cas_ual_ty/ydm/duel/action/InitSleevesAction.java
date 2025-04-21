package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.PlayField;
import de.cas_ual_ty.ydm.sleeve.CardBackType;
import net.minecraft.network.PacketBuffer;

public class InitSleevesAction extends Action
{
    public CardBackType player1Sleeves;
    public CardBackType player2Sleeves;
    
    public InitSleevesAction(ActionType actionType, CardBackType player1Sleeves, CardBackType player2Sleeves)
    {
        super(actionType);
        this.player1Sleeves = player1Sleeves;
        this.player2Sleeves = player2Sleeves;
    }
    
    public InitSleevesAction(ActionType actionType, PacketBuffer buf)
    {
        this(actionType, CardBackType.getFromIndex(buf.readInt()), CardBackType.getFromIndex(buf.readInt()));
    }
    
    @Override
    public void writeToBuf(PacketBuffer buf)
    {
        buf.writeInt(player1Sleeves.getIndex());
        buf.writeInt(player2Sleeves.getIndex());
    }
    
    @Override
    public void initClient(PlayField playField)
    {
        playField.initSleeves(player1Sleeves, player2Sleeves);
    }
    
    @Override
    public void doAction()
    {
        
    }
    
    @Override
    public void undoAction()
    {
        
    }
    
    @Override
    public void redoAction()
    {
        
    }
}
