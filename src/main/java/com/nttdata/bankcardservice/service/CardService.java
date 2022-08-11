package com.nttdata.bankcardservice.service;

import com.nttdata.bankcardservice.model.document.Card;
import com.nttdata.bankcardservice.model.repository.ICardRepository;
import com.nttdata.bankcardservice.model.service.ICardService;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Card Service.
 *
 * @author jmacoele
 *
 */

@Service
public class CardService implements ICardService {

  @Autowired
  private ICardRepository creditRepository;

  @Override
  public Mono<Card> findById(String id) {
    return this.creditRepository.findById(id)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Flux<Card> findAll() {
    return this.creditRepository.findAll()
        .switchIfEmpty(Flux.empty());
  }

  @Override
  public Mono<Card> save(Card card) throws Exception {
    card.setId(UUID.randomUUID().toString());
    return this.creditRepository.save(card);
  }

  @Override
  public Mono<Card> save(String id, Card card)
      throws Exception {
    return this.creditRepository.save(card);
  }

  @Override
  public Mono<Card> delete(String id) {
    final Mono<Card> credit = findById(id);
    if (Objects.isNull(credit)) {
      return Mono.empty();
    }
    return findById(id).switchIfEmpty(Mono.empty())
        .filter(Objects::nonNull)
        .flatMap(creditToBeDeleted -> this.creditRepository
            .delete(creditToBeDeleted)
            .then(Mono.just(creditToBeDeleted)));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return this.creditRepository.existsById(id);
  }
}
