package net.zoda.npc.skinloader.image.generator;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.skinloader.utils.Pair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class MineskinSkinGenerator implements SkinGenerator {

    private final Map<InputStream, Pair<String, String>> cache =new HashMap<>();

    protected static final String UPLOAD_REQUEST_URL = "https://api.mineskin.org/generate/upload";

    private final String key, secret;

    @Override
    public Pair<String, String> generate(InputStream skin,boolean slim) throws IOException {
        if(cache.containsKey(skin)) return cache.get(skin);

        URL url = new URL(UPLOAD_REQUEST_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        /*// Add API key and secret
        connection.setRequestProperty("apiKey",key);
        connection.setRequestProperty("apiKey",key);*/

        String boundary = UUID.randomUUID().toString();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

        DataOutputStream request = new DataOutputStream(connection.getOutputStream());

        request.writeBytes("--" + boundary + "\r\n");
        request.writeBytes("Content-Disposition: form-data; name=\"description\"\r\n\r\n");
        request.writeBytes("file" + "\r\n");

        request.writeBytes("--" + boundary + "\r\n");
        request.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + "final.png" + "\"\r\n\r\n");
        request.write(skin.readAllBytes());
        request.writeBytes("\r\n");

        request.writeBytes("--" + boundary + "--\r\n");
        request.flush();

        int status = connection.getResponseCode();
        InputStreamReader streamReader;

        if (status > 299) {
            return new Pair<>("","");
        } else {
            streamReader = new InputStreamReader(connection.getInputStream());
        }

        JsonElement element = JsonParser.parseReader(streamReader);
        if(!(element instanceof JsonObject object)) {
            return new Pair<>("","");
        }

        JsonObject data = object.getAsJsonObject("data").getAsJsonObject("texture");

        return new Pair<>(data.get("value").getAsString(),data.get("signature").getAsString());
    }

    @Override
    public Map<InputStream, Pair<String, String>> cache() {
        return cache;
    }
}
