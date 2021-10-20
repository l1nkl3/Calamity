package net.linkle.valley.Registry.Blocks.Decorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ScaldingBlock extends MagmaBlock {
    public ScaldingBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES)
                .breakByHand(false).luminance(3)
                .sounds(BlockSoundGroup.STONE)
                .strength(2f, 1.5f));
    }
}
