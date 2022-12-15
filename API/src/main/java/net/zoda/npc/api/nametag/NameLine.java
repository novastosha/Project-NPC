package net.zoda.npc.api.nametag;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.api.viewer.NPCViewer;

import java.util.function.Function;

@RequiredArgsConstructor
public final class NameLine {

    @Getter private final Function<NPCViewer<?>,String> text;
    @Getter private final double spacing;

    public NameLine(String staticText, double spacing) {
        this((npcViewer -> staticText),spacing);
    }

    public NameLine(String staticText) {
        this(staticText,0);
    }

    public NameLine(Function<NPCViewer<?>,String> text) {
        this(text,0);
    }
}
