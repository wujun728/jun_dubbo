package com.freeter.modules.category.entity.view;

import java.util.List;

public class CategoryModel {
   private CategoryView firstCategory;//一级分类
   private List<CategoryView> secondCategory;//二级分类

    public CategoryView getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(CategoryView firstCategory) {
        this.firstCategory = firstCategory;
    }

    public List<CategoryView> getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(List<CategoryView> secondCategory) {
        this.secondCategory = secondCategory;
    }
}
