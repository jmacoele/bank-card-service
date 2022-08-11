package com.nttdata.bankcardservice.api;

import com.nttdata.bankcardservice.model.document.Card;
import com.nttdata.bankcardservice.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Credit Service.
 *
 * @author jmacoele
 *
 */

@RestController
@RequestMapping("/cards")
@Slf4j
public class CardController {

  @Autowired
  private CardService cardService;

  @GetMapping
  @Operation(summary = "Get list of Cards")
  public Flux<Card> getAll() {
    log.info("getAll" + "OK");
    return cardService.findAll().log();
  }

  @GetMapping("{id}")
  @Operation(summary = "Get Card by Id")
  public Mono<Card> getById(@PathVariable("id") final String id) {
    log.info("getById: " + id);
    return cardService.findById(id).log();
  }

  @PutMapping("{id}")
  @Operation(summary = "Update Card by Id")
  public Mono<Card> updateById(@PathVariable("id") final String id,
      @RequestBody final Card card) throws Exception {
    log.info("update: " + id);
    return cardService.save(id, card).log();
  }

  @PostMapping (
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create Card")
  public Mono<Card> create(@RequestBody final Card card) throws Exception {
    log.info("create: " + card.getNumber());
    return cardService.save(card).log();
  }

  @DeleteMapping("{id}")
  @Operation(summary = "Delete Card")
  public Mono<Card> delete(@PathVariable final String id) {
    log.info("delete: " + id);
    return cardService.delete(id).log();
  }

  @GetMapping("/exists/{id}")
  @Operation(summary = "verify existence of Card")
  public Mono<Boolean> existsById(@PathVariable("id") final String id) {
    log.info("exists by: " + id);
    return cardService.existsById(id).log();
  }
}