package com.nttdata.bankcardservice.model.repository;

import com.nttdata.bankcardservice.model.document.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * ICreditRepository interface.
 *
 * @author jmacoele
 *
 */

@Repository
public interface ICardRepository
    extends ReactiveMongoRepository<Card, String> {

}
