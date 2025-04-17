package de.cas_ual_ty.ydm.sleeve;

import de.cas_ual_ty.ydm.YDM;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public enum CardSleevesType
{
	// TODO: Put sleeves in the database, make them dynamically generated like sets and cards, so that we don't have this mess anymore.
    CARD_BACK("card_back"), 
    BRONZE("bronze"), SILVER("silver"), GOLD("gold"), PLATINUM("platinum"), RUBY("ruby"), DIAMOND("diamond"), EMERALD("emerald"), COPPER("copper"), AMETHYST("amethyst"), SAPPHIRE("sapphire"), NETHERITE("netherite"),
    BLACK("black"), BLUE("blue"), BROWN("brown"), CYAN("cyan"), GRAY("gray"), GREEN("green"), LIGHT_BLUE("light_blue"), LIGHT_GRAY("light_gray"), LIME("lime"), MAGENTA("magenta"), ORANGE("orange"), PINK("pink"), PURPLE("purple"), RED("red"), WHITE("white"), YELLOW("yellow"),
    VFD("vfd"), OLD_ENTITY("old_entity"), MASTER_PEACE("master_peace"), HERO("hero"), DESTINY_HERO("destiny_hero"),
    EGYPTIAN_GODS("egyptian_gods"), MIRACLE_FUSION("miracle_fusion"), ALBAZ_TRIBRIGADE("albaz_tribrigade"), DMG("dmg"), YUGI25("yugi25"), KAIBA25("kaiba25"), GOLDPRIDE_CARRIE("goldpride_carrie"), IP_MASQUERENA("ip_masquerena"), 
    MAGIKURIBOH("magikuriboh"), THEDARKMAGICIANS("thedarkmagicians"), DMG_TDK("dmg_tdk"), ASHBLOSSOM_2019("ashblossom_2019"), DARKHEX("darkhex"), GOLDENDUELIST("goldenduelist"), KAIBACORP("kaibacorp"), KAIBAMAJESTIC("kaibamajestic"),
    PENDPOWER("pendpower"), DOUBLEDRA("doubledra"), 
    SKYSTRIKER1_MAMA("skystriker1_mama"), SKYSTRIKER2_MAMA("skystriker2_mama"), WITCHCRAFT1_MAMA("witchcraft1_mama"), WITCHCRAFT2_MAMA("witchcraft2_mama"), MAYAKASHI1_MAMA("mayakashi1_mama"), MAYAKASHI2_MAMA("mayakashi2_mama"),
    YGOMD_LINK_BLACK("ygomd_link_black"), YGOMD_FUSION_PURPLE("ygomd_fusion_purple"), YGOMD_SYNCHRO_SILVER("ygomd_synchro_silver"), YGOMD_XYZ_BLACK("ygomd_xyz_black"), YGOMD_LINK_BLUE("ygomd_link_blue"), YGOMD_PENDULUM_GREEN("ygomd_pendulum_green"),
    YGOMD_FIRE("ygomd_fire"), YGOMD_WIND("ygomd_wind"), YGOMD_WATER("ygomd_water"), YGOMD_EARTH("ygomd_earth"), YGOMD_LIGHT("ygomd_light"), YGOMD_DARK("ygomd_dark"),
    YGOMD_AURAM("ygomd_auram"), YGOMD_GEARTOWN("ygomd_geartown"), YGOMD_ASHBLOSSOM("ygomd_ashblossom"), YGOMD_BECHAOSMAX("ygomd_bechaosmax"), YGOMD_TRISHULA("ygomd_trishula"), YGOMD_DRAGONMAID("ygomd_dragonmaid"), YGOMD_TOKENCOLLECTOR("ygomd_tokencollector"), YGOMD_GHOSTRICKFEST("ygomd_ghostrickfest"), 
    YGOMD_DINOMORPHIA("ygomd_dinomorphia"), YGOMD_RUNICK("ygomd_runick"), YGOMD_LOVELYLAB("ygomd_lovelylab"), YGOMD_VAYLANTZ("ygomd_vaylantz"), YGOMD_REGULUS("ygomd_regulus"), YGOMD_TRIBRIGADE("ygomd_tribrigade"), YGOMD_FORECAST("ygomd_forecast"), YGOMD_1STMILLENIUM("ygomd_1stmillenium"), 
    YGOMD_WORLDLEGACY("ygomd_worldlegacy"), YGOMD_VERNUSYLPH("ygomd_vernusylph"), YGOMD_GIGASPRIGHT("ygomd_gigaspright"), YGOMD_KURIKARA("ygomd_kurikara"), YGOMD_KALEIDOHEART("ygomd_kaleidoheart"), YGOMD_EXOSISTERS("ygomd_exosisters"), YGOMD_PUNKDRIVE("ygomd_punkdrive"), YGOMD_5HEADDRAGON("ygomd_5headdragon"), 
    YGOMD_BAGOOSKA("ygomd_bagooska"), YGOMD_SPIRITCHARM("ygomd_spiritcharm"), YGOMD_FURHIRE("ygomd_furhire"), YGOMD_GHOTI("ygomd_ghoti"), YGOMD_WCVICEMADAME("ygomd_wcvicemadame"), YGOMD_BYSTIALLUBE("ygomd_bystiallube"), YGOMD_TRAPTUNE("ygomd_traptune"), YGOMD_OVERKINGDW("ygomd_overkingdw"), 
    YGOMD_MSJUDGE("ygomd_msjudge"), YGOMD_CHAOSANGEL("ygomd_chaosangel"), YGOMD_BLSLEGEND("ygomd_blslegend"), YGOMD_OHIME("ygomd_ohime"), YGOMD_ARISEHEART("ygomd_ariseheart"), YGOMD_LILLATREAT("ygomd_lillatreat"), YGOMD_LADD("ygomd_ladd"), YGOMD_PROMETHEAN("ygomd_promethean"), 
    YGOMD_SINGLUARITY("ygomd_singluarity"), YGOMD_VSSOUL("ygomd_vssoul"), YGOMD_KISIKILFROST("ygomd_kisikilfrost"), YGOMD_SANCTIFIRE("ygomd_sanctifire"), YGOMD_GOLDPRIDE("ygomd_goldpride"), YGOMD_SLIFER("ygomd_slifer"), YGOMD_WANTEDSIN("ygomd_wantedsin"), YGOMD_BEWD2ND("ygomd_bewd2nd"), 
    YGOMD_BONDUNITY("ygomd_bondunity"), YGOMD_PRIDESOUL("ygomd_pridesoul"), YGOMD_SHADDOLLFUSION("ygomd_shaddollfusion"), YGOMD_PERLEGIA("ygomd_perlegia"), YGOMD_NIGHTMARE("ygomd_nightmare"), YGOMD_IRISSWORD("ygomd_irissword"), YGOMD_CRIMSONDRA("ygomd_crimsondra"), YGOMD_CHARLES("ygomd_charles"), YGOMD_ZARC("ygomd_zarc"), 
    YGOMD_IMSETY("ygomd_imsety"), YGOMD_SCLETA("ygomd_scleta"), YGOMD_YUBELDEF("ygomd_yubeldef"), YGOMD_CENTURIONPRIM("ygomd_centurionprim"), YGOMD_MAGIA("ygomd_magia"), YGOMD_TRAPTRIXSERA("ygomd_traptrixsera"), YGOMD_DMG("ygomd_dmg"), YGOMD_DIABELLSTAR("ygomd_diabellstar"), YGOMD_GEPD("ygomd_gepd"), 
    YGOMD_CARDIANCURTAIN("ygomd_cardiancurtain"), YGOMD_MADALEISTER("ygomd_madaleister"), YGOMD_CARDIANZEBRA("ygomd_cardianzebra"), YGOMD_RAGNARAIKASTAG("ygomd_ragnaraikastag"), YGOMD_STARDUSTDRA("ygomd_stardustdra"), YGOMD_JUNKWARRIOR("ygomd_junkwarrior"),
    YGOMD_MAXIMUS("ygomd_maximus"), YGOMD_LONGIRSU("ygomd_longirsu"), YGOMD_DREAMMIRROR("ygomd_dreammirror"), YGOMD_SIXSAMUNITED("ygomd_sixsamunited"), YGOMD_DANGERBIGFOOT("ygomd_dangerbigfoot"), YGOMD_NEPHTHYS("ygomd_nephthys"), YGOMD_UAPLAYMAKER("ygomd_uaplaymaker"), YGOMD_PLUNDERBLACKBEARD("ygomd_plunderblackbeard"), 
    YGOMD_BUJINTEI("ygomd_bujintei"), YGOMD_CATASTOR("ygomd_catastor"), YGOMD_ABYSSMEGALO("ygomd_abyssmegalo"), YGOMD_BEETROOPERATLAS("ygomd_beetrooperatlas"), YGOMD_REVENDREAD("ygomd_revendread"), YGOMD_GHOSTRICKALUCARD("ygomd_ghostrickalucard"), YGOMD_MAYAKASHIYOKO("ygomd_mayakashiyoko"), YGOMD_LEGENDSIXSAM("ygomd_legendsixsam"), 
    YGOMD_GENEXCONTROLLER("ygomd_genexcontroller"), YGOMD_MYUTANT("ygomd_myutant"), YGOMD_STARRYDRAGON("ygomd_starrydragon"), YGOMD_AVRAMAX("ygomd_avramax"), YGOMD_DINGIRSU("ygomd_dingirsu"), YGOMD_SFORCE("ygomd_sforce"), YGOMD_RIKKAQUEEN("ygomd_rikkaqueen"), YGOMD_SUBTERROR("ygomd_subterror"), 
    YGOMD_TENYIMASTERS("ygomd_tenyimasters"), YGOMD_GOTTOMS("ygomd_gottoms"), YGOMD_ELDLIXIR("ygomd_eldlixir"), YGOMD_LEODRAKE("ygomd_leodrake"), YGOMD_FABLEDLEVIA("ygomd_fabledlevia"), YGOMD_AOJMARSHAL("ygomd_aojmarshal"),
    YGOMD_DXRAYE("ygomd_dxraye"), YGOMD_DXKAGARI("ygomd_dxkagari"), YGOMD_DXNO62("ygomd_dxno62"), YGOMD_DXNOC62("ygomd_dxnoc62"), YGOMD_DXROZE("ygomd_dxroze"), YGOMD_DXZEKE("ygomd_dxzeke"), YGOMD_YGOCHRONICLES("ygomd_ygochronicles"),
    CREEPER_LOGO("creeper_logo"), CREEPER_LOGO_LEGACY("creeper_logo_legacy"), COPPER_CREEPER("copper_creeper"), HL_KRONII_2023("hl_kronii_2023"), MAU_BLUE("mau_blue"), MAU_PINK("mau_pink"), MAU_BI("mau_bi"), VERMIN("vermin");
    
    public static final CardSleevesType[] VALUES = CardSleevesType.values();
    
    public static CardSleevesType getFromIndex(int index)
    {
        return CardSleevesType.VALUES[index];
    }
    
    static
    {
        int index = 0;
        for(CardSleevesType duelPhase : CardSleevesType.VALUES)
        {
            duelPhase.index = index++;
        }
    }
    
    public final String name;
    private int index;
    
    CardSleevesType(String name)
    {
        this.name = name;
    }
    
    public boolean isCardBack()
    {
        return this == CARD_BACK;
    }
    
    public ResourceLocation getMainRL(int size)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + size + "/" + getResourceName() + ".png");
    }
    
    public ResourceLocation getItemModelRL(int size)
    {
        if(isCardBack())
        {
            return null;
        }
        else
        {
            return new ResourceLocation(YDM.MOD_ID, getResourceName() + "_" + size);
        }
    }
    
    public String getResourceName()
    {
        if(isCardBack())
        {
            return name;
        }
        else
        {
            return "sleeves_" + name;
        }
    }
    
    public Item getItem()
    {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(YDM.MOD_ID, getResourceName()));
    }
    
    public int getIndex()
    {
        return index;
    }
}
