package net.zoda.npc.skinloader.image.generator;

import net.zoda.npc.skinloader.utils.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * The current and only implementation is {@link MineskinSkinGenerator}
 */
public interface SkinGenerator {
    Pair<String,String> generate(InputStream skin,boolean slim) throws IOException;

    Map<InputStream,Pair<String,String>> cache();
}
