package de.cas_ual_ty.ydm.duel.action;

import de.cas_ual_ty.ydm.duel.playfield.PlayField;
import de.cas_ual_ty.ydm.sleeve.DefaultSleevesType;
import net.minecraft.network.PacketBuffer;

public class InitSleevesAction extends Action
{
    public DefaultSleevesType player1Sleeves;
    public DefaultSleevesType player2Sleeves;
    
    public InitSleevesAction(ActionType actionType, DefaultSleevesType player1Sleeves, DefaultSleevesType player2Sleeves)
    {
        super(actionType);
        this.player1Sleeves = player1Sleeves;
        this.player2Sleeves = player2Sleeves;
    }
    
    public InitSleevesAction(ActionType actionType, PacketBuffer buf)
    {
        this(actionType, DefaultSleevesType.getFromIndex(buf.readInt()), DefaultSleevesType.getFromIndex(buf.readInt()));
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
