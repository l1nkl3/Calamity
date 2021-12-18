package net.linkle.valley.Registry.Initializers.ConfiguredFeatures;

import static net.linkle.valley.Registry.Utils.Util.register;

import java.util.ArrayList;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.linkle.valley.ValleyMain;
import net.linkle.valley.Registry.Initializers.Plants;
import net.linkle.valley.Registry.Initializers.ConfiguredFeatures.Gen.CavePatchConfig;
import net.linkle.valley.Registry.Initializers.ConfiguredFeatures.Gen.CavePatchFeature;
import net.linkle.valley.Registry.Initializers.ConfiguredFeatures.Gen.GlowKelpFeature;
import net.linkle.valley.Registry.Utils.SimpleConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class CaveFeatures {
    /** Custom gen feature to spawn stuffs in caves. */
    private static final CavePatchFeature CAVE_PATCH = new CavePatchFeature();
    private static final GlowKelpFeature GLOW_KELP = new GlowKelpFeature();

    private static final ConfiguredFeature<?, ?> RED_PILE_PATCH_CONFIG = CAVE_PATCH
            .configure(new CavePatchConfig(Plants.RED_PILE.getDefaultState(), 20, 4, 6));
    
    private static final ConfiguredFeature<?, ?> SPIDER_EGG_PATCH_CONFIG = CAVE_PATCH
            .configure(new CavePatchConfig(Plants.SPIDER_EGG_BLOCK.getDefaultState(), 20, 4, 6));

    public static void initialize(SimpleConfig config) {
        if (config.get("disable-features-gen", false)) {
            return;
        }
        
        Registry.register(Registry.FEATURE, new Identifier(ValleyMain.MOD_ID, "cave_patch"), CAVE_PATCH);
        Registry.register(Registry.FEATURE, new Identifier(ValleyMain.MOD_ID, "glow_kelp"), GLOW_KELP);
        var underground = GenerationStep.Feature.UNDERGROUND_DECORATION;
        ArrayList<PlacementModifier> list;
        RegistryKey<PlacedFeature> place;
        
        list = new ArrayList<>();
        list.add(RarityFilterPlacementModifier.of(3));
        list.add(SquarePlacementModifier.of());
        list.add(HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0)));
        place = register("red_pile_patch_cave", RED_PILE_PATCH_CONFIG, list);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), underground, place);
        
        list = new ArrayList<>();
        list.add(RarityFilterPlacementModifier.of(4));
        list.add(SquarePlacementModifier.of());
        list.add(HeightRangePlacementModifier.uniform(YOffset.aboveBottom(24), YOffset.fixed(24)));
        place = register("spider_egg_patch_cave", SPIDER_EGG_PATCH_CONFIG, list);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), underground, place);
        
        list = new ArrayList<>();
        list.add(CountPlacementModifier.of(10));
        list.add(SquarePlacementModifier.of());
        list.add(HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.fixed(32)));
        place = register("glow_kelp_patch_cave", GLOW_KELP.configure(FeatureConfig.DEFAULT), list);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), underground, place);
    }
}
