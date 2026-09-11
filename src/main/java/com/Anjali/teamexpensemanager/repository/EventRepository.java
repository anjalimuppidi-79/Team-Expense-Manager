package com.Anjali.teamexpensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Anjali.teamexpensemanager.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
