package pl.qubiak.netflixuser.Model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class UserModel {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    private String userName;
    private Date endOfSubscripcionDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName(String userName) {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getEndOfSubscripcionDate(java.sql.Date endOfSubscripcionDate) {
        return this.endOfSubscripcionDate;
    }

    public void setEndOfSubscripcionDate(Date endOfSubscripcionDate) {
        this.endOfSubscripcionDate = endOfSubscripcionDate;
    }
}
