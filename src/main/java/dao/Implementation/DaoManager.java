package dao.Implementation;

import dao.IDaoManager;
import dao.JPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

@Stateless
@JPA
public class DaoManager<T> implements IDaoManager<T> {

    @PersistenceContext(unitName = "KwetterPU")
    protected EntityManager em;

    private Class<T> type;

    public DaoManager() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    public T add(T object) {
        this.em.persist(object);
        return object;
    }

    @Override
    public void delete(T t) {
        t = em.merge(t);
        em.remove(t);
    }

    public void deleteById(Long id) {
        this.delete(findById(id));
    }

    @Override
    public T findById(Long id) {
        return em.find(type, id);
    }

    @Override
    public T findObject(T object) {
        return em.find(type, object);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}

