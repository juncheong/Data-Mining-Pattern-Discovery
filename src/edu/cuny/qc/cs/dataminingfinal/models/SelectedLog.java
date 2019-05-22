package edu.cuny.qc.cs.dataminingfinal.models;

import java.sql.Timestamp;

public class SelectedLog {

    String memberId;
    String participantId;
    Timestamp time;
    String description;
    
    public SelectedLog(String memberId, String participantId, Timestamp time, String description) {
        this.memberId = memberId;
        this.participantId = participantId;
        this.time = time;
        this.description = description;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
    
    
}
