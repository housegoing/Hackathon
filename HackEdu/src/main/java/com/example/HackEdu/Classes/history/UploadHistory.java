package com.example.HackEdu.Classes.history;

import java.time.LocalDate;

public class UploadHistory {
    private String id;
    private LocalDate dateAccess;
    private String contentId;

    public UploadHistory() {
    }

    public UploadHistory(String id, LocalDate dateAccess, String contentId) {
        this.id = id;
        this.dateAccess = dateAccess;
        this.contentId = contentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateAccess() {
        return dateAccess;
    }

    public void setDateAccess(LocalDate dateAccess) {
        this.dateAccess = dateAccess;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
