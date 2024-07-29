package com.project1.project1.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;

public interface GoogleCalendarService {
    CalendarList getList() throws IOException;
    boolean createCalendar() throws IOException;
    boolean deleteCalendar() throws IOException;
    List<Event> getEvent() throws IOException;
    boolean insertEvent() throws IOException;
    boolean deleteEvent() throws IOException;
    boolean updateEvent() throws IOException;
    ResponseEntity<Object> getToken(String code) throws IOException;
    ResponseEntity<Object> getAuth() throws GeneralSecurityException, IOException;
}
