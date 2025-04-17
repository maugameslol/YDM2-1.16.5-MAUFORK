package de.cas_ual_ty.ydm.card.properties;

import java.util.List;

import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class MaterialProperties extends Properties 
{
	public String attribute;
	public MaterialType materialType;
	
	public MaterialProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readMaterialProperties(j);
    }
    
    public MaterialProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof MaterialProperties)
        {
            MaterialProperties p1 = (MaterialProperties) p0;
            attribute = p1.attribute;
            materialType = p1.materialType;
        }
    }
    
    public MaterialProperties()
    {
    }
    
    public boolean getIsNormal()
    {
        return getMaterialType() == MaterialType.NORMAL;
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readMaterialProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeMaterialProperties(j);
    }
    
    public void readMaterialProperties(JsonObject j)
    {
    	if(j.has(JsonKeys.ATTRIBUTE))
        {
    		attribute = j.get(JsonKeys.ATTRIBUTE).getAsString();
        }
        else
        {
        	attribute = null;
        }
        materialType = MaterialType.fromString(j.get(JsonKeys.MATERIAL_TYPE).getAsString());
    }
    
    public void writeMaterialProperties(JsonObject j)
    {
    	j.addProperty(JsonKeys.ATTRIBUTE, attribute);
    	j.addProperty(JsonKeys.MATERIAL_TYPE, materialType.name);
    }
    
    /*
    @Override
    public void addHeader(List<ITextComponent> list)
    {
        super.addHeader(list);
        addMaterialHeader(list);
    }
    */
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
        list.add(new StringTextComponent(getMaterialType().name + " " + getType().name));
    }
    
    @Override
    public void addCardAttribute(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("");
    	if(getAttribute() != null)
        {
            s.append(getAttribute());
        }
    	else
    	{
    		s.append("MATERIAL");
    	}
    	
    	list.add(s);
    }
    
    @Override
    public void addText(List<ITextComponent> list)
    {
        super.addText(list);
    }
    
    @Override
    public void addTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[Material Card");
    	
    	if (!getIsNormal()) 
    	{
    		s.append(" / " + getMaterialType().name + "]");
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
    		s.append("/" + getMaterialType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	list.add(s);
    }
    
    // --- Getters ---
    
    public String getAttribute()
    {
        return attribute;
    }
    
    public MaterialType getMaterialType()
    {
        return materialType;
    }
    
}
