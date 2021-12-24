package com.example.shoppingcartservice.data;

import java.io.Serializable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author yangck
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

  @LastModifiedDate
  private Long lastModified;
  @CreatedDate
  private Long createdAt;

  public Long getLastModified() {
    return lastModified;
  }

  public void setLastModified(Long lastModified) {
    this.lastModified = lastModified;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
        "lastModified=" + lastModified +
        ", createdAt=" + createdAt +
        '}';
  }
}
