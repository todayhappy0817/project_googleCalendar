package com.project1.project1.service.impl;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.project1.project1.service.GoogleCalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GoogleCalendarServiceImpl implements GoogleCalendarService {

    @Override
    public CalendarList getList() throws IOException {
        return null;
    }

    @Override
    public boolean createCalendar() throws IOException {
        return false;
    }

    @Override
    public boolean deleteCalendar() throws IOException {
        return false;
    }

    @Override
    public List<Event> getEvent() throws IOException {
        return List.of();
    }

    @Override
    public boolean insertEvent() throws IOException {
        return false;
    }

    @Override
    public boolean deleteEvent() throws IOException {
        return false;
    }

    @Override
    public boolean updateEvent() throws IOException {
        return false;
    }

    @Override
    public ResponseEntity<Object> getToken(String code) throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAuth() throws GeneralSecurityException, IOException {
        return null;
    }
}
