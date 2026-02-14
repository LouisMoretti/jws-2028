package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public class YakamonRepository implements PanacheRepository<YakamonModel> {
    public long yakamonCount() {
        return count();
    }

    @Transactional
    public void addYakamon(YakamonModel yakamon) {
        persist(yakamon);
    }

    public Stream<YakamonModel> getYakamons() {
        return findAll().stream();
    }

    public YakamonModel getYakamonFromUUID(UUID uuid) {
        if (uuid == null){
            ErrorCode.YAKAMON_NOT_FOUND_ERROR.throwException();
        }

        Optional<YakamonModel> optionalYakamonModel = find("uuid", uuid).singleResultOptional();
        if (optionalYakamonModel.isEmpty()) {
            ErrorCode.YAKAMON_NOT_FOUND_ERROR.throwException();
        }

        return optionalYakamonModel.get();
    }

    @Transactional
    public void deleteFromModel(YakamonModel model) {
        delete(model);
    }

    @Transactional
    public YakamonModel updateName(UUID uuid, String newNickname) {
        YakamonModel yakamon = getYakamonFromUUID(uuid);
        yakamon.setNickname(newNickname);
        return yakamon;
    }
}
