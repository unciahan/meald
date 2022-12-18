package dotori.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
@Getter : [Lombok] generate getter method for all fields
@MappedSuperclass : [JPA] apply mapping only to its subclasses, since no table exists for superclass
@EntityListeners : [JPA] specify callback class
AuditingEntityListener.class : class for auditing feature
@CreatedDate : declare created date field
@LastModifiedDate : declare modified date field
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
