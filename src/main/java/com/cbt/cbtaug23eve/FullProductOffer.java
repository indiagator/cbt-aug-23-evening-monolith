package com.cbt.cbtaug23eve;

public class FullProductOffer {

    Product product;

    Productoffer productoffer;

    Userdetail sellerdetail;

    int totalprice;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public void setProductoffer(Productoffer productoffer) {
        this.productoffer = productoffer;
    }

    public void setSellerdetail(Userdetail sellerdetail) {
        this.sellerdetail = sellerdetail;
    }

    public Product getProduct() {
        return product;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public Productoffer getProductoffer() {
        return productoffer;
    }

    public Userdetail getSellerdetail() {
        return sellerdetail;
    }
}
