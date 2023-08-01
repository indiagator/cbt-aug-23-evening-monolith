package com.cbt.cbtaug23eve;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOfferService
{

    @Autowired
    ProductofferRepository productofferRepository;

    @Autowired
    UserdetailRepository userdetailRepository;

    @Autowired
    ProductRepository productRepository;

    public FullProductOffer composeFullOffer(String offerid)
    {
        FullProductOffer fullProductOffer = new FullProductOffer();
        Optional<Productoffer> offer;
        if((offer =  productofferRepository.findById(offerid)).isPresent())
        {
            fullProductOffer.setProductoffer(offer.get());
            fullProductOffer.setProduct(productRepository.findById(offer.get().getHscode()).get());
            fullProductOffer.setSellerdetail(userdetailRepository.findById(offer.get().getSellername()).get());
            fullProductOffer.setTotalprice(offer.get().getUnitprice()*offer.get().getQty());
        }
        return fullProductOffer;
    }
}
