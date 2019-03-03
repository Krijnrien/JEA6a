package dao.Implementation;

import dao.JPA;
import dao.ILikesDao;
import domain.Kwet;
import domain.Like;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@JPA
public class LikeDao extends DaoManager<Like> implements ILikesDao {

    private Class<Kwet> type;

    public List<Like> getAllLikesOfKwet(Long id) {
        Kwet kwet = em.find(type, id);
        TypedQuery<Like> query = em.createNamedQuery("like.getAllLikesOfKwet", Like.class);
        query.setParameter("kwet", kwet);
        return query.getResultList();
    }


    public List<Like> getAllLikedAccountsOfKwet(Long id) {
        Kwet kwet = em.find(type, id);
        TypedQuery<Like> query = em.createNamedQuery("like.getAllAccountsThatLikedKwet", Like.class);
        query.setParameter("kwet", kwet);
        return query.getResultList();
    }
}
