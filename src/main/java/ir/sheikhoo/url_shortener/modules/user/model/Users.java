package ir.sheikhoo.url_shortener.modules.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.sheikhoo.url_shortener.enums.Roles;
import ir.sheikhoo.url_shortener.modules.link.model.Links;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users  implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Email(message = "فرمت ایمیل صحیح نمی باشد.")
    @NotNull(message = "لطفا، ایمیل را وارد نمایید.")
    private String username;

    //@Size(min = 5,max = 250,message = "رمز عبور باید بین 5 تا 50 کارکتر باشد.")
    @NotNull(message = "لطفا، رمزعبور را وارد نمایید.")
    private String password;

    @NotNull(message = "لطفا، نام و نام خانوادگی را وارد نمایید.")
    private String name;

    private boolean enabled=true;

    @NotNull(message = "لطفا، نوع کاربری را وارد نمایید.")
    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "authorities",joinColumns =
    @JoinColumn(name = "username",referencedColumnName = "username"))
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private List<Roles> role;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime create_at;

    @OneToMany(mappedBy = "user")
    private List<Links> linkes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users() {
    }

    public Users(@Email(message = "فرمت ایمیل صحیح نمی باشد.") @NotNull(message = "لطفا، ایمیل را وارد نمایید.") String username, @Size(min = 5, max = 50, message = "رمز عبور باید بین 5 تا 50 کارکتر باشد.") @NotNull(message = "لطفا، رمزعبور را وارد نمایید.") String password, @NotNull(message = "لطفا، نام و نام خانوادگی را وارد نمایید.") String name, boolean enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Roles> getRole() {
        return role;
    }

    public void setRole(List<Roles> role) {
        this.role = role;
    }

    public List<Links> getLinkes() {
        return linkes;
    }

    public void setLinkes(List<Links> linkes) {
        this.linkes = linkes;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
