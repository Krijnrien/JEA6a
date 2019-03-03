package dao;

import domain.Like;
import java.util.List;

public interface ILikesDao extends IDaoManager<Like> {

    List<Like> getAllLikesOfKwet(Long id);

    List<Like> getAllLikedAccountsOfKwet(Long id);


}
