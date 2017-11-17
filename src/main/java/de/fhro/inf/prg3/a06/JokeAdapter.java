package de.fhro.inf.prg3.a06;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.fhro.inf.prg3.a06.model.Joke;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;

/**
 * Created by Daniel Herzinger on 11/15/17.
 */
public class JokeAdapter extends TypeAdapter<Joke> {
    private final Gson gson = new Gson();

    @Override
    public void write(JsonWriter out, Joke value) throws IOException {
        return;
    }

    @Override
    public Joke read(JsonReader in) throws IOException {
        Joke joke = null;

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "type":
                    if (!in.nextString().equals("success")) throw new IOException();
                    break;
                case "value":
                    joke = gson.fromJson(in, Joke.class);
                    break;
            }
        }
        return joke;
    }
}

