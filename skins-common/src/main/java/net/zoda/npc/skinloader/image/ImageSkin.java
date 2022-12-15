package net.zoda.npc.skinloader.image;

import net.zoda.npc.skinloader.data.SkinData;

import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import java.net.URL;

public class ImageSkin implements SkinData {

    private final InputStream image;

    public ImageSkin(InputStream image) throws IOException {
        this.image = image;

    }

    public ImageSkin(URL url) throws IOException {
        this(url.openStream());
    }

    public ImageSkin(File file) throws IOException {
        this(new FileInputStream(file));
    }

    @Override
    public String texture() {
        return null;
    }

    @Override
    public String signature() {
        return null;
    }
}
