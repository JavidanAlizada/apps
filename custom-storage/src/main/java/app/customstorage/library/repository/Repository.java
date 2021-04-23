package app.customstorage.library.repository;

import java.util.List;

public interface Repository<Type, ID> {

    Type takeById(ID id);

    List<Type> takeAll();

    Type add();

}
