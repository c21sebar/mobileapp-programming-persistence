package com.example.persistence;

public class UserModel {
    private String id = "id";
    private String fornamn ="Förnamn";
    private String efternamn = "Efternamn";
    private int telNR= 0;
    private String mailadress = "Mailadress";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public int getTelNR() {
        return telNR;
    }

    public void setTelNR(int telNR) {
        this.telNR = telNR;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

    public UserModel(String id, String fornamn, String efternamn, int telNR, String mailadress) {
        this.id = id;
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.telNR = telNR;
        this.mailadress = mailadress;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", fornamn='" + fornamn + '\'' +
                ", efternamn='" + efternamn + '\'' +
                ", telNR=" + telNR +
                ", mailadress='" + mailadress + '\'' +
                '}' + "\n" + "\n";
    }
}
