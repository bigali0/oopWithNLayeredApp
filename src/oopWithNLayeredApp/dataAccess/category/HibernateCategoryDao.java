package oopWithNLayeredApp.dataAccess.category;

import oopWithNLayeredApp.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class HibernateCategoryDao implements CategoryDao {
    private List<Category> categories = new ArrayList<>();

    @Override
    public void add(Category category) {

        categories.add(category);
        System.out.println("Kategori Hibetnate ile veritabanina eklendi");
    }

    @Override
    public void update(int id, Category category) {

        categories.set(id, category);
        System.out.println("Kategori guncellendi");

    }
    @Override
    public void delete(int id) {

        categories.remove(id);
        System.out.println("Kategori silindi");

    }

    @Override
    public Category getById(int id) {
        return categories.get(id - 1);
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
