package ir.sheikhoo.url_shortener.modules.link.service;

import ir.sheikhoo.url_shortener.modules.link.model.Links;
import ir.sheikhoo.url_shortener.modules.link.repository.LinkRepository;
import ir.sheikhoo.url_shortener.modules.user.model.Users;
import ir.sheikhoo.url_shortener.modules.user.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.List;
import java.util.Random;

@Service
public class LinkeService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkeService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }



    public List<Links> findAll() {
        return linkRepository.findAll();
    }

    public void addLink(Links links) {
        linkRepository.save(links);
    }

    public long numberLink() {
        return linkRepository.count();
    }

    public long numberClick() {
        return linkRepository.numberClick();
    }




    public Links shortenUrl(String url, Users users) {
        Links links=new Links();

        String generatedString = RandomStringUtils.randomAlphanumeric(6);

        links.setShort_url(generatedString);
        links.setTarget_url(url);
        links.setUser(users);

        return linkRepository.save(links);
    }

    public Links shortenUrl_(String url) {
        Links links=new Links();

        String generatedString = RandomStringUtils.randomAlphanumeric(6);

        links.setShort_url(generatedString);
        links.setTarget_url(url);

        return linkRepository.save(links);
    }

    public Links getLink(String short_url) {
        return linkRepository.getLink(short_url);
    }

    public void editeLink(Links links) {
        linkRepository.save(links);
    }

    public List<Links> getLatestLinks(int limit) {
        return linkRepository.getLatestLinks(limit);
    }

    public List<Links> getPopularLinks(int limit) {
        return linkRepository.getPopularLinks(limit);
    }

    public List<Links> getUserLink(String email) {
        return linkRepository.findUserLink(email);
    }

    public void deleteLink(int id) {
        linkRepository.deleteById(id);
    }
}
