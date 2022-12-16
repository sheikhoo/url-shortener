package ir.sheikhoo.url_shortener.modules.link.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.sheikhoo.url_shortener.modules.user.model.Users;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Links {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "لطفا، لینک مورد نظر را وارد نمایید.")
    private String target_url;

    @NotNull
    private String short_url;

    private long click=0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users user;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime create_at;

    public Links() {
    }

    public Links(@NotNull(message = "لطفا، لینک مورد نظر را وارد نمایید.") String target_url, @NotNull String short_url) {
        this.target_url = target_url;
        this.short_url = short_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarget_url() {
        return target_url;
    }

    public void setTarget_url(String target_url) {
        this.target_url = target_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public long getClick() {
        return click;
    }

    public void setClick(long click) {
        this.click = click;
    }
}
