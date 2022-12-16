package ir.sheikhoo.url_shortener.modules.setting.repository;

import ir.sheikhoo.url_shortener.modules.setting.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting,Integer> {


}
