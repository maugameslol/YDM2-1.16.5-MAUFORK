package de.cas_ual_ty.ydm.sleeve;

import java.util.List;
import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class SleeveProperties {
	public static final SleeveProperties DUMMY = new SleeveProperties("Dummy", "DUMMY", "This is a replacement sleeve!") {
        @Override
        public String getImageName()
        {
            return "blanc_sleeve";
        }
        
        @Override
        public boolean getIsHardcoded()
        {
            return true;
        }
    };
    
	public String name;
	public String code;
	public String image;
	public String text;
	//public String[] designers;
	
	public SleeveProperties(String name, String code, String text)
    {
        this.name = name;
        this.code = code;
        this.text = text;
    }
	
	public void postDBInit()
    {
        
    }
	
	public SleeveProperties(JsonObject j)
    {
		name = j.get(JsonKeys.NAME).getAsString();
		code = j.get(JsonKeys.CODE).getAsString();
		
		if(!j.has(JsonKeys.IMAGE))
        {
            image = null;
        }
        else
        {
            image = j.get(JsonKeys.IMAGE).getAsString();
        }
		
		if(!j.has(JsonKeys.TEXT))
        {
            text = null;
        }
        else
        {
            text = j.get(JsonKeys.TEXT).getAsString();
        }
		/*
		if(j.has(JsonKeys.DESIGNERS))
        {
        	JsonArray designers = j.get(JsonKeys.DESIGNERS).getAsJsonArray();
            this.designers = new String[designers.size()];
            for(int i = 0; i < this.designers.length; ++i)
            {
                this.designers[i] = designers.get(i).getAsString();
            }
        }
        else
        {
        	designers = null;
        }
        */
    }
	
	public void addItemInformation(List<ITextComponent> tooltip)
    {
        tooltip.add(new StringTextComponent(name + " Sleeves"));
        if(text != null && !text.isEmpty()) {
        	tooltip.add(new StringTextComponent(text));
        }
    }
    
    public void addInformation(List<ITextComponent> tooltip)
    {
        tooltip.add(new StringTextComponent(name + " Sleeves"));
        if(text != null && !text.isEmpty()) {
        	tooltip.add(new StringTextComponent(text));
        }
    }
	
	// -- Getters --
	
	public String getImageName()
    {
        return code.toLowerCase();
    }
	public String getImageURL()
    {
        return image;
    }
	
	public String getInfoImageName()
    {
        return YDM.proxy.addSleeveInfoTag(getImageName());
    }
    
    public String getItemImageName()
    {
        return YDM.proxy.addSleeveItemTag(getImageName());
    }
    
    public String getMainImageName()
    {
        return YDM.proxy.addSleeveMainTag(getImageName());
    }
    
    public ResourceLocation getInfoImageResourceLocation()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + YDM.proxy.getSleeveInfoReplacementImage(this) + ".png");
    }
	
	public ResourceLocation getItemImageResourceLocation()
    {
        return new ResourceLocation(YDM.MOD_ID, "item/" + getItemImageName());
    }
	
	public ResourceLocation getMainImageResourceLocation()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + YDM.proxy.getSleeveMainReplacementImage(this) + ".png");
    }
	
	public boolean getIsHardcoded()
    {
        return false;
    }
}
