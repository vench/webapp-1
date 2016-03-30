package tehnosila.model;

/**
 * Created by vench on 30.03.16.
 * Интерфейс сохранения, удаляения модели
 */
public interface IActiveModel {

    /**
     * Создаем или сохраняем
     * @param store
     */
    void save(IActiveModelStore store);

    /**
     * Удаляем
     * @param store
     */
    void delete(IActiveModelStore store);
}
