package oopWithNLayeredApp.dataAccess.category;

import oopWithNLayeredApp.entities.Category;

import java.util.List;

public interface CategoryDao {
    void add(Category category);

    void update(int id, Category category);

    void delete(int id);

    Category getById(int id);

    List<Category> getCategories();

}
