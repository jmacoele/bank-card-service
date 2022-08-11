package com.nttdata.bankcardservice.model.service;

import com.nttdata.bankcardservice.model.document.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ICreditService Interface.
 *
 * @author jmacoele
 *
 */

public interface ICardService {

  Mono<Card> findById(String id);

  Flux<Card> findAll();

  Mono<Boolean> existsById(String id);

  Mono<Card> save(Card card) throws Exception;

  Mono<Card> save(String id, Card card) throws Exception;

  Mono<Card> delete(String id);

}
