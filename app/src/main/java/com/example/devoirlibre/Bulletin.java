package com.example.devoirlibre;

public class Bulletin {
    private String module;
    private Double note;

    public Bulletin(String module, Double note) {
        this.module = module;
        this.note = note;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
