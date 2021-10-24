package net.linkle.valley.Registry.Blocks.Decorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;

public class NetherSaltBlock extends OreBlock {

    public NetherSaltBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES)
                .breakByHand(false)
                .sounds(BlockSoundGroup.STONE)
                .strength(1, 3f).requiresTool());
    }
}
