package dao.Implementation;

import dao.JPA;
import dao.IKwetDao;
import domain.Account;
import domain.Kwet;
import domain.Like;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class KwetDao extends DaoManager<Kwet> implements IKwetDao {

    @Override
    public List<Kwet> findMessagesByUsername(String userName) {
        TypedQuery<Kwet> query = em.createNamedQuery("message.findKwetByName", Kwet.class);
        query.setParameter("name", userName);
        return query.getResultList();
    }

    @Override
    public List<Kwet> findMessagesLikeText(String text) {
        TypedQuery<Kwet> query = em.createNamedQuery("message.findKwetByText", Kwet.class);
        query.setParameter("text", text);
        return query.getResultList();
    }

    @Override
    public Kwet addAccount(Kwet kwet, Account account) {
        kwet.setOwner(account);
        em.persist(kwet);

        ArrayList<Kwet> kwets = new ArrayList<>();
        kwets.add(kwet);
        account.setKwets(kwets);
        em.persist(account);
        return kwet;
    }

    @Override
    public Kwet addLike(Kwet kwet, Like like) {
        ArrayList<Like> likes = new ArrayList<>();
        likes.add(like);
        kwet.setLikes(likes);
        em.persist(kwet);
        like.setLiked(kwet);
        em.persist(like);
        return kwet;
    }
}
