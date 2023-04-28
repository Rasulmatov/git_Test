package uz.isystem.telegram.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.telegram.bot.model.BotUser;

@Repository
public interface UserRepository extends JpaRepository<BotUser,Integer> {

}
