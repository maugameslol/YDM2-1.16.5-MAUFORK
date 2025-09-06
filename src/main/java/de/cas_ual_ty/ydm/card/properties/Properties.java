package de.cas_ual_ty.ydm.card.properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class Properties
{
    public static final Properties DUMMY = new Properties()
    {
        @Override
        public String getImageName(byte imageIndex)
        {
            return "blanc_card";
        }
        
        @Override
        public void addCardType(List<ITextComponent> list)
        {
            
        }
    };
    
    static
    {
        Properties.DUMMY.isHardcoded = true;
        Properties.DUMMY.name = "Dummy";
        Properties.DUMMY.id = 0;
        Properties.DUMMY.isIllegal = false;
        Properties.DUMMY.isCustom = true;
        Properties.DUMMY.text = "This is a replacement card!";
        Properties.DUMMY.attribute = "DUMMY";
        Properties.DUMMY.type = null;
        Properties.DUMMY.archetypes = null;
        Properties.DUMMY.images = null;
        Properties.DUMMY.tags = null;
        Properties.DUMMY.keywords = null;
        Properties.DUMMY.designers = null;
        Properties.DUMMY.isAnime = false;
        Properties.DUMMY.isRush = false;
        Properties.DUMMY.isSpeed = false;
        Properties.DUMMY.isLegend = false;
        Properties.DUMMY.limit = 0;
        Properties.DUMMY.cardColor = CardColor.BLANK;
    }
    
    public boolean isHardcoded;
    public String name;
    public long id;
    public boolean isIllegal;
    public boolean isCustom;
    public String text;
    public String flavorText;
    public PrimaryCardType type;
    public String attribute;
    public String[] archetypes;
    public String[] images;
    public String[] tags;
    public String[] keywords;
    public String[] designers;
    public CardColor cardColor;
    public String[] mentions;
    
    public boolean isAnime;
    public byte limit;
    
    public boolean isSpeed;
    public boolean isLimitShared;
    
    public boolean isRush;
    public boolean isLegend;
    public String rushRequirementText;
    public String rushEffectType;
    public String rushEffectText;
    
    protected int imageIndicesAmt;
    
    public Properties(Properties p0)
    {
        isHardcoded = false;
        name = p0.name;
        id = p0.id;
        isIllegal = p0.isIllegal;
        isCustom = p0.isCustom;
        text = p0.text;
        flavorText = p0.flavorText;
        type = p0.type;
        attribute = p0.attribute;
        archetypes = p0.archetypes;
        images = p0.images;
        imageIndicesAmt = images.length;
        tags = p0.tags;
        keywords = p0.keywords;
        designers = p0.designers;
        cardColor = p0.cardColor;
        mentions = p0.mentions;
        isAnime = p0.isAnime;
        isSpeed = p0.isSpeed;
        isLegend = p0.isLegend;
        limit = p0.limit;
        isRush = p0.isRush;
        rushRequirementText = p0.rushRequirementText;
        rushEffectType = p0.rushEffectType;
        rushEffectText = p0.rushEffectText;
    }
    
    public Properties(JsonObject j)
    {
        isHardcoded = false;
        readAllProperties(j);
        imageIndicesAmt = 1;
    }
    
    public Properties()
    {
        isHardcoded = false;
        imageIndicesAmt = 1;
    }
    
    public void postDBInit()
    {
        
    }
    
    public void readAllProperties(JsonObject j)
    {
        readProperties(j);
    }
    
    public void writeAllProperties(JsonObject j)
    {
        writeProperties(j);
    }
    
    public void readProperties(JsonObject j)
    {
        name = j.get(JsonKeys.NAME).getAsString();
        id = j.get(JsonKeys.ID).getAsLong();
        if(j.has(JsonKeys.IS_ILLEGAL))
        {
        	isIllegal = j.get(JsonKeys.IS_ILLEGAL).getAsBoolean();
        }
        else
        {
        	isIllegal = false;
        }
        if(j.has(JsonKeys.IS_CUSTOM))
        {
        	isCustom = j.get(JsonKeys.IS_CUSTOM).getAsBoolean();
        }
        else
        {
        	isCustom = false;
        }
        if(j.has(JsonKeys.TEXT))
        {
        	text = j.get(JsonKeys.TEXT).getAsString();
        }
        else
        {
        	text = null;
        }
        
        if(j.has(JsonKeys.FLAVOR_TEXT))
        {
    		flavorText = j.get(JsonKeys.FLAVOR_TEXT).getAsString();
        }
        else
        {
        	flavorText = null;
        }
        
        type = PrimaryCardType.fromString(j.get(JsonKeys.TYPE).getAsString());
        
        if(j.has(JsonKeys.ATTRIBUTE))
        {
    		attribute = j.get(JsonKeys.ATTRIBUTE).getAsString();
        }
        else
        {
        	if(getIsSpell()) 
        	{
        		attribute = Attribute.SPELL.name;
        	}
        	else if(getIsTrap()) 
        	{
        		attribute = Attribute.TRAP.name;
        	}
        	else if(getIsSkill()) 
        	{
        		attribute = Attribute.SKILL.name;
        	}
        	else if(getIsInfo()) 
        	{
        		attribute = Attribute.INFO.name;
        	}
        	else if(getIsMaterial()) 
        	{
        		attribute = Attribute.MATERIAL.name;
        	}
        	else 
        	{
        		attribute = null;
        	}
        }
        
        if(j.has(JsonKeys.CARD_COLOR))
        {
    		cardColor = CardColor.fromString(j.get(JsonKeys.CARD_COLOR).getAsString());
        }
        else
        {
        	cardColor = null;
        }
        
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
        
        if(j.has(JsonKeys.IS_ANIME))
        {
            isAnime = j.get(JsonKeys.IS_ANIME).getAsBoolean();
        }
        else
        {
        	isAnime = false;
        }
        
        if(j.has(JsonKeys.IS_RUSH))
        {
            isRush = j.get(JsonKeys.IS_RUSH).getAsBoolean();
        }
        else
        {
        	isRush = false;
        }
        
        if(j.has(JsonKeys.RUSH_REQUIREMENT_TEXT))
        {
        	rushRequirementText = j.get(JsonKeys.RUSH_REQUIREMENT_TEXT).getAsString();
        }
        else
        {
        	rushRequirementText = null;
        }
        
        if(j.has(JsonKeys.RUSH_EFFECT_TYPE))
        {
        	rushEffectType = j.get(JsonKeys.RUSH_EFFECT_TYPE).getAsString();
        }
        else
        {
        	rushEffectType = null;
        }
        
        if(j.has(JsonKeys.RUSH_EFFECT_TEXT))
        {
        	rushEffectText = j.get(JsonKeys.RUSH_EFFECT_TEXT).getAsString();
        }
        else
        {
        	rushEffectText = null;
        }
        
        if(j.has(JsonKeys.IS_SPEED))
        {
            isSpeed = j.get(JsonKeys.IS_SPEED).getAsBoolean();
        }
        else
        {
        	isSpeed = false;
        }
        
        if(j.has(JsonKeys.IS_LEGEND))
        {
            isLegend = j.get(JsonKeys.IS_LEGEND).getAsBoolean();
        }
        else
        {
        	isLegend = false;
        }
        
        if(j.has(JsonKeys.LIMIT))
        {
            limit = j.get(JsonKeys.LIMIT).getAsByte();
        }
        else
        {
        	limit = 3;
        }
        
        if(j.has(JsonKeys.IS_LIMIT_SHARED))
        {
            isLimitShared = j.get(JsonKeys.IS_LIMIT_SHARED).getAsBoolean();
        }
        else
        {
        	isLimitShared = false;
        }
        
        if(j.has(JsonKeys.ARCHETYPES))
        {
        	JsonArray archetypes = j.get(JsonKeys.ARCHETYPES).getAsJsonArray();
            this.archetypes = new String[archetypes.size()];
            for(int i = 0; i < this.archetypes.length; ++i)
            {
                this.archetypes[i] = archetypes.get(i).getAsString();
            }
        }
        else
        {
        	archetypes = null;
        }
        
        if(j.has(JsonKeys.TAGS))
        {
        	JsonArray tags = j.get(JsonKeys.TAGS).getAsJsonArray();
            this.tags = new String[tags.size()];
            for(int i = 0; i < this.tags.length; ++i)
            {
                this.tags[i] = tags.get(i).getAsString();
            }
        }
        else
        {
        	tags = null;
        }
        
        if(j.has(JsonKeys.KEYWORDS))
        {
        	JsonArray keywords = j.get(JsonKeys.KEYWORDS).getAsJsonArray();
            this.keywords = new String[keywords.size()];
            for(int i = 0; i < this.keywords.length; ++i)
            {
                this.keywords[i] = keywords.get(i).getAsString();
            }
        }
        else
        {
        	keywords = null;
        }
        
        if(j.has(JsonKeys.MENTIONS))
        {
        	JsonArray mentions = j.get(JsonKeys.MENTIONS).getAsJsonArray();
            this.mentions = new String[mentions.size()];
            for(int i = 0; i < this.mentions.length; ++i)
            {
                this.mentions[i] = mentions.get(i).getAsString();
            }
        }
        else
        {
        	mentions = null;
        }
        
        JsonArray images = j.get(JsonKeys.IMAGES).getAsJsonArray();
        this.images = new String[images.size()];
        for(int i = 0; i < this.images.length; ++i)
        {
            this.images[i] = images.get(i).getAsString();
        }
    }
    
    public void writeProperties(JsonObject j)
    {
        j.addProperty(JsonKeys.NAME, name);
        j.addProperty(JsonKeys.ID, id);
        j.addProperty(JsonKeys.IS_ILLEGAL, isIllegal);
        j.addProperty(JsonKeys.IS_CUSTOM, isCustom);
        j.addProperty(JsonKeys.TEXT, text);
        j.addProperty(JsonKeys.FLAVOR_TEXT, flavorText);
        j.addProperty(JsonKeys.TYPE, type.name);
        j.addProperty(JsonKeys.ATTRIBUTE, attribute);
        j.addProperty(JsonKeys.IS_ANIME, isAnime);
        j.addProperty(JsonKeys.IS_SPEED, isSpeed);
        j.addProperty(JsonKeys.IS_LEGEND, isLegend);
        j.addProperty(JsonKeys.LIMIT, limit);
        j.addProperty(JsonKeys.IS_LIMIT_SHARED, isLimitShared);
        j.addProperty(JsonKeys.CARD_COLOR, cardColor.name);
        
        j.addProperty(JsonKeys.IS_RUSH, isRush);
        j.addProperty(JsonKeys.RUSH_REQUIREMENT_TEXT, rushRequirementText);
        j.addProperty(JsonKeys.RUSH_EFFECT_TYPE, rushEffectType);
        j.addProperty(JsonKeys.RUSH_EFFECT_TEXT, rushEffectText);
        
        JsonArray archetypes = new JsonArray();
        for(String archetype : this.archetypes)
        {
        	archetypes.add(archetype);
        }
        j.add(JsonKeys.ARCHETYPES, archetypes);
        
        JsonArray tags = new JsonArray();
        for(String tag : this.tags)
        {
        	tags.add(tag);
        }
        j.add(JsonKeys.TAGS, tags);
        
        JsonArray keywords = new JsonArray();
        for(String keyword : this.keywords)
        {
        	keywords.add(keyword);
        }
        j.add(JsonKeys.KEYWORDS, keywords);
        
        JsonArray designers = new JsonArray();
        for(String designer : this.designers)
        {
        	designers.add(designer);
        }
        j.add(JsonKeys.DESIGNERS, designers);
        
        JsonArray mentions = new JsonArray();
        for(String mention : this.mentions)
        {
        	mentions.add(mention);
        }
        j.add(JsonKeys.MENTIONS, mentions);
        
        JsonArray images = new JsonArray();
        for(String image : this.images)
        {
            images.add(image);
        }
        j.add(JsonKeys.IMAGES, images);
    }
    
    public boolean getIsHardcoded()
    {
        return isHardcoded;
    }
    
    public boolean getIsSpell()
    {
        return getType() == PrimaryCardType.SPELL;
    }
    
    public boolean getIsTrap()
    {
        return getType() == PrimaryCardType.TRAP;
    }
    
    public boolean getIsMonster()
    {
        return getType() == PrimaryCardType.MONSTER;
    }
    
    public boolean getIsSkill()
    {
        return getType() == PrimaryCardType.SKILL;
    }
    
    public boolean getIsInfo()
    {
        return getType() == PrimaryCardType.INFO;
    }
    
    public boolean getIsMaterial()
    {
        return getType() == PrimaryCardType.MATERIAL;
    }
    
    public boolean getIsInExtraDeck()
    {
        return false;
    }
    
    public int getImageIndicesAmt()
    {
        return imageIndicesAmt;
    }
    
    public boolean isAcceptedImageIndex(byte imageIndex)
    {
        return imageIndex >= 0 && imageIndex < getImageIndicesAmt();
    }
    
    public byte adjustImageIndex(byte imageIndex)
    {
        if(!isAcceptedImageIndex(imageIndex))
        {
            return 0;
        }
        else
        {
            return imageIndex;
        }
    }
    
    public String getImageURL(byte imageIndex)
    {
        return getImages()[adjustImageIndex(imageIndex)];
    }
    
    public String getImageName(byte imageIndex)
    {
        return getId() + "_" + adjustImageIndex(imageIndex);
    }
    
    public String getInfoImageName(byte imageIndex)
    {
        return YDM.proxy.addCardInfoTag(getImageName(imageIndex));
    }
    
    public String getItemImageName(byte imageIndex)
    {
        return YDM.proxy.addCardItemTag(getImageName(imageIndex));
    }
    
    public String getMainImageName(byte imageIndex)
    {
        return YDM.proxy.addCardMainTag(getImageName(imageIndex));
    }
    
    public ResourceLocation getInfoImageResourceLocation(byte imageIndex)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + YDM.proxy.getCardInfoReplacementImage(this, adjustImageIndex(imageIndex)) + ".png");
    }
    
    public ResourceLocation getItemImageResourceLocation(byte imageIndex)
    {
        return new ResourceLocation(YDM.MOD_ID, "item/" + getItemImageName(imageIndex));
    }
    
    public ResourceLocation getMainImageResourceLocation(byte imageIndex)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + YDM.proxy.getCardMainReplacementImage(this, adjustImageIndex(imageIndex)) + ".png");
    }
    
    public void addInformation(List<ITextComponent> list)
    {
    	addName(list);
    	addLegality(list);
    	list.add(StringTextComponent.EMPTY);
        addHeader(list);
        list.add(StringTextComponent.EMPTY);
        addText(list);
        addDesignersText(list);
    }
    
    public void addHeader(List<ITextComponent> list)
    {
        //list.add(new StringTextComponent(getName()));
        addCardType(list);
        addArchetypes(list);
        addTagsText(list);
        addCardAttribute(list);
    }
    
    //addName
    public void addName(List<ITextComponent> list)
    {
    	IFormattableTextComponent name = new StringTextComponent(getName());
    	if(getLimit() >= 0)
        {
    		name.append(new StringTextComponent(" "));
    		if(getLimit() == 0) 
    		{
    			name.append(new StringTextComponent("Ⓧ").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    		}
    		if(getLimit() == 1) 
    	    {
    	    	name.append(new StringTextComponent("①").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    }
    		if(getLimit() == 2) 
    		{
    			name.append(new StringTextComponent("②").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    }
    	    if(getLimit() == 3) 
    	    {
    	    	if(getIsLimitShared()) 
    	    	{
    	    		name.append(new StringTextComponent("③").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    	}
    	    }
    	    if(getLimit() > 3) 
    		{
    	    	name.append(new StringTextComponent("(" + getLimit() + ")").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
    		}
        }
    	else 
		{
    		name.append(new StringTextComponent(" "));
			name.append(new StringTextComponent("∞").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
		}
    	if(getIsLegend()) 
		{
    		name.append(new StringTextComponent(" "));
			name.append(new StringTextComponent("Ⓛ").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD)));
		}
        list.add(name);
    }
    
    //TypeBox example: [Dragon / Effect], [Spell Card / Quick-Play], [Trap Card / Counter]
    public void addTypeBox(List<ITextComponent> list)
    {
    	if(getType() != null) 
    	{
        list.add(new StringTextComponent("[" + getType().name + "]"));
    	}
    	else 
    	{
    		list.add(new StringTextComponent("[NULL]"));
    	}
    }
    
    public void addArchetypes(List<ITextComponent> list)
    {
    	if(getArchetypes() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("");
    		if(getArchetypes().length > 1) 
    		{
    			for(int i = 0; i < archetypes.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(archetypes[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(" • " + archetypes[i]));
    				}
    			}
    			s.append(" ");
    			s.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".archetypes"));
    		}
    		else 
    		{
    			for(String archetype : archetypes)
    			s.append(archetype + " ");
    			s.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".archetype"));
    		}
    		list.add(s);
    	}
    }
    
    public void addText(List<ITextComponent> list)
    {
    	addTypeBox(list);
    	
    	if(getText() != null && !getText().isEmpty()) 
    	{
    		list.add(new StringTextComponent(getText()));
    	}
    	
    	addRushHeader(list);
    	
        if(getFlavorText() != null && !getFlavorText().isEmpty()) 
        {
        	list.add(new StringTextComponent("---"));
        	list.add(new StringTextComponent(getFlavorText()).setStyle(Style.EMPTY.applyFormat(TextFormatting.ITALIC)));
        }
    }
    
    public void addCardType(List<ITextComponent> list)
    {
    	if(getType() != null) 
    	{
    		list.add(new StringTextComponent(type.name));
    	}
    	else 
    	{
    		list.add(new StringTextComponent("null"));
    	}
    }
    
    public void addCardAttribute(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("");
    	if(getAttribute() != null)
        {
            s.append(getAttribute());
        }
    	else
    	{
    		s.append("NULL");
    	}
    	list.add(s);
    }
    
    public void addLegality(List<ITextComponent> list)
    {
    	IFormattableTextComponent format = new StringTextComponent("[" + getId() + "]");
    	
    	if(getIsIllegal())
        {
    		format.append(new StringTextComponent(" "));
    		format.append(new StringTextComponent("Illegal").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
        }
    	
    	if(getIsCustom())
        {
    		format.append(new StringTextComponent(" "));
    		format.append(new StringTextComponent("Custom").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
        }
    	
    	if(getIsAnime())
        {
    		format.append(new StringTextComponent(" "));
    		format.append(new StringTextComponent("Anime/Manga").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
        }
    	
    	if(getIsRush())
        {
    		format.append(new StringTextComponent(" "));
    		format.append(new StringTextComponent("RUSH").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD)));
        }
    	
    	if(getIsSpeed())
        {
    		format.append(new StringTextComponent(" "));
    		format.append(new StringTextComponent("SPEED").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE)));
        }
    	
    	list.add(format);
    	
    	if(getIsLegend()) 
		{
			list.add(new StringTextComponent("LEGEND").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD)));
		}
    	
    	if(getLimit() >= 0)
        {
    		if(getIsLimitShared() && getLimit() > 0) 
    		{
    			list.add(new StringTextComponent("Limited " + getLimit()).setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    		}
    		else 
    		{
    			if(getLimit() == 0) 
    			{
    				list.add(new StringTextComponent("Forbidden").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    			}
    			if(getLimit() == 1) 
    	    	{
    	    		list.add(new StringTextComponent("Limited").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    	}
    			if(getLimit() == 2) {
    				list.add(new StringTextComponent("Semi-Limited").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    	}
    	    	if(getLimit() == 3) {
    	    		//list.add(new StringTextComponent("Unlimited"));
    	    	}
    	    	if(getLimit() > 3) 
    			{
    	    		list.add(new StringTextComponent("At " + getLimit() + " Copies").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
    			}
    		}
        }
    	else 
		{
			list.add(new StringTextComponent("Any Amount").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
		}
    }
    
    public void addDesignersText(List<ITextComponent> list)
    {
    	if(getDesigners() != null)  
    	{
    		list.add(StringTextComponent.EMPTY);
    		IFormattableTextComponent s = new StringTextComponent("Designed by: ").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE));
    		if(getDesigners().length > 1) 
    		{
    			for(int i = 0; i < designers.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(designers[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(", " + designers[i]));
    				}
    			}
    		}
    		else 
    		{
    			for(String designer : designers)
    			s.append(designer);
    		}
    		list.add(s);
    	}
    }
    
    public void addTagsText(List<ITextComponent> list)
    {
    	if(getTags() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("");
    		if(getTags().length > 1) 
    		{
    			s.append("Tags: ");
    			for(int i = 0; i < tags.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent("#" + tags[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(", #" + tags[i]));
    				}
    			}
    		}
    		else 
    		{
    			s.append("Tag: #");
    			for(String tag : tags)
    			s.append(tag);
    		}
    		list.add(s);
    	}
    }
    
    public void addKeywords(List<ITextComponent> list)
    {
    	if(getKeywords() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("");
    		if(getKeywords().length > 1) 
    		{
    			s.append("Keywords: ");
    			for(int i = 0; i < keywords.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(keywords[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(", " + keywords[i]));
    				}
    			}
    		}
    		else 
    		{
    			s.append("Keyword: ");
    			for(String keyword : keywords)
    			s.append(keyword);
    		}
    		list.add(s);
    	}
    }
    
    public void addRushHeader(List<ITextComponent> list) 
    {
    	if(getIsRush()) 
    	{
    		if(getRushRequirementText() != null && !getRushRequirementText().isEmpty()) 
            {
            	list.add(StringTextComponent.EMPTY);
            	list.add(new StringTextComponent("[ REQUIREMENT ]").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD)));
            	list.add(new StringTextComponent(getRushRequirementText()));
            	list.add(StringTextComponent.EMPTY);
            }
    		
            if(getRushEffectType() != null) 
            {
            	if(!getRushEffectType().isEmpty()) 
            	{
            		list.add(new StringTextComponent("[ " + getRushEffectType() + " EFFECT ]").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD)));
            	}
            	else 
            	{
            		list.add(new StringTextComponent("[ EFFECT ]").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD)));
            	}
            }
            
            if(getRushEffectText() != null && !getRushEffectText().isEmpty()) 
            {
            	list.add(new StringTextComponent(getRushEffectText()));
            	list.add(StringTextComponent.EMPTY);
            }
    	}
    }
    
    // -- Tooltip Formatting --
    
    public void addShiftTooltipInformation(List<ITextComponent> list)
    {
    	addTooltipArchetypes(list);
    	addTooltipMentions(list);
    	addTooltipHeader(list);
    	addTooltipTypeBox(list);
    	addTooltipBattleStats(list);
    	addTooltipCardTags(list);
        addKeywords(list);
        addTooltipDesigners(list);
        addTooltipLegality(list);
    }
    
    public void addTooltipTypeBox(List<ITextComponent> list)
    {
    	if(getType() != null) 
    	{
    	list.add(new StringTextComponent("[" + getType().name + "]"));
    	}
    	else 
    	{
    		list.add(new StringTextComponent("[NULL]"));
    	}
    }
    
    public void addTooltipHeader(List<ITextComponent> list)
    {
    	addTooltipAttribute(list);
    }
    
    public void addTooltipAttribute(List<ITextComponent> list)
    {
    	if(getAttribute() != null)
        {
    		list.add(new StringTextComponent(getAttribute()));
        }
    	else
    	{
    		list.add(new StringTextComponent(getType().name()));
    	}
    }
    
    public void addTooltipArchetypes(List<ITextComponent> list)
    {
    	if(getArchetypes() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("");
    		if(getArchetypes().length > 1) 
    		{
    			s.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".archetypes"));
    			s.append(": ");
    			for(int i = 0; i < archetypes.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(archetypes[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(" • " + archetypes[i]));
    				}
    			}
    		}
    		else 
    		{
    			s.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".archetype"));
    			s.append(": ");
    			for(String archetype : archetypes)
    			s.append(archetype);
    		}
    		list.add(s);
    	}
    }
    
    public void addTooltipLegality(List<ITextComponent> list)
    {
    	IFormattableTextComponent id = new StringTextComponent("[" + getId() + "]");
    	
    	list.add(id);
    	
    	if(getIsIllegal())
        {
    		list.add(new StringTextComponent("Illegal").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
        }
    	
    	if(getIsCustom())
        {
    		list.add(new StringTextComponent("Custom").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
        }
    	
    	if(getIsAnime())
        {
    		list.add(new StringTextComponent("Anime/Manga").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
        }
    	
    	if(getIsRush())
        {
    		list.add(new StringTextComponent("RUSH").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD)));
        }
    	
    	if(getIsSpeed())
        {
    		list.add(new StringTextComponent("SPEED").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE)));
        }
    	
    	if (getIsLegend()) 
		{
    		list.add(new StringTextComponent("LEGEND").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD)));
		}
    	
    	if(getLimit() >= 0)
        {
    		if(getIsLimitShared() && getLimit() > 0) 
    		{
    			list.add(new StringTextComponent("Limited " + getLimit()).setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    		}
    		else 
    		{
    			if(getLimit() == 0) 
    			{
    				list.add(new StringTextComponent("Forbidden").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    			}
    			if(getLimit() == 1) 
    	    	{
    				list.add(new StringTextComponent("Limited").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    	}
    			if(getLimit() == 2) {
    				list.add(new StringTextComponent("Semi-Limited").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED)));
    	    	}
    	    	if(getLimit() == 3) {
    	    		//list.add(new StringTextComponent("Unlimited"));
    	    	}
    	    	if(getLimit() > 3) 
    			{
    	    		list.add(new StringTextComponent("At " + getLimit()).setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
    			}
    		}
        }
    	else 
		{
    		list.add(new StringTextComponent("Infinite").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE)));
		}
    }
    
    public void addTooltipCardTags(List<ITextComponent> list)
    {
    	if(getTags() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("");
    		if(getTags().length > 1) 
    		{
    			s.append("Tags: ");
    			for(int i = 0; i < tags.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(tags[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(" • " + tags[i]));
    				}
    			}
    		}
    		else 
    		{
    			s.append("Tag: ");
    			for(String tag : tags)
    			s.append(tag);
    		}
    		list.add(s);
    	}
    }
    
    public void addTooltipDesigners(List<ITextComponent> list)
    {
    	if(getDesigners() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("Designed by: ").setStyle(Style.EMPTY.applyFormat(TextFormatting.LIGHT_PURPLE));
    		if(getDesigners().length > 1) 
    		{
    			for(int i = 0; i < designers.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(designers[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(", " + designers[i]));
    				}
    			}
    		}
    		else 
    		{
    			for(String designer : designers)
    			s.append(designer);
    		}
    		list.add(s);
    	}
    }
    
    public void addTooltipMentions(List<ITextComponent> list)
    {
    	if(getMentions() != null)  
    	{
    		IFormattableTextComponent s = new StringTextComponent("Mentions: ");
    		if(getMentions().length > 1) 
    		{
    			for(int i = 0; i < mentions.length; ++i) 
    			{
    				if (i == 0) {
    					s.append(new StringTextComponent(mentions[i]));
    				}
    				if(i > 0) {
    					s.append(new StringTextComponent(" • " + mentions[i]));
    				}
    			}
    		}
    		else 
    		{
    			for(String mention : mentions)
    			s.append(mention);
    		}
    		list.add(s);
    	}
    }
    
    public void addTooltipBattleStats(List<ITextComponent> list) 
    {
    	
    }
    
    // --- CardColor ---
    
    public CardColor getDefaultCardColor() 
    {
    	CardColor defaultColor = null;
    	if(getCardColor() == null) 
    	{
    		if(getIsSpell()) 
        	{
    			defaultColor = CardColor.SPELL_GREEN;
        	}
        	else if(getIsTrap()) 
        	{
        		defaultColor = CardColor.TRAP_MAGENTA;
        	}
        	else if(getIsSkill()) 
        	{
        		defaultColor = CardColor.SKILL_BLUE;
        	}
        	else if(getIsInfo()) 
        	{
        		defaultColor = CardColor.GRAY;
        	}
        	else if(getIsMaterial()) 
        	{
        		defaultColor = CardColor.GRAY;
        	}
    	}
    	else 
    	{
    		defaultColor = CardColor.BLANK;
    	}
    	return defaultColor;
    }
    
    // Get Limit Amount
    
    public void addLimitNumber(List<ITextComponent> list)
    {
    	list.add(new StringTextComponent("" + getLimit() + ""));
    }
    
    // TODO: DuelScreenDueling Zone Tooltip
    
    // --- Getters ---
    
    public String getName()
    {
        return name;
    }
    
    public long getId()
    {
        return id;
    }
    
    public boolean getIsIllegal()
    {
        return isIllegal;
    }
    
    public boolean getIsCustom()
    {
        return isCustom;
    }
    
    public String getText()
    {
        return text;
    }
    
    public String getFlavorText()
    {
        return flavorText;
    }
    
    public PrimaryCardType getType()
    {
        return type;
    }
    
    public String getAttribute()
    {
        return attribute;
    }
    
    public CardColor getCardColor()
    {
        return cardColor;
    }
    
    public String[] getImages()
    {
        return images;
    }
    
    public String[] getArchetypes()
    {
        return archetypes;
    }
    
    public String[] getTags()
    {
        return tags;
    }
    
    public String[] getKeywords()
    {
        return keywords;
    }
    
    public String[] getDesigners()
    {
        return designers;
    }
    
    public String[] getMentions()
    {
        return mentions;
    }
    
    public boolean getIsAnime()
    {
        return isAnime;
    }
    
    public boolean getIsSpeed()
    {
        return isSpeed;
    }
    
    public boolean getIsRush()
    {
        return isRush;
    }
    
    public boolean getIsLegend()
    {
        return isLegend;
    }
    
    public String getRushRequirementText()
    {
        return rushRequirementText;
    }
    
    public String getRushEffectType()
    {
        return rushEffectType;
    }
    
    public String getRushEffectText()
    {
        return rushEffectText;
    }
    
    public byte getLimit()
    {
        return limit;
    }
    
    public boolean getIsLimitShared()
    {
        return isLimitShared;
    }
}
