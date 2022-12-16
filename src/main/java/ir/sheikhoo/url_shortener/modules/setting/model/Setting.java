package ir.sheikhoo.url_shortener.modules.setting.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Setting {

    @Id
    private int id=1;

    private String site_title="Url Shortener";
    private String site_discription="";
    private String about_us="";
    private String copyright="";

    private String site_url="https://localhost:8080";

    private String location="";
    private String tel="";
    private String email="";
    private String instagram="";
    private String facebook="";
    private String twitter="";
    private String linkedin="";

    private int numberLinks=10;

    public Setting() {
    }

    public Setting(String site_url,String site_title, String site_discription, String about_us, String copyright, String location, String tel, String email, String instagram, String facebook, String twitter, String linkedin) {
        this.site_url=site_url;
        this.site_title = site_title;
        this.site_discription = site_discription;
        this.about_us = about_us;
        this.copyright = copyright;
        this.location = location;
        this.tel = tel;
        this.email = email;
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite_title() {
        return site_title;
    }

    public void setSite_title(String site_title) {
        this.site_title = site_title;
    }

    public String getSite_discription() {
        return site_discription;
    }

    public void setSite_discription(String site_discription) {
        this.site_discription = site_discription;
    }

    public String getAbout_us() {
        return about_us;
    }

    public void setAbout_us(String about_us) {
        this.about_us = about_us;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public int getNumberLinks() {
        return numberLinks;
    }

    public void setNumberLinks(int numberLinks) {
        this.numberLinks = numberLinks;
    }
}
