package br.com.jops425.dsp20191.aulas0912.ap;

import java.util.List;

public class Students {

    private String matricula;

    private String firstname;

    private String lastname;

    private String nickname;

    private List<String> aulaFreq;

    private List<String> aulaNum;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getAulaFreq() {
        return aulaFreq;
    }

    public void setAulaFreq(List<String> aulaFreq) {
        this.aulaFreq = aulaFreq;
    }

    public List<String> getAulaNum() {
        return aulaNum;
    }

    public void setAulaNum(List<String> aulaNum) {
        this.aulaNum = aulaNum;
    }


}
