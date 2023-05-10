package com.springboot.jpa.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long number;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private Integer stock;

        private LocalDateTime createAt;

        private LocalDateTime updateAt;

        public Long getNumber() {
                return number;
        }

        public void setNumber(Long number) {
                this.number = number;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getStock() {
                return stock;
        }

        public void setStock(Integer stock) {
                this.stock = stock;
        }

        public LocalDateTime getCreateAt() {
                return createAt;
        }

        public void setCreateAt(LocalDateTime createAt) {
                this.createAt = createAt;
        }

        public LocalDateTime getUpdateAt() {
                return updateAt;
        }

        public void setUpdateAt(LocalDateTime updateAt) {
                this.updateAt = updateAt;
        }
}
