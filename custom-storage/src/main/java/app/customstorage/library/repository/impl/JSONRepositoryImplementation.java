package app.customstorage.library.repository.impl;

import app.customstorage.library.io.FileHandler;
import app.customstorage.library.repository.JSONRepository;

import java.util.List;

public class JSONRepositoryImplementation<Type, ID> implements JSONRepository<Type, ID> {

//    private FileHandler<JSONType> fileHandler;

    @Override
    public Type takeById(ID id) {
        return null;
    }

    @Override
    public List<Type> takeAll() {
        return null;
    }

    @Override
    public Type add() {
        return null;
    }
}
