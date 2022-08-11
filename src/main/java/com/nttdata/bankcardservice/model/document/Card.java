package com.nttdata.bankcardservice.model.document;

import com.nttdata.bankcardservice.model.document.type.CardTypeEnum;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Card Class.
 *
 * @author jmacoele
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "cards")
public class Card {

  @Id
  private String id;

  private CardTypeEnum cardType;

  private String number;

  private String ownerName;

  private LocalDateTime issueDate;

  private LocalDateTime dueDate;

  private String cvc;
  
  private String principalAccountId;

}
