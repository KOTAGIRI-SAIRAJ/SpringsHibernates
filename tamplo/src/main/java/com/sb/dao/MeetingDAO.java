package com.sb.dao;


import com.sb.model.Meeting;

import java.util.List;

public interface MeetingDAO {

    public void addMeeting(Meeting meeting);

    public List<Meeting> getAllMeeting();

    public void deleteMeeting(Integer meetingId);

    public Meeting updateMeeting(Meeting meeting);

    public Meeting getMeeting(int meetingId);
}
