package me.mwcheon.stream;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;
    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        //ofNullable null일수도 있다. of는 널이 아닌값이다라는 확신
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
