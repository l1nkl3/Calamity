package net.linkle.valley.Registry.Blocks.Decorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BookshelfBlock extends Block {

    public BookshelfBlock() {
        super(FabricBlockSettings.of(Material.WOOD)
                .breakByTool(FabricToolTags.AXES)
                .breakByHand(true)
                .sounds(BlockSoundGroup.WOOD)
                .strength(2, 2f));
    }
}
