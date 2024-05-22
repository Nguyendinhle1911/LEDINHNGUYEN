package com.example2.session10.entities;

public class OrderDetai {
        private int detailId;
        private Product product;
        private int quantity;

        public OrderDetai(int detailId, Product product, int quantity) {
            this.detailId = detailId;
            this.product = product;
            this.quantity = quantity;
        }

        // Getters and Setters
        public int getDetailId() {
            return detailId;
        } 

        public void setDetailId(int detailId) {
            this.detailId = detailId;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "OrderDetail{" +
                    "detailId=" + detailId +
                    ", product=" + product +
                    ", quantity=" + quantity +
                    '}';
        }
    }


