package com.springboot.jpa.data.dto;

public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;


    public static ProductResponseDtoBulder bulder(){

        return new ProductResponseDtoBulder();
    }

    public  static class ProductResponseDtoBulder{
        private Long number;
        private String name;
        private int price;
        private int stock;
        public ProductResponseDtoBulder() {
        }

        public ProductResponseDtoBulder number(Long number){
            this.number = number;
            return this;
        }


    }
}
