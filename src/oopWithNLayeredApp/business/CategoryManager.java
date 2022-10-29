package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.category.CategoryDao;
import oopWithNLayeredApp.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
//Bir islemi birden fazla alternatif ile yapabilmek yani herhangi birine bagimli kalmamak icin soyut sinif olan Interface yapilarini kullaniriz.
//Bu soyut sinifi dependency Injection yoluyla enjecte ettigimiz classta bu interface i implemnte etmis diger tum siniflar kullanabiliriz.
//Constructor blogunda Bu soyut sinifi miras alan hangi servisi kullanacagimizi belirterek o servis uzerinden islemlerimizi yapariz
//Boylece Manager sinifi o isi yapmak icin sadece bir sinifa bagimli kalmamais oldu

    private CategoryDao categoryDao;
    private List<Logger> loggers = new ArrayList<>();


    public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }


    public void add(Category category) throws Exception {
        // is kurallari
        boolean isRepeat = false;
        for (Category c : categoryDao.getCategories()) {
            if (category.getName().equals(c.getName())) {
                isRepeat = true;
            }

        }
        if (!isRepeat) {
            categoryDao.add(category);
        } else {
            throw new Exception("Kategori ismi tekrar edemez!");
        }

        for (Logger logger : loggers) {
            logger.log(category.getName());
        }
    }

    public void update(int id, Category category) {
        categoryDao.update(id, category);
    }

    public void delete(int id) {
        categoryDao.delete(id);
    }

    public Category findById(int id) {
        return categoryDao.getById(id);
    }

    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

}
	
	


