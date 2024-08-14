package org.work.kafkaloggingservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.work.kafkaloggingservice.model.LogMessage;

@Repository
public interface LogMessageRepository extends CrudRepository<LogMessage, Long> {
}