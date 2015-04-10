/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package radiobuttons;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Abednigo
 */
@Entity
@Table(name = "ASSIGN2")
@NamedQueries({
    @NamedQuery(name = "Assign2.findAll", query = "SELECT a FROM Assign2 a"),
    @NamedQuery(name = "Assign2.findByTeamname", query = "SELECT a FROM Assign2 a WHERE a.teamname = :teamname"),
    @NamedQuery(name = "Assign2.findByTechnicalscore", query = "SELECT a FROM Assign2 a WHERE a.technicalscore = :technicalscore"),
    @NamedQuery(name = "Assign2.findByUsefullscore", query = "SELECT a FROM Assign2 a WHERE a.usefullscore = :usefullscore"),
    @NamedQuery(name = "Assign2.findByOverallscore", query = "SELECT a FROM Assign2 a WHERE a.overallscore = :overallscore"),
    @NamedQuery(name = "Assign2.findByClarityscore", query = "SELECT a FROM Assign2 a WHERE a.clarityscore = :clarityscore"),
    @NamedQuery(name = "Assign2.findByAveragescore", query = "SELECT a FROM Assign2 a WHERE a.averagescore = :averagescore"),
    @NamedQuery(name = "Assign2.findByComments", query = "SELECT a FROM Assign2 a WHERE a.comments = :comments")})
public class Assign2 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TEAMNAME")
    private String teamname;
    @Column(name = "TECHNICALSCORE")
    private Integer technicalscore;
    @Column(name = "USEFULLSCORE")
    private Integer usefullscore;
    @Column(name = "OVERALLSCORE")
    private Integer overallscore;
    @Column(name = "CLARITYSCORE")
    private Integer clarityscore;
    @Column(name = "AVERAGESCORE")
    private String averagescore;
    @Column(name = "COMMENTS")
    private String comments;

    public Assign2() {
    }

    public Assign2(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        String oldTeamname = this.teamname;
        this.teamname = teamname;
        changeSupport.firePropertyChange("teamname", oldTeamname, teamname);
    }

    public Integer getTechnicalscore() {
        return technicalscore;
    }

    public void setTechnicalscore(Integer technicalscore) {
        Integer oldTechnicalscore = this.technicalscore;
        this.technicalscore = technicalscore;
        changeSupport.firePropertyChange("technicalscore", oldTechnicalscore, technicalscore);
    }

    public Integer getUsefullscore() {
        return usefullscore;
    }

    public void setUsefullscore(Integer usefullscore) {
        Integer oldUsefullscore = this.usefullscore;
        this.usefullscore = usefullscore;
        changeSupport.firePropertyChange("usefullscore", oldUsefullscore, usefullscore);
    }

    public Integer getOverallscore() {
        return overallscore;
    }

    public void setOverallscore(Integer overallscore) {
        Integer oldOverallscore = this.overallscore;
        this.overallscore = overallscore;
        changeSupport.firePropertyChange("overallscore", oldOverallscore, overallscore);
    }

    public Integer getClarityscore() {
        return clarityscore;
    }

    public void setClarityscore(Integer clarityscore) {
        Integer oldClarityscore = this.clarityscore;
        this.clarityscore = clarityscore;
        changeSupport.firePropertyChange("clarityscore", oldClarityscore, clarityscore);
    }

    public String getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(String averagescore) {
        String oldAveragescore = this.averagescore;
        this.averagescore = averagescore;
        changeSupport.firePropertyChange("averagescore", oldAveragescore, averagescore);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        String oldComments = this.comments;
        this.comments = comments;
        changeSupport.firePropertyChange("comments", oldComments, comments);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamname != null ? teamname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assign2)) {
            return false;
        }
        Assign2 other = (Assign2) object;
        if ((this.teamname == null && other.teamname != null) || (this.teamname != null && !this.teamname.equals(other.teamname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "radiobuttons.Assign2[ teamname=" + teamname + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
