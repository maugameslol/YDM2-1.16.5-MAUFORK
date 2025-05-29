package de.cas_ual_ty.ydm.block;

import de.cas_ual_ty.ydm.YDM;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

public class CardDecrafterBlock extends Block
{
	public static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container." + YDM.MOD_ID + ".card_decrafter");
	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);
	
	public CardDecrafterBlock(Properties properties) 
	{
		super(properties);
	}
	
	@Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return defaultBlockState().setValue(HorizontalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }
    
    
	//TODO: Implement functionality
	
	
	@Override
	public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) 
	{
		return SHAPE;
	}
	
	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) 
	{
		return true;
	}
	
	@Override
    public BlockRenderType getRenderShape(BlockState state)
    {
        return BlockRenderType.MODEL;
    }
	
	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) 
	{
		return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) 
	{
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}
	
	@Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HorizontalBlock.FACING);
    }
	
	@Override
	public boolean isPathfindable(BlockState pState, IBlockReader pLevel, BlockPos pPos, PathType pType) 
	{
	      return false;
	}
}