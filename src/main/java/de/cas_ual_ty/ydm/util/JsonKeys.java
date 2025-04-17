package de.cas_ual_ty.ydm.util;

public class JsonKeys
{
    // general
    
    public static final String VERSION_ITERATION = "version_iteration";
    public static final String DB_ID = "id";
    public static final String DOWNLOAD_LINK = "download_link";
    
    // cards
    
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String ATTRIBUTE = "attribute";
    public static final String TEXT = "text";
    public static final String FLAVOR_TEXT = "flavor_text";
    public static final String TYPE = "type";
    public static final String IMAGES = "images";
    public static final String ARCHETYPES = "archetypes";
    public static final String TAGS = "tags";
    public static final String KEYWORDS = "keywords";
    public static final String DESIGNERS = "designers";
    
    // card limitations/legality
    public static final String IS_ILLEGAL = "is_illegal";
    public static final String IS_CUSTOM = "is_custom";
    public static final String IS_ANIME = "is_anime";
    public static final String IS_RUSH = "is_rush";
    public static final String IS_SPEED = "is_speed";
    public static final String IS_LEGEND = "is_legend";
    public static final String LIMIT = "limit";
    public static final String IS_LIMIT_SHARED = "is_limit_shared";
    
    // under consideration for further card design
    //public static final String DURABILITY = "durability";
    //public static final String TURNS = "turns";
    //public static final String DURATION = "duration";
    //public static final String LP = "lp";
    //public static final String MANA = "mana";

    // type = "Spell"
    public static final String SPELL_TYPE = "spell_type";
    
    // type = "Trap"
    public static final String TRAP_TYPE = "trap_type";
    
    // type = "Monster"
    public static final String ATK = "atk";
    public static final String SPECIES = "species";
    public static final String MONSTER_TYPE = "monster_type";
    public static final String IS_PENDULUM = "is_pendulum";
    public static final String ABILITY = "ability";
    public static final String HAS_EFFECT = "has_effect";
    public static final String IS_DECKMASTER = "is_deckmaster";
    public static final String IS_EVOLUTION = "is_evolution";
    
    // type = "Monster" & monster_type = ""/"Ritual"/"Fusion"/"Synchro"/"Xyz"
    public static final String DEF = "def";
    
    // type = "Monster" & monster_type = ""/"Ritual"/"Fusion"/"Synchro"
    public static final String LEVEL = "level";
    public static final String IS_TUNER = "is_tuner";
    
    // type = "Monster" & monster_type = "Xyz"
    public static final String RANK = "rank";
    
    // type = "Monster" & monster_type = "Link"
    // TODO: Make Link/Link Arrows a more generic mechanic for Spell, Trap and Skill Cards.
    // public static final String IS_LINK = "is_link";
    public static final String LINK_RATING = "link_rating";
    public static final String LINK_ARROWS = "link_arrows";
    
    // type = "Monster" & is_pendulum = true
    public static final String PENDULUM_TEXT = "pendulum_text";
    public static final String PENDULUM_SCALE_LEFT_BLUE = "pendulum_scale_left_blue";
    public static final String PENDULUM_SCALE_RIGHT_RED = "pendulum_scale_right_red";
    
    // type = "Monster" & monster_type = "Maximum"
    // public static final String IS_MAXIMUM = "is_maximum";
    public static final String IS_MAXIMUM_CENTER = "is_maximum_center";
    public static final String MAXIMUM_ATK = "maximum_atk";
    
    // type = "Monster" & is_deckmaster = true
    public static final String DECKMASTER_TEXT = "deckmaster_text";
    
    // type = "Monster" & is_evolution = true
    // Evolution Monsters are like Pendulums, as in they can go over Fusions, Normal and Effect Monsters.
    public static final String EVOLUTION_TEXT = "evolution_text";
    public static final String EVOLUTION_STAGE = "evolution_stage";
    //public static final String PREVIOUS_STAGE = "previous_stage";
    
    // type = "Skill"
    public static final String SKILL_TYPE = "skill_type";
    public static final String CHARACTER = "character";
    public static final String SKILL_ACTIVATION = "skill_activation";
    public static final String SKILL_EFFECT = "skill_effect";
    
    // isRush = true
    public static final String RUSH_REQUIREMENT_TEXT = "rush_requirement_text";
    public static final String RUSH_EFFECT_TYPE = "rush_effect_type";
    public static final String RUSH_EFFECT_TEXT = "rush_effect_text";
    
    // type = "Material"
    // TODO: What unique JSON Keys would Material cards need?
    public static final String MATERIAL_TYPE = "material_type";
    
    // type = "Info"
    // TODO: What unique JSON Keys would Info cards need?
    public static final String INFO_TYPE = "info_type";
    
    // sets and set entries
    
    public static final String CODE = "code";
    public static final String DATE = "date";
    public static final String IMAGE = "image";
    public static final String PULL_TYPE = "pull_type";
    public static final String IMAGE_INDEX = "image_index";
    public static final String RARITY = "rarity";
    public static final String CARDS = "cards";
    public static final String DISTRIBUTION = "distribution";
    public static final String SUB_SETS = "sub_sets";
    
    // distribution
    
    public static final String PULLS = "pulls";
    public static final String WEIGHT = "weight";
    public static final String ENTRIES = "entries";
    public static final String RARITIES = "rarities";
    public static final String COUNT = "count";
    
    // rarities
    
    public static final String LAYERS = "layers";
    
    // sleeves
    // TODO: Make sleeves use these JSON Keys
    // Use NAME String from cards
    // Use CODE String from sets
    // Use IMAGE String from sets
    // Use TYPE String from cards
    // Use DESIGNER String from cards
    public static final String THEME = "theme";
    // Use TEXT String from cards
    
    // other
    
    public static final String UUID = "uuid";
}
