package de.cas_ual_ty.ydm.card.properties;

import java.util.List;

import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class InfoProperties extends Properties 
{
	public InfoType infoType;

	public InfoProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readInfoProperties(j);
    }
    
    public InfoProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof InfoProperties)
        {
            InfoProperties p1 = (InfoProperties) p0;
            infoType = p1.infoType;
        }
    }
    
    public InfoProperties()
    {
    }
    
    public boolean getIsNormal()
    {
        return getInfoType() == InfoType.NORMAL;
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readInfoProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeInfoProperties(j);
    }
    
    public void readInfoProperties(JsonObject j)
    {
        infoType = InfoType.fromString(j.get(JsonKeys.INFO_TYPE).getAsString());
    }
    
    public void writeInfoProperties(JsonObject j)
    {
    	j.addProperty(JsonKeys.INFO_TYPE, infoType.name);
    }
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
        list.add(new StringTextComponent(getInfoType().name + " " + getType().name));
    }
    
    @Override
    public void addText(List<ITextComponent> list)
    {
    	//addInfoTextHeader(list);
        super.addText(list);
    }
    
    @Override
    public void addTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[Info Card");
    	
    	if (!getIsNormal()) 
    	{
    		s.append(" / " + getInfoType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	
    	list.add(s);
    }
    
    // --- Tooltip formatting ---
    
    @Override
    public void addTooltipTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[" + getType().name);
    	if (!getIsNormal()) 
    	{
    		s.append("/" + getInfoType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	list.add(s);
    }
    
    // --- Getters ---
    
    public InfoType getInfoType()
    {
        return infoType;
    }
    
}
