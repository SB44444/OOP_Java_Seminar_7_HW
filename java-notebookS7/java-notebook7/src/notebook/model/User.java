package notebook.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String myHeadline;
    private String myText;
    private String myComment;
    private final LocalDateTime putDate;
    private LocalDateTime reDate;

    public User(Long id, String myHeadline, String myText, String myComment, LocalDateTime putDate, LocalDateTime reDate) {
        this.id = id;
        this.myHeadline = myHeadline;
        this.myText = myText;
        this.myComment = myComment;
        this.putDate = putDate;
        this.reDate = reDate;
    }

    public User(Long id, String myHeadline, String myText, String myComment) {
        this(id, myHeadline, myText, myComment, LocalDateTime.now(), LocalDateTime.now() );
    }

    public User(String myHeadline, String myText, String myComment) {
        this(null, myHeadline, myText, myComment);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyHeadline() {
        return myHeadline;
    }

    public void setMyHeadline(String myHeadline) {
        this.myHeadline = myHeadline;
    }

    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    public String getMyComment() {
        return myComment;
    }

    public void setMyComment(String myComment) {
        this.myComment = myComment;
    }

    public LocalDateTime getPutDate() {
        return putDate;
    }

    public LocalDateTime getReDate() {
        return reDate;
    }

    public void setReDate(LocalDateTime reDate) {
        this.reDate = reDate;
    }

    @Override
    public String toString() {
        String format;
        format = String.format("\nText ID: %s\nHeadline: %s\nText: %s\nComment: %s\nDate Writing: %s\nDate Changing: %s",
                id, myHeadline, myText, myComment, putDate, reDate);
        return format;
    }
}
