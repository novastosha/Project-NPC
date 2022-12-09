package net.zoda.npc.skins.test;

import net.zoda.npc.skinloader.image.generator.MineskinSkinGenerator;
import net.zoda.npc.skinloader.utils.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Pair<String,String> str = new MineskinSkinGenerator("","").generate(new FileInputStream("../a5b1e089e6a6df45.png"),true);

        System.out.println("Value: "+str.a());
        System.out.println("Signature: "+str.b());
    }

}
