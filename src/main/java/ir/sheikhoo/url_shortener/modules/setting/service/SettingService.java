package ir.sheikhoo.url_shortener.modules.setting.service;

import ir.sheikhoo.url_shortener.modules.setting.model.Setting;
import ir.sheikhoo.url_shortener.modules.setting.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    private final SettingRepository settingRepository;

    @Autowired
    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }


    public Setting getSetting() {
        Setting setting=settingRepository.findById(1).orElse(null);
        if(setting==null){
            setting=new Setting();
            setting.setId(1);
            setting.setSite_title("Url Shortener");
            setting.setSite_discription("");
            setting.setSite_url("http://localhost:8080");
            setting.setNumberLinks(10);
            return settingRepository.save(setting);
        }else
            return settingRepository.getOne(1);
    }

}
