package de.cas_ual_ty.ydm.clientutil;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

@SuppressWarnings("deprecation")
public class SleeveBakedModel implements IBakedModel
{
    private IBakedModel mainModel;
    private ItemOverrideList overrideList;
    
    public SleeveBakedModel(IBakedModel mainModel)
    {
        this.mainModel = mainModel;
        overrideList = new SleeveOverrideList(new FinalSleeveBakedModel(mainModel));
    }
    
    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction side, Random rand)
    {
        return mainModel.getQuads(state, side, rand);
    }
    
    @Override
    public boolean useAmbientOcclusion()
    {
        return mainModel.useAmbientOcclusion();
    }
    
    @Override
    public boolean isGui3d()
    {
        return mainModel.isGui3d();
    }
    
    @Override
    public boolean usesBlockLight()
    {
        return mainModel.usesBlockLight();
    }
    
    @Override
    public boolean isCustomRenderer()
    {
        return mainModel.isCustomRenderer();
    }
    
    @Override
    public TextureAtlasSprite getParticleIcon()
    {
        return mainModel.getParticleIcon();
    }
    
    @Override
    public ItemOverrideList getOverrides()
    {
        return overrideList;
    }
    
    private static class SleeveOverrideList extends ItemOverrideList
    {
        private FinalSleeveBakedModel finalModel;
        
        public SleeveOverrideList(FinalSleeveBakedModel finalModel)
        {
            this.finalModel = finalModel;
        }
        
        @Override
        public IBakedModel resolve(IBakedModel model, ItemStack stack, ClientWorld worldIn, LivingEntity entityIn)
        {
            return finalModel.setActiveItemStack(stack);
        }
    }
}