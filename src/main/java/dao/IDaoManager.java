package dao;


public interface IDaoManager<T> {

    T add(T object);

    void delete(T object);

    void deleteById(Long id);

    T findById(Long id);

    T findObject(T object);
}
