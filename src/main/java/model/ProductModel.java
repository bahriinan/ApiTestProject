package model;

import constants.TestData;

public class ProductModel {

    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {

        private String id = TestData.id;
        private String name = TestData.name;
        private String description = TestData.description;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductModel build() {

            ProductModel add = new ProductModel();
            add.id = this.id;
            add.name = this.name;
            add.description = this.description;
            return add;

        }

    }

}
