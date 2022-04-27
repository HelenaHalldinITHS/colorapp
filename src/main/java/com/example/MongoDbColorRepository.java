package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MongoDbColorRepository implements ColorRepository {

    private final MongoDbConfiguration mongoConf;
    private final MongoClient mongoClient;

    public MongoDbColorRepository(MongoDbConfiguration mongoConf,
                                  MongoClient mongoClient) {
        this.mongoConf = mongoConf;
        this.mongoClient = mongoClient;
    }

    @Override
    public void save(@NonNull @NotNull @Valid Color color) {
        getCollection().insertOne(color);
    }

    @Override
    @NonNull
    public List<Color> list() {
        return getCollection().find().into(new ArrayList<>());
    }

    @NonNull
    private MongoCollection<Color> getCollection() {
        return mongoClient.getDatabase(mongoConf.getName())
                .getCollection(mongoConf.getCollection(), Color.class);
    }
}

