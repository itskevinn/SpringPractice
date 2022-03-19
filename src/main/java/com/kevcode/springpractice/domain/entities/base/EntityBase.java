package com.kevcode.springpractice.domain.entities.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.util.UUID;

@Entity
@Inheritance
  public class EntityBase {
    @Id
    protected UUID Id;

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getId() {
        return Id;
    }
}
